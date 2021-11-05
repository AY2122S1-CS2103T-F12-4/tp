package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDEX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REDEEM;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_MEMBERS;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.Timestamp;
import seedu.address.model.member.Address;
import seedu.address.model.member.Credit;
import seedu.address.model.member.Email;
import seedu.address.model.member.Id;
import seedu.address.model.member.Member;
import seedu.address.model.member.Name;
import seedu.address.model.member.Phone;
import seedu.address.model.member.Point;
import seedu.address.model.reservation.Reservation;
import seedu.address.model.tag.Tag;
import seedu.address.model.transaction.Transaction;

/**
 * Redeems point from an existing member in the ezFoodie.
 */
public class RedeemCommand extends Command {

    /**
     * Stands for redeem command.
     */
    public static final String COMMAND_WORD = "redeem";

    /**
     * Stands for the message of redeem command.
     */
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Redeems points from member id in the ezFoodie. "
            + "Parameters: "
            + PREFIX_REDEEM + " [points]"
            + " " + PREFIX_ID + " [ID] or "
            + "Parameters: "
            + PREFIX_REDEEM + " [points]"
            + " " + PREFIX_INDEX + " [INDEX]\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_REDEEM + " 100 "
            + PREFIX_ID + " 10001\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_REDEEM + " 100 "
            + PREFIX_INDEX + " 1\n";
    
    /**
     * Stands for message for redeem points successfully.
     */
    public static final String MESSAGE_SUCCESS_REDEMPTION = "Redeemed Member: %1$s";

    /**
     * Stands for message for duplicate member.
     */
    public static final String MESSAGE_DUPLICATE_MEMBER = "This member already exists in the ezFoodie.";

    /**
     * Stands for message when redemption point exceed.
     */
    public static final String MESSAGE_INVALID_POINTS_LESS_THAN_ZERO = "Redeemed point has already exceeded\n"
            + "Points can't redeemed less than 0\n"
            + "Please try again";

    private final List<Point> pointsToRedeemList = new ArrayList<>();
    private final Id idToRedeem;
    private final Index indexToRedeem;

    /**
     * Constructs an RedeemCommand to add the specified {@code Member} by id.
     *
     * @param pointsToRedeemList the points of to redeemed list.
     * @param id the member id that needs to redeem point.
     */
    public RedeemCommand(List<Point> pointsToRedeemList, Id id) {
        requireAllNonNull(pointsToRedeemList, id);
        this.pointsToRedeemList.addAll(pointsToRedeemList);
        this.idToRedeem = id;
        this.indexToRedeem = null;
    }

    /**
     * Constructs an RedeemCommand to add the specified {@code Member} by index.
     *
     * @param pointsToRedeemList the points of to redeemed list.
     * @param index the member index that needs to redeem point.
     */
    public RedeemCommand(List<Point> pointsToRedeemList, Index index) {
        requireAllNonNull(pointsToRedeemList, index);
        this.pointsToRedeemList.addAll(pointsToRedeemList);
        this.indexToRedeem = index;
        this.idToRedeem = null;
    }

    /**
     * Overrides and executes the model.
     *
     * @param model {@code Model} which the command should operate on.
     * @return CommandResult related to redeem command.
     * @throws CommandException
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Member> lastShownList = model.getUpdatedMemberList();

        Member memberToEdit = null;
        if (indexToRedeem != null) {
            if (indexToRedeem.getZeroBased() < lastShownList.size()) {
                memberToEdit = lastShownList.get(indexToRedeem.getZeroBased());
            } else {
                throw new CommandException(Messages.MESSAGE_INVALID_MEMBER_DISPLAYED_INDEX);
            }
        }
        if (idToRedeem != null) {
            memberToEdit = lastShownList.stream()
                    .filter(member -> idToRedeem.equals(member.getId())).findAny().orElse(null);
        }
        if (memberToEdit != null) {
            Member toRedeemPointsMember = createToRedeemPointsMember(memberToEdit, pointsToRedeemList);
            if (model.hasMember(toRedeemPointsMember, member -> member.getId() != toRedeemPointsMember.getId())) {
                throw new CommandException(MESSAGE_DUPLICATE_MEMBER);
            }
            model.setMember(memberToEdit, toRedeemPointsMember);
            model.updateFilteredMemberList(PREDICATE_SHOW_ALL_MEMBERS);
            return new CommandResult(String.format(MESSAGE_SUCCESS_REDEMPTION, toRedeemPointsMember));
        } else {
            throw new CommandException(Messages.MESSAGE_INVALID_MEMBER_DISPLAYED_ID);
        }
    }

    /**
     * Creates and returns a {@code Member} with the details of {@code memberToEdit}
     * edited with {@code editMemberDescriptor}.
     *
     * @param memberToRedeemPoints creates the member who need to be redeemed points.
     * @param toRedeemPointsList the list of points need to redeem all.
     * @return Member with redeemed Points
     * @throws CommandException
     */
    private static Member createToRedeemPointsMember(Member memberToRedeemPoints, List<Point> toRedeemPointsList)
            throws CommandException {
        assert memberToRedeemPoints != null;

        Id id = memberToRedeemPoints.getId();
        Name updatedName = memberToRedeemPoints.getName();
        Phone updatedPhone = memberToRedeemPoints.getPhone();
        Email updatedEmail = memberToRedeemPoints.getEmail();
        Address updatedAddress = memberToRedeemPoints.getAddress();
        Timestamp updateTimestamp = memberToRedeemPoints.getTimestamp();
        Set<Tag> updatedTags = memberToRedeemPoints.getTags();
        List<Transaction> updatedTransactions = memberToRedeemPoints.getTransactions();
        List<Reservation> updateReservations = memberToRedeemPoints.getReservations();
        Credit updateCredit = memberToRedeemPoints.getCredit();
        Point toRedeemPointsSum = new Point("" + Math.min(toRedeemPointsList.stream()
                .mapToInt(pointToUpdate -> (int) pointToUpdate.getDoubleValue()).sum(), Point.MAX));
        int oldPoint = memberToRedeemPoints.getPoint().getIntValue();
        int toRedeemPoint = toRedeemPointsSum.getIntValue();
        if (oldPoint < toRedeemPoint) {
            throw new CommandException(MESSAGE_INVALID_POINTS_LESS_THAN_ZERO);
        }
        Point updatePoint = new Point(String.valueOf(oldPoint - toRedeemPoint));
        return new Member(id, updatedName, updatedPhone, updatedEmail, updatedAddress, updateTimestamp, updateCredit,
                updatePoint, updatedTransactions, updateReservations, updatedTags);
    }
}
