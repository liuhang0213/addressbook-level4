package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.person.Remark;

/**
 * Adds remark to a person identified using it's last displayed index from the address book.
 */
public class RemarkCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "remark";
    public static final String COMMAND_ALIAS = "re";

    public static final String MESSAGE_USAGE = COMMAND_WORD + "Edits the remark for a person"
            + "Parameters: INDEX (must be a positive integer), \n"
            + PREFIX_REMARK + "REMARK "
            + "Example: " + COMMAND_WORD + " 1"
            + PREFIX_REMARK + "Likes to drink coffee";

    public static final String MESSAGE_SUCCESS = "Remark updated for person: %1$s";

    private final Index targetIndex;

    /**
     * Creates a RemarkCommand
     */
    public RemarkCommand(Index targetIndex, Remark remark) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult executeUndoableCommand() throws CommandException {
        throw new CommandException("Command not implemented");
    }
}
