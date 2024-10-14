package antonburshteyn.lecturers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLecturesByIdDto {
    Long id;
    String name;
    String surname;
    String phone;
    String email;
    String city;
    @Singular
    List<CommentDto> comments;
}
