package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.member.Id;
import seedu.address.model.transaction.Transaction;

import java.util.Set;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TRANSACTION;

public class AddTransactionCommand extends AddCommand{
	public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a transaction to the ezFoodie. "
			+ "Parameters: "
			+ PREFIX_ID + "ID"
			+ "[" + PREFIX_TRANSACTION + "TRANSACTION AMOUNT(STRICTLY 2 DECIMAL PLACES)]...\n"
			+ "Example: " + COMMAND_WORD + " "
			+ PREFIX_ID + "00001 "
			+ PREFIX_TRANSACTION + "23.00 "
			+ PREFIX_TRANSACTION + "988.56";

	// todo: need to work on this
	public static final String MESSAGE_SUCCESS = "New transaction added.";

	private final Set<Transaction> transactionToAdd;
	private final Id idToAdd;

	/**
	 * Creates an AddCommand to add the specified {@code Member}
	 */
	public AddTransactionCommand(Set<Transaction> transaction, Id id) {
		requireNonNull(id);
		transactionToAdd = transaction;
		idToAdd = id;
	}

	@Override
	public CommandResult execute(Model model) {
		requireNonNull(model);
		model.addTransaction(transactionToAdd, idToAdd);
		return new CommandResult(String.format(MESSAGE_SUCCESS));
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof AddTransactionCommand // instanceof handles nulls
				&& transactionToAdd.equals(((AddTransactionCommand) other).transactionToAdd))
				&& idToAdd.equals(((AddTransactionCommand) other).idToAdd);
	}


}
