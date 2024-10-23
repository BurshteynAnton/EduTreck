package antonburshteyn.contacts.service;

import antonburshteyn.contacts.dto.*;

public interface ContactService {
    Boolean addNewContact(ContactDto contactDto);

    Boolean unarchiveContact(Long contactId);

    ContactDto getContactById(Long contactId);

    Iterable<ContactDto> getAllContactsPagination(int size, int page);

    Iterable<ContactDto> getAllContacts();

    Iterable<ContactDto> findContactByName(String name);

    Iterable<ContactDto> findContactByLastName(String lastName);

    Iterable<ContactDto> getByStatus(String status);

    Boolean updateContactById(Long contactId, UpdateCommentInContactDto updateCommentInContactDto);

    Boolean addCommentToContact(Long contactId, AddCommentToContactDto addCommentToContactDto);

    Boolean updateCommentInContact(Long contactId, UpdateCommentInContactDto updateCommentInContactDto);

    Boolean addReminderToContact(Long contactId,AddReminderToContactDto addReminderToContactDto);

    Boolean removeContact(Long contactId);

    Boolean deleteCommentFromContact(Long contactId, Long commentId);

    Boolean deleteReminderFromContact(Long contactId,Long reminderId);

}
