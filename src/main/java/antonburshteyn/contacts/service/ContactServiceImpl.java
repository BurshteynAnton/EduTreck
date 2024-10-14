package antonburshteyn.contacts.service;

import antonburshteyn.contacts.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{
    @Override
    public Boolean addNewContact(AddNewContactDto addNewContactDto) {
        return null;
    }

    @Override
    public Boolean unarchiveContact(String id) {
        return null;
    }

    @Override
    public ContactDto getContactById(String email) {
        return null;
    }

    @Override
    public Iterable<ContactDto> getAllContactsPagination(int page, int size) {
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
    public Boolean updateContactById(String email, UpdateCommentInContactDto updateCommentInContactDto) {
        return null;
    }

    @Override
    public Boolean addCommentToContact(String email, AddCommentToContactDto addCommentToContactDto) {
        return null;
    }

    @Override
    public Boolean updateCommentInContact(String email, UpdateCommentInContactDto updateCommentInContactDto) {
        return null;
    }

    @Override
    public Boolean addReminderToContact(String id, AddReminderToContactDto addReminderToContactDto) {
        return null;
    }

    @Override
    public Boolean removeContact(String email) {
        return null;
    }

    @Override
    public Boolean deleteCommentFromContact(String email, String id) {
        return null;
    }

    @Override
    public Boolean deleteReminderFromContact(String email, DeleteReminderFromContactDto deleteReminderFromContactDto) {
        return null;
    }
}
