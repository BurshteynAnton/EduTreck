package antonburshteyn.lecturers.service;

import antonburshteyn.lecturers.dto.CommentDto;
import antonburshteyn.lecturers.dto.LectureDto;
import antonburshteyn.lecturers.dto.UpdateLecturesByIdDto;

public interface LecturerService {

    Boolean addNewLecture(LectureDto lectureDto);

    Boolean addNewComment (String id, CommentDto commentDto);

    Boolean archivedLecture(String id);

    LectureDto getLectureById (String id);

    Boolean updateLectureById (String id, UpdateLecturesByIdDto updateLecturesByIdDto);

    Boolean unarchivedLecture(String id);
}
