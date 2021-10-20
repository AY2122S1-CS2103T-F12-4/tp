package seedu.address.model;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.member.Id;
import seedu.address.model.member.Member;
import seedu.address.model.transaction.Transaction;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Member> PREDICATE_SHOW_ALL_MEMBERS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' account path.
     */
    Path getAccountFilePath();

    /**
     * Sets the user prefs' account path.
     */
    void setAccountFilePath(Path accountFilePath);

    /**
     * Returns the user prefs' ezFoodie file path.
     */
    Path getEzFoodieFilePath();

    /**
     * Sets the user prefs' ezFoodie file path.
     */
    void setEzFoodieFilePath(Path ezFoodieFilePath);

    /**
     * Replaces account with the data in {@code account}.
     */
    void setAccount(ReadOnlyAccount account);

    /** Returns the Account */
    ReadOnlyAccount getAccount();

    /**
     * Replaces ezFoodie data with the data in {@code ezFoodie}.
     */
    void setEzFoodie(ReadOnlyEzFoodie ezFoodie);

    /** Returns the EzFoodie */
    ReadOnlyEzFoodie getEzFoodie();

    /**
     * Returns true if a member with the same identity as {@code member} exists in the ezFoodie.
     */
    boolean hasMember(Member member);

    /**
     * Returns true if a member with the same identity as {@code member} exists in the filtered ezFoodie.
     * {@code predicate} is the filter condition for the filtered ezFoodie.
     */
    boolean hasMember(Member member, Predicate<Member> predicate);

    /**
     * Deletes the given member.
     * The member must exist in the ezFoodie.
     */
    void deleteMember(Member target);

    /**
     * Adds the given member.
     * {@code member} must not already exist in the ezFoodie.
     */
    void addMember(Member member);

    /**
     * Adds the given transaction(s) to a specific member.
     */
    void addTransaction(Set<Transaction> transactionToAdd, Id idToAdd);

    /**
     * Replaces the given member {@code target} with {@code editedMember}.
     * {@code target} must exist in the ezFoodie.
     * The member identity of {@code editedMember} must not be the same as another existing member in the ezFoodie.
     */
    void setMember(Member target, Member editedMember);

    /** Returns an unmodifiable view of the sorted or filtered member list */
    ObservableList<Member> getUpdatedMemberList();

    /**
     * Updates the filter of the filtered member list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredMemberList(Predicate<Member> predicate);

    /**
     * Updates the sort of the sorted member list to sort by the given {@code comparator}.
     * @throws NullPointerException if {@code comparator} is null.
     */
    void updateSortedMemberList(Comparator<Member> comparator);
}
