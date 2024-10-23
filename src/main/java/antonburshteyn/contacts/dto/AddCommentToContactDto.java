package antonburshteyn.contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentToContactDto {
    LocalDateTime date;
    String text;
    String author;
}
