package antonburshteyn.students.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AddReminderToStudentDto {
    LocalDateTime dateRemind;
    String text;
    String author;
}
