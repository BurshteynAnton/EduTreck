package antonburshteyn.contacts.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DeleteReminderFromContactDto {
    String author;
    LocalDate date;

}
