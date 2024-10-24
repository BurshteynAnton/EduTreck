package antonburshteyn.contacts.service;

import antonburshteyn.contacts.dto.*;

public interface ContactService {
    ContactDto addNewContact(ContactDto contactDto);

    Boolean unarchiveContact(Long contactId);

    ContactDto getContactById(Long contactId);

    Iterable<ContactDto> getAllContactsPagination(int size, int page);

    Iterable<ContactDto> getAllContacts();

    Iterable<ContactDto> findContactByName(String name);

    Iterable<ContactDto> findContactByLastName(String lastName);

    Iterable<ContactDto> getByStatus(String status);

    ContactDto updateContactById(Long contactId, UpdateContactByIdDto updateContactByIdDto);

    ContactDto addCommentToContact(Long contactId, AddCommentToContactDto addCommentToContactDto);

    ContactDto updateCommentInContact(Long contactId, UpdateCommentInContactDto updateCommentInContactDto);

    ContactDto addReminderToContact(Long contactId,AddReminderToContactDto addReminderToContactDto);

    ContactDto removeContact(Long contactId);

    ContactDto deleteCommentFromContact(Long contactId, Long commentId);

    ContactDto deleteReminderFromContact(Long contactId,Long reminderId);

}
