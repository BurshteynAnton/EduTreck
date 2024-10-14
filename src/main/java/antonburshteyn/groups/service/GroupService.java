package antonburshteyn.groups.service;

import antonburshteyn.groups.dto.GroupDto;
import antonburshteyn.groups.dto.AddReminderDto;
import antonburshteyn.groups.dto.UpdateGroupByIdDto;

public interface GroupService {
    Boolean addNewGroup (GroupDto groupDto);

    Boolean unarchiveLecture (String id);

    Boolean addReminderToGroup(String id, AddReminderDto addReminderDto);

    Iterable<GroupDto>getGroupById(String id);

    Iterable<GroupDto>getAllGroups();

    Boolean updateGroupById(String id, UpdateGroupByIdDto updateGroupByIdDto);

    Boolean addStudentToGroup(String id, String studentId);

    Boolean moveStudent(String id, String studentId, String groupId);

    Boolean addWebinarLector(String id,String lecturerId, GroupDto groupDto);

    Boolean addLessonsLecturer(String groupId, String lecturerId, GroupDto groupDto);

    Boolean archiveGroup(String groupId, String lecturerId, GroupDto groupDto);

    Boolean removeStudentFromGroup(String groupId, String studentId);

}
