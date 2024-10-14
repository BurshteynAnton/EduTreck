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
public class UpdateGroupByIdDto {
        @Singular
        List<LinkDto> links;
        LocalDate startDate;
        LocalDate expectedFinishDate;
        Map<String, Boolean>lessonsDays;
        Map<String, Boolean> webinarDays;
        @Singular
        List<LecturerDto>lessonLecturers;
        @Singular
        List<WebinarDto>webinarLecturers;
        @Singular
        List<StudentsDto>students;

}
