package seedu.address.model.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.Meeting;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyMeetingList;
import seedu.address.model.UniqueMeetingList;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.InternalId;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.SearchData;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        try {
            return new Person[] {
                new Person(new InternalId(1), new Name("Alex Yeoh"), new Phone("87438807"),
                    new Email("alexyeoh@example.com"), new Address("Blk 30 Geylang Street 29, #06-40"),
                    getTagSet("friends"), new SearchData("0")),
                new Person(new InternalId(2), new Name("Bernice Yu"), new Phone("99272758"),
                    new Email("berniceyu@example.com"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    getTagSet("colleagues", "friends"), new SearchData("0")),
                new Person(new InternalId(3), new Name("Charlotte Oliveiro"), new Phone("93210283"),
                    new Email("charlotte@example.com"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    getTagSet("neighbours"), new SearchData("0")),
                new Person(new InternalId(4), new Name("David Li"), new Phone("91031282"),
                    new Email("lidavid@example.com"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    getTagSet("family"), new SearchData("0")),
                new Person(new InternalId(5), new Name("Irfan Ibrahim"), new Phone("92492021"),
                    new Email("irfan@example.com"), new Address("Blk 47 Tampines Street 20, #17-35"),
                    getTagSet("classmates"), new SearchData("0")),
                new Person(new InternalId(6), new Name("Roy Balakrishnan"), new Phone("92624417"),
                    new Email("royb@example.com"), new Address("Blk 45 Aljunied Street 85, #11-31"),
                    getTagSet("colleagues"), new SearchData("0"))
            };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        try {
            AddressBook sampleAb = new AddressBook();
            for (Person samplePerson : getSamplePersons()) {
                sampleAb.addPerson(samplePerson);
            }
            return sampleAb;
        } catch (DuplicatePersonException e) {
            throw new AssertionError("sample data cannot contain duplicate persons", e);
        }
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) throws IllegalValueException {
        HashSet<Tag> tags = new HashSet<>();
        for (String s : strings) {
            tags.add(new Tag(s));
        }

        return tags;
    }

    public static ReadOnlyMeetingList getSampleMeetingList() {
        try {
            UniqueMeetingList meetings = new UniqueMeetingList();
            for (Meeting sampleMeeting : getSampleMeetings()) {
                meetings.add(sampleMeeting);
            }
            return meetings;
        } catch (UniqueMeetingList.DuplicateMeetingException e) {
            throw new AssertionError("sample data cannot contain duplicate meetings", e);
        }
    }

    public static Meeting[] getSampleMeetings() {
        try {
            ArrayList<InternalId> sampleParticipantsList = new ArrayList<>();
            sampleParticipantsList.add(new InternalId(1));
            sampleParticipantsList.add(new InternalId(2));
            LocalDateTime now = LocalDateTime.now();
            return new Meeting[] {
                new Meeting(LocalDateTime.of(now.getYear() + 1, 1, 1, 0, 0),
                        "Home", "New Year Celebration", sampleParticipantsList),
                new Meeting(LocalDateTime.of(now.getYear() + 1, 2, 1, 14, 0),
                        "COM1-02-10", "Project Meeting", sampleParticipantsList),
            };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

}
