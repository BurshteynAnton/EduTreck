package antonburshteyn.contacts.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateCommentInContactDto {

    LocalDateTime date;
    String author;
    String text;
}
