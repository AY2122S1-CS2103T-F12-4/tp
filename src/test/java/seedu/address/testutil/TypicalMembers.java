package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CREDIT_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CREDIT_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ID_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ID_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_POINT_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_POINT_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REGISTRATION_TIMESTAMP_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_REGISTRATION_TIMESTAMP_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RESERVATION_DATE_TIME_200;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RESERVATION_DATE_TIME_300;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RESERVATION_ID_200_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RESERVATION_ID_200_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RESERVATION_ID_300_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RESERVATION_REMARK_200;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RESERVATION_REMARK_300;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSACTION_BILLING_200;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSACTION_BILLING_300;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSACTION_ID_200_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSACTION_ID_200_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSACTION_ID_300_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSACTION_TIMESTAMP_200;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TRANSACTION_TIMESTAMP_300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.EzFoodie;
import seedu.address.model.Timestamp;
import seedu.address.model.member.Member;
import seedu.address.model.reservation.DateTime;
import seedu.address.model.reservation.Remark;
import seedu.address.model.reservation.Reservation;
import seedu.address.model.transaction.Billing;
import seedu.address.model.transaction.Transaction;

/**
 * A utility class containing a list of {@code Member} objects to be used in tests.
 */
public class TypicalMembers {

    public static final Member ALICE = new MemberBuilder().withId("00001").withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253").withTimestamp("1609459200000").withCredit("610").withPoint("610")
            .withTransactions(
                    new Transaction(new seedu.address.model.transaction.Id("000001"), new Timestamp("1611100800000"),
                            new Billing("567.54")),
                    new Transaction(new seedu.address.model.transaction.Id("000002"), new Timestamp("1611187200000"),
                            new Billing("43.34"))
            ).withReservations(
                    new Reservation(
                            new seedu.address.model.reservation.Id("000001"), new DateTime("2021-01-20 00:00"),
                            new Remark("3 people")),
                    new Reservation(
                            new seedu.address.model.reservation.Id("000002"), new DateTime("2021-01-21 00:00"),
                            new Remark("1 people"))
            ).withTags("friends").build();
    public static final Member BENSON = new MemberBuilder().withId("00002").withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25").withEmail("johnd@example.com")
            .withPhone("98765432").withTimestamp("1609462800000").withCredit("645").withPoint("645")
            .withTransactions(new Transaction(new seedu.address.model.transaction.Id("000001"),
                    new Timestamp("1611104400000"), new Billing("645.39")))
            .withReservations(new Reservation(new seedu.address.model.reservation.Id("000001"),
                    new DateTime("2021-01-20 01:00"), new Remark("4 people")))
            .withTags("owesMoney", "friends").build();
    public static final Member CARL = new MemberBuilder().withId("00003").withName("Carl Kurz")
            .withPhone("95352563").withEmail("heinz@example.com").withAddress("wall street")
            .withTimestamp("1609466400000").withCredit("272").withPoint("272")
            .withTransactions(new Transaction(new seedu.address.model.transaction.Id("000001"),
                    new Timestamp("1611108000000"), new Billing("272.57")))
            .withReservations(new Reservation(new seedu.address.model.reservation.Id("000001"),
                    new DateTime("2021-01-20 02:00"), new Remark("2 people"))).build();
    public static final Member DANIEL = new MemberBuilder().withId("00004").withName("Daniel Meier")
            .withPhone("87652533").withEmail("cornelia@example.com").withAddress("10th street")
            .withTimestamp("1609470000000").withCredit("0").withPoint("0").withTags("friends").build();
    public static final Member ELLE = new MemberBuilder().withId("00005").withName("Elle Meyer")
            .withPhone("94821224").withEmail("werner@example.com").withAddress("michegan ave")
            .withTimestamp("1609473600000").withCredit("0").withPoint("0").build();
    public static final Member FIONA = new MemberBuilder().withId("00006").withName("Fiona Kunz")
            .withPhone("94824427").withEmail("lydia@example.com").withAddress("little tokyo")
            .withTimestamp("1609477200000").withCredit("0").withPoint("0").build();
    public static final Member GEORGE = new MemberBuilder().withId("00007").withName("George Best")
            .withPhone("94821442").withEmail("anna@example.com").withAddress("4th street")
            .withTimestamp("1609480800000").withCredit("0").withPoint("0").build();

    // Manually added
    public static final Member HOON = new MemberBuilder().withId("00008").withName("Hoon Meier")
            .withPhone("84824241").withEmail("stefan@example.com").withAddress("little india")
            .withTimestamp("1609484400000").withCredit("0").withPoint("0").build();
    public static final Member IDA = new MemberBuilder().withId("00009").withName("Ida Mueller")
            .withPhone("84821314").withEmail("hans@example.com").withAddress("chicago ave")
            .withTimestamp("1609488000000").withCredit("0").withPoint("0").build();

    // Manually added - Member's details found in {@code CommandTestUtil}
    public static final Member AMY = new MemberBuilder().withId(VALID_ID_AMY).withName(VALID_NAME_AMY)
            .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
            .withTimestamp(VALID_REGISTRATION_TIMESTAMP_AMY).withCredit(VALID_CREDIT_AMY).withPoint(VALID_POINT_AMY)
            .withTransactions(new Transaction(new seedu.address.model.transaction.Id(VALID_TRANSACTION_ID_200_AMY),
                    new Timestamp(VALID_TRANSACTION_TIMESTAMP_200),
                    new Billing(VALID_TRANSACTION_BILLING_200)))
            .withReservations(new Reservation(new seedu.address.model.reservation.Id(VALID_RESERVATION_ID_200_AMY),
                    new DateTime(VALID_RESERVATION_DATE_TIME_200),
                    new Remark(VALID_RESERVATION_REMARK_200)))
            .withTags(VALID_TAG_FRIEND).build();
    public static final Member BOB = new MemberBuilder().withId(VALID_ID_BOB).withName(VALID_NAME_BOB)
            .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
            .withTimestamp(VALID_REGISTRATION_TIMESTAMP_BOB).withCredit(VALID_CREDIT_BOB).withPoint(VALID_POINT_BOB)
            .withTransactions(
                    new Transaction(new seedu.address.model.transaction.Id(VALID_TRANSACTION_ID_200_BOB),
                            new Timestamp(VALID_TRANSACTION_TIMESTAMP_200), new Billing(VALID_TRANSACTION_BILLING_200)),
                    new Transaction(new seedu.address.model.transaction.Id(VALID_TRANSACTION_ID_300_BOB),
                            new Timestamp(VALID_TRANSACTION_TIMESTAMP_300), new Billing(VALID_TRANSACTION_BILLING_300)))
            .withReservations(
                    new Reservation(new seedu.address.model.reservation.Id(VALID_RESERVATION_ID_200_BOB),
                            new DateTime(VALID_RESERVATION_DATE_TIME_200),
                            new Remark(VALID_RESERVATION_REMARK_200)),
                    new Reservation(new seedu.address.model.reservation.Id(VALID_RESERVATION_ID_300_BOB),
                            new DateTime(VALID_RESERVATION_DATE_TIME_300),
                            new Remark(VALID_RESERVATION_REMARK_300)))
            .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalMembers() {} // prevents instantiation

    /**
     * Returns an {@code EzFoodie} with all the typical members.
     */
    public static EzFoodie getTypicalEzFoodie() {
        EzFoodie ef = new EzFoodie();
        for (Member member : getTypicalMembers()) {
            ef.addMember(member);
        }
        return ef;
    }

    public static List<Member> getTypicalMembers() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
