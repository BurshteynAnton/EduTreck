package antonburshteyn.groups.service;

import antonburshteyn.groups.dto.AddReminderDto;
import antonburshteyn.groups.dto.GroupDto;
import antonburshteyn.groups.dto.UpdateGroupByIdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
    @Override
    public Boolean addNewGroup(GroupDto groupDto) {
        return null;
    }

    @Override
    public Boolean unarchiveLecture(String id) {
        return null;
    }

    @Override
    public Boolean addReminderToGroup(String id, AddReminderDto addReminderDto) {
        return null;
    }

    @Override
    public Iterable<GroupDto> getGroupById(String id) {
        return null;
    }

    @Override
    public Iterable<GroupDto> getAllGroups() {
        return null;
    }

    @Override
    public Boolean updateGroupById(String id, UpdateGroupByIdDto updateGroupByIdDto) {
        return null;
    }

    @Override
    public Boolean addStudentToGroup(String id, String studentId) {
        return null;
    }

    @Override
    public Boolean moveStudent(String id, String studentId, String groupId) {
        return null;
    }

    @Override
    public Boolean addWebinarLector(String id, String lecturerId, GroupDto groupDto) {
        return null;
    }

    @Override
    public Boolean addLessonsLecturer(String groupId, String lecturerId, GroupDto groupDto) {
        return null;
    }

    @Override
    public Boolean archiveGroup(String groupId, String lecturerId, GroupDto id) {
        return null;
    }

    @Override
    public Boolean removeStudentFromGroup(String groupId, String studentId) {
        return null;
    }
}
