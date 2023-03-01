package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.applicant.Applicant;
import seedu.address.model.applicant.exceptions.DuplicateApplicantException;
import seedu.address.testutil.PersonBuilder;

public class ApplicantListTest {

    private final ApplicantList applicantList = new ApplicantList();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), applicantList.getPersonList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> applicantList.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        ApplicantList newData = getTypicalAddressBook();
        applicantList.resetData(newData);
        assertEquals(newData, applicantList);
    }

    @Test
    public void resetData_withDuplicatePersons_throwsDuplicatePersonException() {
        // Two applicants with the same identity fields
        Applicant editedAlice = new PersonBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Applicant> newApplicants = Arrays.asList(ALICE, editedAlice);
        ApplicantListStub newData = new ApplicantListStub(newApplicants);

        assertThrows(DuplicateApplicantException.class, () -> applicantList.resetData(newData));
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> applicantList.hasPerson(null));
    }

    @Test
    public void hasPerson_personNotInAddressBook_returnsFalse() {
        assertFalse(applicantList.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personInAddressBook_returnsTrue() {
        applicantList.addPerson(ALICE);
        assertTrue(applicantList.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personWithSameIdentityFieldsInAddressBook_returnsTrue() {
        applicantList.addPerson(ALICE);
        Applicant editedAlice = new PersonBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(applicantList.hasPerson(editedAlice));
    }

    @Test
    public void getPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> applicantList.getPersonList().remove(0));
    }

    /**
     * A stub ReadOnlyApplicantList whose applicants list can violate interface constraints.
     */
    private static class ApplicantListStub implements ReadOnlyApplicantList {
        private final ObservableList<Applicant> applicants = FXCollections.observableArrayList();

        ApplicantListStub(Collection<Applicant> applicants) {
            this.applicants.setAll(applicants);
        }

        @Override
        public ObservableList<Applicant> getPersonList() {
            return applicants;
        }
    }

}
