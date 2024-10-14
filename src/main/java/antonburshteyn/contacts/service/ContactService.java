package antonburshteyn.contacts.service;

import antonburshteyn.contacts.dto.*;

public interface ContactService {
    Boolean addNewContact(ContactDto contactDto);

    Boolean unarchiveContact(String id);

    ContactDto getContactById(String email);

    Iterable<ContactDto> getAllContactsPagination(int size, int page);

    Iterable<ContactDto> getAllContacts();

    Iterable<ContactDto> findContactByName(String name);

    Iterable<ContactDto> findContactByLastName(String lastName);

    Iterable<ContactDto> getByStatus(String status);

    Boolean updateContactById(String email, UpdateCommentInContactDto updateCommentInContactDto);

    Boolean addCommentToContact(String email, AddCommentToContactDto addCommentToContactDto);

    Boolean updateCommentInContact(String email, UpdateCommentInContactDto updateCommentInContactDto);

    Boolean addReminderToContact(String id,AddReminderToContactDto addReminderToContactDto);

    Boolean removeContact(String email);

    Boolean deleteCommentFromContact(String email, String id);

    Boolean deleteReminderFromContact(String email,DeleteReminderFromContactDto deleteReminderFromContactDto);

}
