package antonburshteyn.contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactCommentsDto {
    LocalDate date;
    String massage;
    String author;
}
