package antonburshteyn.lecturers.service;

import antonburshteyn.lecturers.dto.AddNewLectureDto;
import antonburshteyn.lecturers.dto.CommentDto;
import antonburshteyn.lecturers.dto.LectureDto;
import antonburshteyn.lecturers.dto.UpdateLecturesByIdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService{

    @Override
    public Boolean addNewLecture(AddNewLectureDto addNewLectureDto) {
        return null;
    }

    @Override
    public Boolean addNewComment(String id, CommentDto commentDto) {
        return null;
    }

    @Override
    public Boolean archivedLecture(String id) {
        return null;
    }

    @Override
    public LectureDto getLectureById(String id) {
        return null;
    }

    @Override
    public Boolean updateLectureById(String id, UpdateLecturesByIdDto updateLecturesByIdDto) {
        return null;
    }

    @Override
    public Boolean unarchivedLecture(String id) {
        return null;
    }
}
