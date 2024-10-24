package antonburshteyn.contacts.controller;

import antonburshteyn.contacts.dto.*;
import antonburshteyn.contacts.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    final ContactService contactService;

    @PostMapping
    public ContactDto addNewContact(@RequestBody ContactDto contactDto) {
        return contactService.addNewContact(contactDto);
    }

    @PostMapping("/{contactId}")
    public Boolean unarchiveContact(@PathVariable Long contactId) {
        return contactService.unarchiveContact(contactId);
    }

    @GetMapping("/{contactId}")
    public ContactDto getContactById(@PathVariable Long contactId) {
        return contactService.getContactById(contactId);
    }

    @GetMapping("/{size}/{page}")
    public Iterable<ContactDto> getAllContactsPagination(@PathVariable int size,@PathVariable int page) {
        return contactService.getAllContactsPagination(size, page);
    }

    @GetMapping("/all")
    public Iterable<ContactDto> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/name/{name}")
    public Iterable<ContactDto> findContactByName(@PathVariable String name) {
        return contactService.findContactByName(name);
    }

    @GetMapping("/lastName/{lastName}")
    public Iterable<ContactDto> findContactByLastName(@PathVariable String lastName) {
        return contactService.findContactByLastName(lastName);
    }

    @GetMapping("/status/{status}")
    public Iterable<ContactDto> getByStatus(@PathVariable String status) {
        return contactService.getByStatus(status);
    }

   @PutMapping("/{contactId}")
    public ContactDto updateContactById(@PathVariable Long contactId,@RequestBody UpdateContactByIdDto updateContactByIdDto) {
        return contactService.updateContactById(contactId, updateContactByIdDto);
    }

    @PostMapping("/{contactId}/comment")
    public ContactDto addCommentToContact(@PathVariable Long contactId,@RequestBody AddCommentToContactDto addCommentToContactDto) {
        return contactService.addCommentToContact(contactId, addCommentToContactDto);
    }

    @PutMapping("{contactId}/comment/{commentId}")
    public ContactDto updateCommentInContact(@PathVariable Long contactId,@RequestBody UpdateCommentInContactDto updateCommentInContactDto) {
        return contactService.updateCommentInContact(contactId, updateCommentInContactDto);
    }

    @PutMapping("/{contactId}/reminder")
    public ContactDto addReminderToContact(@PathVariable Long contactId,@RequestBody AddReminderToContactDto addReminderToContactDto) {
        return contactService.addReminderToContact(contactId, addReminderToContactDto);
    }

    @DeleteMapping("/{contactId}")
    public ContactDto removeContact(@PathVariable Long contactId) {
        return contactService.removeContact(contactId);
    }

    @DeleteMapping("/{contactId}/comment/{commentId}")//Not sure please check API
    public ContactDto deleteCommentFromContact(@PathVariable Long contactId,@PathVariable Long commentId) {
        return contactService.deleteCommentFromContact(contactId, commentId);
    }

    @DeleteMapping("/{contactId}/reminder/{reminderId}")
    public ContactDto deleteReminderFromContact(@PathVariable Long contactId,@PathVariable Long reminderId) {
        return contactService.deleteReminderFromContact(contactId, reminderId);
    }

}
