package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.ExecutionStatus;
import seedu.address.logic.commands.*;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;

/**
 * Parses user input.
 */
public class EzFoodieParser {

	/**
	 * Used for initial separation of command word and args.
	 */
	private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

	private final Model model;
	private final ExecutionStatus executionStatus;

	/**
	 * Constructs a {@code EzFoodieParser} with the given {@code Model}.
	 */
	public EzFoodieParser(Model model) {
		this.model = model;
		this.executionStatus = ExecutionStatus.NORMAL;
	}

	/**
	 * Constructs a {@code EzFoodieParser} with the given {@code Model} and {@code ExecutionStatus}.
	 */
	public EzFoodieParser(Model model, ExecutionStatus executionStatus) {
		this.model = model;
		this.executionStatus = executionStatus;
	}

	/**
	 * Parses user input into command for execution.
	 *
	 * @param userInput full user input string
	 * @return the command based on the user input
	 * @throws ParseException if the user input does not conform the expected format
	 */
	public Command parseCommand(String userInput) throws ParseException {
		final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
		if (!matcher.matches()) {
			throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
		}

		final String commandWord = matcher.group("commandWord");
		final String arguments = matcher.group("arguments");
		switch (commandWord) {

		case AddMemberCommand.COMMAND_WORD:
			String addCommandPrefix = AddCommandPrefixExtractor.extract(arguments);

			switch (addCommandPrefix) {

			case AddCommand.ADD_MEMBER_PREFIX:
				return new AddMemberCommandParser(model, executionStatus).parse(arguments);

			case AddCommand.ADD_TRANSACTION_PREFIX:
				return new AddTransactionCommandParser().parse(arguments);

			default:
				throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
			}

		case EditCommand.COMMAND_WORD:
			return new EditCommandParser().parse(arguments);

		case DeleteCommand.COMMAND_WORD:
			return new DeleteCommandParser().parse(arguments);

		case ClearCommand.COMMAND_WORD:
			return new ClearCommand();

		case FindCommand.COMMAND_WORD:
			return new FindCommandParser().parse(arguments);

		case ListCommand.COMMAND_WORD:
			return new ListCommand();

		case ExitCommand.COMMAND_WORD:
			return new ExitCommand();

		case HelpCommand.COMMAND_WORD:
			return new HelpCommand();

		default:
			throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
		}
	}

}
