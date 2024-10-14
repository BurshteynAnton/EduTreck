package antonburshteyn.contacts.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AddReminderToContactDto {
    LocalDateTime dateRemind;
    String text;
    String author;
}
