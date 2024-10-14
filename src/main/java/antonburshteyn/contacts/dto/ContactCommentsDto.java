package antonburshteyn.contacts.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ContactCommentsDto {
    LocalDate date;
    String massage;
    String author;
}
