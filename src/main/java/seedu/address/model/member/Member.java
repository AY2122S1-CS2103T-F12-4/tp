package seedu.address.model.member;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;
import seedu.address.model.transaction.Transaction;

/**
 * Represents a Member in the ezFoodie.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Member {

    // Identity fields
    private final Id id;
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final RegistrationTimestamp registrationTimestamp;
    private final Set<Tag> tags = new HashSet<>();
    private final Set<Transaction> transactions = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Member(Id id, Name name, Phone phone, Email email, Address address,
                  RegistrationTimestamp registrationTimestamp, Set<Tag> tags, Set<Transaction> transactions) {
        requireAllNonNull(id, name, phone, email, address, registrationTimestamp, tags, transactions);
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.registrationTimestamp = registrationTimestamp;
        this.tags.addAll(tags);
        this.transactions.addAll(transactions);
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public RegistrationTimestamp getRegistrationTimestamp() {
        return registrationTimestamp;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns an immutable transaction set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Transaction> getTransactions() {
        return Collections.unmodifiableSet(transactions);
    }

    public void addTransactions(Set<Transaction> newTrans) {
        transactions.addAll(newTrans);
    }

    /**
     * Returns true if both members have the same id, phone or email.
     * This defines a weaker notion of equality between two members.
     */
    public boolean isSameMember(Member otherMember) {
        if (otherMember == this) {
            return true;
        }

        return otherMember != null
                && (isSameId(otherMember) || isSameEmail(otherMember) || isSamePhone(otherMember));
    }

    /**
     * Returns true if both members have the same id.
     * This defines a weaker notion of equality between two members.
     */
    public boolean isSameId(Member otherMember) {
        if (otherMember == this) {
            return true;
        }

        return otherMember != null
                && otherMember.getId().equals(getId());
    }

    /**
     * Returns true if both members have the same phone.
     * This defines a weaker notion of equality between two members.
     */
    public boolean isSamePhone(Member otherMember) {
        if (otherMember == this) {
            return true;
        }

        return otherMember != null
                && otherMember.getPhone().equals(getPhone());
    }

    /**
     * Returns true if both members have the same email.
     * This defines a weaker notion of equality between two members.
     */
    public boolean isSameEmail(Member otherMember) {
        if (otherMember == this) {
            return true;
        }

        return otherMember != null
                && otherMember.getEmail().equals(getEmail());
    }

    /**
     * Returns true if both members have the same identity and data fields.
     * This defines a stronger notion of equality between two members.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Member)) {
            return false;
        }

        Member otherMember = (Member) other;
        return otherMember.getId().equals(getId())
                && otherMember.getName().equals(getName())
                && otherMember.getPhone().equals(getPhone())
                && otherMember.getEmail().equals(getEmail())
                && otherMember.getAddress().equals(getAddress())
                && otherMember.getTags().equals(getTags())
                && otherMember.getTransactions().equals(getTransactions());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(id, name, phone, email, address, tags, transactions);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Id: ")
                .append(getId())
                .append("; Name: ")
                .append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Address: ")
                .append(getAddress())
                .append("; Registration Timestamp: ")
                .append(getRegistrationTimestamp());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }

        Set<Transaction> transactions = getTransactions();
        if (!transactions.isEmpty()) {
            builder.append("; Transactions: ");
            transactions.forEach(builder::append);
        }
        return builder.toString();
    }

}
