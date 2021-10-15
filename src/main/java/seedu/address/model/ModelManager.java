package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.member.Id;
import seedu.address.model.member.Member;
import seedu.address.model.transaction.Transaction;

/**
 * Represents the in-memory model of the ezFoodie data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final EzFoodie ezFoodie;
    private final UserPrefs userPrefs;
    private final FilteredList<Member> filteredMembers;

    /**
     * Initializes a ModelManager with the given ezFoodie and userPrefs.
     */
    public ModelManager(ReadOnlyEzFoodie ezFoodie, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(ezFoodie, userPrefs);

        logger.fine("Initializing with ezFoodie: " + ezFoodie + " and user prefs " + userPrefs);

        this.ezFoodie = new EzFoodie(ezFoodie);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredMembers = new FilteredList<>(this.ezFoodie.getMemberList());
    }

    public ModelManager() {
        this(new EzFoodie(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getEzFoodieFilePath() {
        return userPrefs.getEzFoodieFilePath();
    }

    @Override
    public void setEzFoodieFilePath(Path ezFoodieFilePath) {
        requireNonNull(ezFoodieFilePath);
        userPrefs.setEzFoodieFilePath(ezFoodieFilePath);
    }

    //=========== EzFoodie ===================================================================================

    @Override
    public void setEzFoodie(ReadOnlyEzFoodie ezFoodie) {
        this.ezFoodie.resetData(ezFoodie);
    }

    @Override
    public ReadOnlyEzFoodie getEzFoodie() {
        return ezFoodie;
    }

    @Override
    public boolean hasMember(Member member) {
        requireNonNull(member);
        return ezFoodie.hasMember(member);
    }

    @Override
    public boolean hasMember(Member member, Predicate<Member> predicate) {
        requireNonNull(member);
        return ezFoodie.hasMember(member, predicate);
    }

    @Override
    public void deleteMember(Member target) {
        ezFoodie.removeMember(target);
    }

    @Override
    public void addMember(Member member) {
        ezFoodie.addMember(member);
        updateFilteredMemberList(PREDICATE_SHOW_ALL_MEMBERS);
    }

    @Override
    public void addTransaction(Set<Transaction> transactionToAdd, Id id) {
        requireNonNull(id);

        ezFoodie.addTransaction(transactionToAdd, id);
    }

    @Override
    public void setMember(Member target, Member editedMember) {
        requireAllNonNull(target, editedMember);

        ezFoodie.setMember(target, editedMember);
    }

    //=========== Filtered Member List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Member} backed by the internal list of
     * {@code versionedEzFoodie}
     */
    @Override
    public ObservableList<Member> getFilteredMemberList() {
        return filteredMembers;
    }

    @Override
    public void updateFilteredMemberList(Predicate<Member> predicate) {
        requireNonNull(predicate);
        filteredMembers.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return ezFoodie.equals(other.ezFoodie)
                && userPrefs.equals(other.userPrefs)
                && filteredMembers.equals(other.filteredMembers);
    }

}
