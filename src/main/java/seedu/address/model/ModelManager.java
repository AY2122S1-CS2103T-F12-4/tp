package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

    private final Account account;
    private final EzFoodie ezFoodie;
    private final UserPrefs userPrefs;
    private final FilteredList<Member> filteredMembers;
    private final SortedList<Member> sortedMembers;

    /**
     * Initializes a ModelManager with the given account, ezFoodie and userPrefs.
     */
    public ModelManager(ReadOnlyAccount account, ReadOnlyEzFoodie ezFoodie, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(account, ezFoodie, userPrefs);

        logger.fine("Initializing with account: " + account + ", + ezFoodie: " + ezFoodie
                + " and user prefs " + userPrefs);

        this.account = new Account(account);
        this.ezFoodie = new EzFoodie(ezFoodie);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredMembers = new FilteredList<>(this.ezFoodie.getMemberList());
        sortedMembers = new SortedList<>(filteredMembers); // Wrap the FilteredList in a SortedList
    }

    public ModelManager() {
        this(new Account(), new EzFoodie(), new UserPrefs());
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
    public Path getAccountFilePath() {
        return userPrefs.getAccountFilePath();
    }

    @Override
    public void setAccountFilePath(Path accountFilePath) {
        requireNonNull(accountFilePath);
        userPrefs.setAccountFilePath(accountFilePath);
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

    //=========== Account ====================================================================================

    @Override
    public void setAccount(ReadOnlyAccount account) {
        requireNonNull(account);
        this.account.resetData(account);
    }

    @Override
    public ReadOnlyAccount getAccount() {
        return account;
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
    public void setMember(Member target, Member editedMember) {
        requireAllNonNull(target, editedMember);

        ezFoodie.setMember(target, editedMember);
    }

    @Override
    public void addTransaction(Set<Transaction> transactionToAdd, Id id) {
        requireNonNull(id);
        ezFoodie.addTransaction(transactionToAdd, id);
    }

    /**
     * Returns an unmodifiable view of the list of {@code Member} backed by the internal list of
     * {@code versionedEzFoodie}
     */
    @Override
    public ObservableList<Member> getUpdatedMemberList() {
        return sortedMembers;
    }

    //=========== Filtered Member List Accessors =============================================================

    @Override
    public void updateFilteredMemberList(Predicate<Member> predicate) {
        requireNonNull(predicate);
        filteredMembers.setPredicate(predicate);
    }

    //=========== Sorted Member List Accessors ===============================================================

    @Override
    public void updateSortedMemberList(Comparator<Member> comparator) {
        requireNonNull(comparator);
        sortedMembers.setComparator(comparator);
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
                && filteredMembers.equals(other.filteredMembers)
                && sortedMembers.equals(other.sortedMembers);
    }

}
