package seedu.address.logic.parser;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

/**
 * Extracts prefix to distinguish between add member and add transaction.
 */
public class AddCommandPrefixExtractor {

	public static String extract(String args) throws ParseException {
		String trimmedArgs = args.trim();
		if (trimmedArgs.isEmpty()) {
			throw new ParseException(
					String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
		}

		int index = trimmedArgs.indexOf(' ');
		if (index > -1) { // Check if there is more than one word.
			return trimmedArgs.substring(0, index).trim(); // Extract first word.
		} else {
			return trimmedArgs; // Extracted word is the first word itself.
		}
	}
}
