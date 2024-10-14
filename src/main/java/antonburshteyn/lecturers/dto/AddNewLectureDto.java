package antonburshteyn.lecturers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddNewLectureDto {
    Long id;
    String name;
    String surname;
    String phone;
    String email;
    String city;
    @Singular
    Set<GroupDto> groups;
    @Singular
    List<CommentDto> comments;
}