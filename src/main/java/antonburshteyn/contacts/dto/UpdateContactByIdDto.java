package antonburshteyn.contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactByIdDto {
    String name;
    String surname;
    String phoneNumber;
    String email;
    String place;
    String course;
    String source;
    String status;
    @Singular
    List<ContactCommentsDto> contactComments;
}
