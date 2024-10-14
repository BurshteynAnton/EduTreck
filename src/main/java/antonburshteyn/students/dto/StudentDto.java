package antonburshteyn.students.dto;

import lombok.Singular;

import java.util.List;

public class StudentDto {
    String studentId;
    String name;
    String surname;
    String phoneNumber;
    String email;
    String place;
    String status;
    String course;
    @Singular
    List<String> groups;
    @Singular
    List<String> comments;
    @Singular
    List<PaymentLogDto> paymentLogDto;
    @Singular
    List<String> reminders;
    @Singular
    List<String> activityLog;
}
