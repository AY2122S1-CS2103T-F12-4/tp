package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.Arrays;
import java.util.stream.Stream;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
            ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE);

        if ((argMultimap.getValue(PREFIX_NAME).isEmpty() && argMultimap.getValue(PREFIX_PHONE).isEmpty())
                || (argMultimap.getValue(PREFIX_NAME).isPresent() && argMultimap.getValue(PREFIX_PHONE).isPresent())) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            String trimmedArgs = argMultimap.getValue(PREFIX_NAME).get().trim();
            if (!trimmedArgs.isEmpty()) {
                String[] nameKeywords = trimmedArgs.split("\\s+");
                return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
            }
        }
        if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
            String trimmedArgs = argMultimap.getValue(PREFIX_PHONE).get().trim();
            if (!trimmedArgs.isEmpty()) {
                String[] phoneKeywords = trimmedArgs.split("\\s+");
                return new FindCommand(new PhoneContainsKeywordsPredicate(Arrays.asList(phoneKeywords)));
            }
        }

        throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
