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

    @PostMapping("/{id}")
    public Boolean unarchiveContact(@PathVariable String id) {
        return contactService.unarchiveContact(id);
    }

    @GetMapping("/{email}")
    public ContactDto getContactById(@PathVariable String email) {
        return contactService.getContactById(email);
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

   @PutMapping("/{email}")
    public Boolean updateContactById(@PathVariable String email,@RequestBody UpdateCommentInContactDto updateCommentInContactDto) {
        return contactService.updateContactById(email, updateCommentInContactDto);
    }

    @PostMapping("/{email}/comment")
    public Boolean addCommentToContact(@PathVariable String email,@RequestBody AddCommentToContactDto addCommentToContactDto) {
        return contactService.addCommentToContact(email, addCommentToContactDto);
    }

    @PutMapping("{email}/comment/{commentNumber}")
    public Boolean updateCommentInContact(@PathVariable String email,@RequestBody UpdateCommentInContactDto updateCommentInContactDto) {
        return contactService.updateCommentInContact(email, updateCommentInContactDto);
    }

    @PutMapping("/{id}/reminder")
    public Boolean addReminderToContact(@PathVariable String id,@RequestBody AddReminderToContactDto addReminderToContactDto) {
        return contactService.addReminderToContact(id, addReminderToContactDto);
    }

    @DeleteMapping("/contact/{email}")
    public Boolean removeContact(@PathVariable String email) {
        return contactService.removeContact(email);
    }

    @DeleteMapping("/{email}/comment/{id}")//Not sure please check API
    public Boolean deleteCommentFromContact(@PathVariable String email,@PathVariable String id) {
        return contactService.deleteCommentFromContact(email, id);
    }

    @DeleteMapping("/{email}/reminder/{id}")//Not sure please check API
    public Boolean deleteReminderFromContact(@PathVariable String email,@RequestBody DeleteReminderFromContactDto deleteReminderFromContactDto) {
        return contactService.deleteReminderFromContact(email, deleteReminderFromContactDto);
    }
}
