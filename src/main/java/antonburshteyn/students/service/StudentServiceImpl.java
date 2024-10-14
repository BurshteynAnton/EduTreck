package antonburshteyn.students.service;

import antonburshteyn.lecturers.dto.CommentDto;
import antonburshteyn.students.dto.AddNewStudentDto;
import antonburshteyn.students.dto.StudentDto;
import antonburshteyn.students.dto.UpdateSudentByIdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{


    @Override
    public Boolean addNewStudent(AddNewStudentDto addNewStudentDto) {
        return null;
    }

    @Override
    public StudentDto getStudentsById(String id) {
        return null;
    }

    @Override
    public StudentDto getAllStudentsPage() {
        return null;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return List.of();
    }

    @Override
    public List<StudentDto> findStudentsByName(String name) {
        return List.of();
    }

    @Override
    public List<StudentDto> findStudentsByLastName(String surname) {
        return List.of();
    }

    @Override
    public List<StudentDto> findStudentsByGroup(String group) {
        return List.of();
    }

    @Override
    public List<StudentDto> findStudentsByCity(String city) {
        return List.of();
    }

    @Override
    public UpdateSudentByIdDto updateStudentById(String id, UpdateSudentByIdDto updateSudentByIdDto) {
        return null;
    }

    @Override
    public StudentDto addCommentToStudent(String id, String comment) {
        return null;
    }

    @Override
    public StudentDto addReminderToStudent(String id, String reminder) {
        return null;
    }

    @Override
    public StudentDto updateCommentInStudentDto( String id, String commentId, CommentDto updatedComment) {
        return null;
    }

    @Override
    public StudentDto addGroupToStudent(String id, String group) {
        return null;
    }

    @Override
    public StudentDto removeStudent(String id) {
        return null;
    }

    @Override
    public StudentDto deleteCommentFromStudent(String studentId, String commentId) {
        return null;
    }

    @Override
    public StudentDto deleteReminderFromStudent(String studentId, String reminderId) {
        return null;
    }

    @Override
    public StudentDto deleteGroupFromStudent(String studentId, String groupId) {
        return null;
    }
}
