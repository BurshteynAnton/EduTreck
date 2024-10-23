package antonburshteyn.contacts.controller;

import antonburshteyn.contacts.dto.*;
import antonburshteyn.contacts.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController implements ContactService {
    final ContactService contactService;

    @PostMapping
    public Boolean addNewContact(@RequestBody ContactDto contactDto) {
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

    @GetMapping("/lastName/{lastname}")
    public Iterable<ContactDto> findContactByLastName(@PathVariable String lastName) {
        return contactService.findContactByLastName(lastName);
    }

    @GetMapping("/status/{status}")
    public Iterable<ContactDto> getByStatus(@PathVariable String status) {
        return contactService.getByStatus(status);
    }

   @PutMapping("/{contactId}")
    public Boolean updateContactById(@PathVariable Long contactId,@RequestBody UpdateCommentInContactDto updateCommentInContactDto) {
        return contactService.updateContactById(contactId, updateCommentInContactDto);
    }

    @PostMapping("/{contactId}/comment")
    public Boolean addCommentToContact(@PathVariable Long contactId,@RequestBody AddCommentToContactDto addCommentToContactDto) {
        return contactService.addCommentToContact(contactId, addCommentToContactDto);
    }

    @PutMapping("{contactId}/comment/{commentId}")
    public Boolean updateCommentInContact(@PathVariable Long contactId,@RequestBody UpdateCommentInContactDto updateCommentInContactDto) {
        return contactService.updateCommentInContact(contactId, updateCommentInContactDto);
    }

    @PutMapping("/{contactId}/reminder")
    public Boolean addReminderToContact(@PathVariable Long contactId,@RequestBody AddReminderToContactDto addReminderToContactDto) {
        return contactService.addReminderToContact(contactId, addReminderToContactDto);
    }

    @DeleteMapping("/contact/{contactId}")
    public Boolean removeContact(@PathVariable Long contactId) {
        return contactService.removeContact(contactId);
    }

    @DeleteMapping("/{contactId}/comment/{commentId}")//Not sure please check API
    public Boolean deleteCommentFromContact(@PathVariable Long contactId,@PathVariable Long commentId) {
        return contactService.deleteCommentFromContact(contactId, commentId);
    }

    @DeleteMapping("/{contactId}/reminder/{reminderId}")
    public Boolean deleteReminderFromContact(@PathVariable Long contactId,@PathVariable Long reminderId) {
        return null;
    }

}
