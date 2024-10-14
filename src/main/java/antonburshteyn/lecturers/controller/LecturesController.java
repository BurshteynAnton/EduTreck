package antonburshteyn.lecturers.controller;

import antonburshteyn.lecturers.dto.AddNewLectureDto;
import antonburshteyn.lecturers.dto.CommentDto;
import antonburshteyn.lecturers.dto.LectureDto;
import antonburshteyn.lecturers.dto.UpdateLecturesByIdDto;
import antonburshteyn.lecturers.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LecturesController {

    final LecturerService lecturerService;

    @PostMapping
    public Boolean addNewLecture(@RequestBody AddNewLectureDto addNewLectureDto) {
        return lecturerService.addNewLecture(addNewLectureDto);
    }

    @PostMapping("/{id}/comment")
    public Boolean addNewComment(@PathVariable String id, @RequestBody CommentDto commentDto) {
        return lecturerService.addNewComment(id, commentDto);
    }

    @PutMapping("/{id}/archived")
    public Boolean archivedLecture(@PathVariable String id) {
        return lecturerService.archivedLecture(id);
    }

    @GetMapping("/{id}")
    public LectureDto getLectureById(@PathVariable String id) {
        return lecturerService.getLectureById(id);
    }

    @PostMapping("/{id}")
    public Boolean updateLectureById(@PathVariable String id, @RequestBody UpdateLecturesByIdDto updateLecturesByIdDto) {
        return null;
    }

    @PostMapping("/{id}/unarchived")
    public Boolean unarchivedLecture(@PathVariable String id) {
        return lecturerService.unarchivedLecture(id);
    }
}
