package seedu.address.logic.commands;

/**
 * Adds information to the eZFoodie.
 */
public abstract class AddCommand extends Command {

	public static final String COMMAND_WORD = "add";
	public static final String ADD_MEMBER_PREFIX = "-m";
	public static final String ADD_TRANSACTION_PREFIX = "-txn";
	public static final String MESSAGE_USAGE = COMMAND_WORD + ": adds a member or a transaction to the ezFoodie.\n"
			+ "With "
			+ ADD_MEMBER_PREFIX + " or "
			+ ADD_TRANSACTION_PREFIX;
}
