package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.model.applicant.Applicant;
import seedu.address.model.tag.Tag;

/**
 * A utility class for Applicant.
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code applicant}.
     */
    public static String getAddCommand(Applicant applicant) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(applicant);
    }

    /**
     * Returns the part of command string for the given {@code applicant}'s details.
     */
    public static String getPersonDetails(Applicant applicant) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + applicant.getName().fullName + " ");
        sb.append(PREFIX_PHONE + applicant.getPhone().value + " ");
        sb.append(PREFIX_EMAIL + applicant.getEmail().value + " ");
        sb.append(PREFIX_ADDRESS + applicant.getAddress().value + " ");
        applicant.getNotes().stream().forEach(
            s -> sb.append(PREFIX_NOTE + s.tagName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code editApplicantDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditCommand.editApplicantDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        descriptor.getPhone().ifPresent(phone -> sb.append(PREFIX_PHONE).append(phone.value).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
        descriptor.getAddress().ifPresent(address -> sb.append(PREFIX_ADDRESS).append(address.value).append(" "));
        if (descriptor.getTags().isPresent()) {
            Set<Tag> tags = descriptor.getTags().get();
            if (tags.isEmpty()) {
                sb.append(PREFIX_NOTE);
            } else {
                tags.forEach(s -> sb.append(PREFIX_NOTE).append(s.tagName).append(" "));
            }
        }
        return sb.toString();
    }
}
