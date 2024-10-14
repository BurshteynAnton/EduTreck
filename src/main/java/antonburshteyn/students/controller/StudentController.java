package antonburshteyn.students.controller;

import antonburshteyn.lecturers.dto.CommentDto;
import antonburshteyn.students.dto.StudentDto;
import antonburshteyn.students.dto.UpdateSudentByIdDto;
import antonburshteyn.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController  
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    final StudentService studentService;

    @PostMapping
    public Boolean addNewStudent(@RequestBody StudentDto studentDto) {
        return studentService.addNewStudent(studentDto);
    }

    @GetMapping("/{id}")
    public StudentDto getStudentsById(@PathVariable String id) {
        return studentService.getStudentsById(id);
    }

    @GetMapping("/all")
    public StudentDto getAllStudentsPage() {
        return studentService.getAllStudentsPage();
    }

    @GetMapping
    public Iterable<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/name/{name}")
    public Iterable<StudentDto> findStudentsByName(@PathVariable String name) {
        return studentService.findStudentsByName(name);
    }

    @GetMapping("/surname/{surname}")
    public Iterable<StudentDto> findStudentsByLastName(@PathVariable String surname) {
        return studentService.findStudentsByLastName(surname);
    }

    @GetMapping("/group/{group}")
    public Iterable<StudentDto> findStudentsByGroup(@PathVariable String group) {
        return studentService.findStudentsByGroup(group);
    }

    @GetMapping("/city/{city}")
    public Iterable<StudentDto> findStudentsByCity(@PathVariable String city) {
        return studentService.findStudentsByCity(city);
    }

    @PostMapping("{id}")
    public UpdateSudentByIdDto updateStudentByIdDto(@PathVariable String id,@RequestBody UpdateSudentByIdDto updateSudentByIdDto) {
        return studentService.updateStudentById(id, updateSudentByIdDto);
    }

    @PostMapping("/{id}/comment")
    public StudentDto addCommentToStudent(@PathVariable String id,@RequestBody String comment) {
        return studentService.addCommentToStudent(id, comment);
    }

    @PostMapping("/{id}/reminder")
    public StudentDto addReminderToStudent(@PathVariable String id,@RequestBody String reminder) {
        return studentService.addReminderToStudent(id, reminder);
    }

    @PostMapping("/{id}/updatecomment/{commentId}")
    public StudentDto updateCommentInStudentDto(@PathVariable String id, @PathVariable String commentId, @RequestBody CommentDto updatedComment) {
        return studentService.updateCommentInStudentDto(id, commentId, updatedComment);
    }


    @PostMapping("/{id}/group")
    public StudentDto addGroupToStudent(@PathVariable String id,@RequestBody String group) {
        return studentService.addGroupToStudent(id, group);
    }

    @DeleteMapping("/{id}")
    public StudentDto removeStudent(@PathVariable String id) {
        return studentService.removeStudent(id);
    }

    @DeleteMapping("/{studentId}/comment/{commentId}")
    public StudentDto deleteCommentFromStudent(@PathVariable String studentId,@PathVariable String commentId) {
        return studentService.deleteCommentFromStudent(studentId, commentId);
    }

    @DeleteMapping("/{studentId}/reminder/{reminderId}")
    public StudentDto deleteReminderFromStudent(@PathVariable String studentId,@PathVariable String reminderId) {
        return studentService.deleteReminderFromStudent(studentId,reminderId);
    }

    @DeleteMapping("/{studentId}/group/{groupId}")
    public StudentDto deleteGroupFromStudent(@PathVariable String studentId,@PathVariable String groupId) {
        return studentService.deleteGroupFromStudent(studentId,groupId);
    }
}
