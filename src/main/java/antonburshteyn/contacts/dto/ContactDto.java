package antonburshteyn.contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContactDto {
    String name;
    String surname;
    String phoneNumber;
    String email;
    String place;
    String course;
    String source;
    String status;
    @Singular
    List<AddCommentToContactDto> contactComments;
}
