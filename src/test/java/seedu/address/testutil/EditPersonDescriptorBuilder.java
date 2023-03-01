package seedu.address.testutil;

import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.editApplicantDescriptor;
import seedu.address.model.applicant.*;
import seedu.address.model.tag.Tag;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A utility class to help with building editApplicantDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private editApplicantDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new editApplicantDescriptor();
    }

    public EditPersonDescriptorBuilder(EditCommand.editApplicantDescriptor descriptor) {
        this.descriptor = new editApplicantDescriptor(descriptor);
    }

    /**
     * Returns an {@code editApplicantDescriptor} with fields containing {@code applicant}'s details
     */
    public EditPersonDescriptorBuilder(Applicant applicant) {
        descriptor = new editApplicantDescriptor();
        descriptor.setName(applicant.getName());
        descriptor.setPhone(applicant.getPhone());
        descriptor.setEmail(applicant.getEmail());
        descriptor.setAddress(applicant.getAddress());
        descriptor.setTags(applicant.getNotes());
    }

    /**
     * Sets the {@code Name} of the {@code editApplicantDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code editApplicantDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code editApplicantDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code editApplicantDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code editApplicantDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditCommand.editApplicantDescriptor build() {
        return descriptor;
    }
}
