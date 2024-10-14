package antonburshteyn.groups.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    String id;
    LocalDate startDate;
    LocalDate expectedFinishDate;
    Map<String, Object> lessonsDays;
    Map<String, Object> webinarDays;
    @Singular
    List<StudentsDto> students;
}
