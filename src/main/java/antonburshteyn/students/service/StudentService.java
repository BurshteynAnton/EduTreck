package antonburshteyn.students.service;

import antonburshteyn.lecturers.dto.CommentDto;
import antonburshteyn.students.dto.*;

public interface StudentService {
    Boolean addNewStudent(StudentDto studentDto);

    StudentDto getStudentsById(String id);

    StudentDto getAllStudentsPage();// Please help what does the method take?
//    Page<StudentDto> getAllStudentsPage(Pageable pageable);


    Iterable<StudentDto> getAllStudents();

    Iterable<StudentDto> findStudentsByName(String name);

    Iterable<StudentDto> findStudentsByLastName(String surname);

    Iterable<StudentDto> findStudentsByGroup(String group);

    Iterable<StudentDto> findStudentsByCity(String city);

    UpdateSudentByIdDto updateStudentById(String id, UpdateSudentByIdDto updateSudentByIdDto);

    StudentDto addCommentToStudent(String id, String comment);

    StudentDto addReminderToStudent(String id, String reminder);

    StudentDto updateCommentInStudentDto( String id, String commentId, CommentDto updatedComment);

    StudentDto addGroupToStudent(String id, String group);

    StudentDto removeStudent(String id);

    StudentDto deleteCommentFromStudent(String studentId, String commentId);

    StudentDto deleteReminderFromStudent(String studentId, String reminderId);

    StudentDto deleteGroupFromStudent(String studentId, String groupId);


}
