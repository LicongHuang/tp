package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.model.Model;
import seedu.address.model.person.Person;


/**
 * Lists all persons in the address book to the user.
 */
public class ListLeadCommand extends Command {

    public static final String COMMAND_WORD = "listlead";
    public static final String MESSAGE_SUCCESS = "Listed all leads";

    public static final Predicate<Person> LEAD_TAG_PREDICATE = person -> person.isLead();

    private static final Logger logger = LogsCenter.getLogger(ListLeadCommand.class);

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        model.updateFilteredPersonList(LEAD_TAG_PREDICATE);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

