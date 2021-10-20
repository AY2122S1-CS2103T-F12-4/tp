package seedu.address.logic.parser;

import seedu.address.logic.commands.AddMemberCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new AddMemberCommand object
 */
public abstract class AddCommandParser {
    public abstract AddMemberCommand parse(String args) throws ParseException;
}
