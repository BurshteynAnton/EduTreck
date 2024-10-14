package antonburshteyn.students.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class AddCommentToStudentDto {
    String author;
    String text;
}
