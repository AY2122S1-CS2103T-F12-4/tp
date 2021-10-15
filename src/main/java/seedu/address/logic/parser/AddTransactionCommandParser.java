package seedu.address.logic.parser;

import seedu.address.logic.commands.AddTransactionCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.member.*;
import seedu.address.model.transaction.Transaction;

import java.util.Set;
import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddTransactionCommandParser implements Parser<AddTransactionCommand> {

	/**
	 * Parses the given {@code String} of arguments in the context of the AddTransactionCommand
	 * and returns an AddTransactionCommand object for execution.
	 */
	public AddTransactionCommand parse(String args) throws ParseException {
		ArgumentMultimap argMultimap =
				ArgumentTokenizer.tokenize(args, PREFIX_ID, PREFIX_TRANSACTION);

		if (!argMultimap.getPreamble().isEmpty()) {
			throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddTransactionCommand.MESSAGE_USAGE));
		}

		Id id = ParserUtil.parseId(argMultimap.getValue(PREFIX_ID).get());
		Set<Transaction> transactionList = ParserUtil.parseTransactions(argMultimap.getAllValues(PREFIX_TRANSACTION));

		return new AddTransactionCommand(transactionList, id);
	}

	/**
	 * Returns true if none of the prefixes contains empty {@code Optional} values in the given
	 * {@code ArgumentMultimap}.
	 */
	private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
		return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
	}

}
