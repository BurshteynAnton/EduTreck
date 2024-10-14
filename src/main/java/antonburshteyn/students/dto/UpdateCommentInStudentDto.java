package antonburshteyn.students.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCommentInStudentDto {
    	String author;
        LocalDate date;
        String message;
}
