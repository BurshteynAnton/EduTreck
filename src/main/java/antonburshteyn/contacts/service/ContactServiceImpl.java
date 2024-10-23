package antonburshteyn.contacts.service;

import antonburshteyn.contacts.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{

    @Override
    public Boolean addNewContact(ContactDto contactDto) {
        return null;
    }

    @Override
    public Boolean unarchiveContact(Long contactId) {
        return null;
    }

    @Override
    public ContactDto getContactById(Long contactId) {
        return null;
    }

    @Override
    public Iterable<ContactDto> getAllContactsPagination(int size, int page) {
        return null;
    }

    @Override
    public Iterable<ContactDto> getAllContacts() {
        return null;
    }

    @Override
    public Iterable<ContactDto> findContactByName(String name) {
        return null;
    }

    @Override
    public Iterable<ContactDto> findContactByLastName(String lastName) {
        return null;
    }

    @Override
    public Iterable<ContactDto> getByStatus(String status) {
        return null;
    }

    @Override
    public Boolean updateContactById(Long contactId, UpdateCommentInContactDto updateCommentInContactDto) {
        return null;
    }

    @Override
    public Boolean addCommentToContact(Long contactId, AddCommentToContactDto addCommentToContactDto) {
        return null;
    }

    @Override
    public Boolean updateCommentInContact(Long contactId, UpdateCommentInContactDto updateCommentInContactDto) {
        return null;
    }

    @Override
    public Boolean addReminderToContact(Long contactId, AddReminderToContactDto addReminderToContactDto) {
        return null;
    }

    @Override
    public Boolean removeContact(Long contactId) {
        return null;
    }

    @Override
    public Boolean deleteCommentFromContact(Long contactId, Long commentId) {
        return null;
    }

    @Override
    public Boolean deleteReminderFromContact(Long contactId, Long reminderId) {
        return null;
    }
}
