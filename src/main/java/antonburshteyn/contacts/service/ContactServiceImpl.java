package antonburshteyn.contacts.service;

import antonburshteyn.contacts.dao.CommentRepository;
import antonburshteyn.contacts.dao.ContactRepository;
import antonburshteyn.contacts.dao.ReminderRepository;
import antonburshteyn.contacts.dto.*;
import antonburshteyn.contacts.dto.exceptions.CommentNotFoundException;
import antonburshteyn.contacts.dto.exceptions.ContactExistException;
import antonburshteyn.contacts.dto.exceptions.ContactNotFoundException;
import antonburshteyn.contacts.dto.exceptions.ReminderNotFoundException;
import antonburshteyn.contacts.model.Comment;
import antonburshteyn.contacts.model.Contact;
import antonburshteyn.contacts.model.Reminder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{

    final ContactRepository contactRepository;
    final CommentRepository commentRepository;
    final ReminderRepository reminderRepository;
    final ModelMapper modelMapper;

    @Transactional
    @Override
    public ContactDto addNewContact(ContactDto contactDto) {
        if(contactRepository.existsByName(contactDto.getName())) {
            throw new ContactExistException();
        }
        Contact contact = modelMapper.map(contactDto, Contact.class);
        if (contactDto.getComments() != null && !contactDto.getComments().isEmpty()) {
            contactDto.getComments().forEach(commentDto -> {
                Comment comment = new Comment();
                comment.setText(commentDto.getText());
                comment.setAuthor(commentDto.getAuthor());
                comment.setDate(LocalDateTime.now());
                comment.setContact(contact);
                contact.getComments().put(comment.getAuthor(), comment);
            });
        }
        contactRepository.save(contact);
        return modelMapper.map(contact, ContactDto.class);
    }

    @Transactional
    @Override
    public Boolean unarchiveContact(Long contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(ContactNotFoundException::new);
        if(contact.isArchived()){
            contact.setArchived(false);
            contactRepository.save(contact);
            return true;
        }
        return false;
    }

    @Override
    public ContactDto getContactById(Long contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(ContactNotFoundException::new);
        return modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public Iterable<ContactDto> getAllContactsPagination(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Contact> contactPage = contactRepository.findAll(pageable);
        return contactPage.stream()
                .map(contact -> modelMapper.map(contact, ContactDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Iterable<ContactDto> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contact -> modelMapper.map(contact, ContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<ContactDto> findContactByName(String name) {
        List <Contact> contacts = contactRepository.findByName(name);
        return contacts.stream()
                .map(contact -> modelMapper.map(contact, ContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<ContactDto> findContactByLastName(String lastName) {
        List<Contact> contacts = contactRepository.findBySurname(lastName);
        return contacts.stream()
                .map(contact -> modelMapper.map(contact, ContactDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<ContactDto> getByStatus(String status) {
    List<Contact> contacts = contactRepository.findByStatus(status);
    if(contacts.isEmpty()) {
        throw new ContactNotFoundException();
    }
        return contacts.stream()
                .map(contact -> modelMapper.map(contact, ContactDto.class))
                .collect(Collectors.toList());
    }
    @Transactional
    @Override
    public ContactDto updateContactById(Long contactId, UpdateContactByIdDto updateContactByIdDto) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(ContactNotFoundException::new);
        contact.setName(updateContactByIdDto.getName());
        contact.setSurname(updateContactByIdDto.getSurname());
        contact.setPhoneNumber(updateContactByIdDto.getPhone());
        contact.setEmail(updateContactByIdDto.getEmail());
        contact.setPlace(updateContactByIdDto.getPlace());
        contact.setCourse(updateContactByIdDto.getCourse());
        contact.setSource(updateContactByIdDto.getSource());
        contact.setStatus(updateContactByIdDto.getStatus());
        contactRepository.save(contact);
        return modelMapper.map(contact, ContactDto.class);
    }
    @Transactional
    @Override
    public ContactDto addCommentToContact(Long contactId, AddCommentToContactDto addCommentToContactDto) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(ContactNotFoundException::new);
        Comment comment = new Comment();
        comment.setText(addCommentToContactDto.getText());
        comment.setDate(addCommentToContactDto.getDate());
        comment.setAuthor(addCommentToContactDto.getAuthor());
        comment.setContact(contact);

        contact.getComments().put(comment.getAuthor(), comment);
        contactRepository.save(contact);
        return modelMapper.map(contact, ContactDto.class);
    }

    @Transactional
    @Override
    public ContactDto updateCommentInContact(Long contactId, UpdateCommentInContactDto updateCommentInContactDto) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(ContactNotFoundException::new);
        Comment comment = contact.getComments().get(updateCommentInContactDto.getAuthor());
        if (comment == null) {
            throw new CommentNotFoundException();
        }
        comment.setText(updateCommentInContactDto.getText());
        contactRepository.save(contact);
        return modelMapper.map(contact, ContactDto.class);
    }

    @Transactional
    @Override
    public ContactDto addReminderToContact(Long contactId, AddReminderToContactDto addReminderToContactDto) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(ContactNotFoundException::new);
        Reminder reminder = new Reminder();
        reminder.setAuthor(addReminderToContactDto.getAuthor());
        reminder.setText(addReminderToContactDto.getText());
        reminder.setDateRemind(addReminderToContactDto.getDateRemind());

        contact.getReminders().put(reminder.getAuthor(), reminder);
        reminderRepository.save(reminder);
        return modelMapper.map(contact, ContactDto.class);
    }

    @Transactional
    @Override
    public ContactDto removeContact(Long contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(ContactNotFoundException::new);
        contactRepository.delete(contact);
        return modelMapper.map(contact, ContactDto.class);
    }

    @Transactional
    @Override
    public ContactDto deleteCommentFromContact(Long contactId, Long commentId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(ContactNotFoundException::new);
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);
        contact.getComments().remove(comment.getAuthor());
        contactRepository.save(contact);
        return modelMapper.map(contact, ContactDto.class);
    }

    @Transactional
    @Override
    public ContactDto deleteReminderFromContact(Long contactId, Long reminderId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(ContactNotFoundException::new);
        Reminder reminder = reminderRepository.findById(reminderId)
                .orElseThrow(ReminderNotFoundException::new);
        contact.getReminders().remove(reminder.getAuthor());
        reminderRepository.delete(reminder);
        contactRepository.save(contact);
        return modelMapper.map(contact, ContactDto.class);
    }
}
