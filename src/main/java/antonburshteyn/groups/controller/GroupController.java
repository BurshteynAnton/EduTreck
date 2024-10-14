package antonburshteyn.groups.controller;

import antonburshteyn.groups.dto.AddReminderDto;
import antonburshteyn.groups.dto.GroupDto;
import antonburshteyn.groups.dto.UpdateGroupByIdDto;
import antonburshteyn.groups.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController  {

    final GroupService groupService;

    @PutMapping
    public Boolean addNewGroup(@RequestBody GroupDto groupDto) {
        return groupService.addNewGroup(groupDto);
    }

    @PostMapping("/{id}")
    public Boolean unarchiveLecture(@PathVariable String id) {
        return groupService.unarchiveLecture(id);
    }

    @PostMapping("/{id}/reminder")
    public Boolean addReminderToGroup(@PathVariable String id,@RequestBody AddReminderDto addReminderDto) {
        return groupService.addReminderToGroup(id, addReminderDto);
    }

    @GetMapping("{id}")
    public Iterable<GroupDto> getGroupById(@PathVariable String id) {
        return groupService.getGroupById(id);
    }

    @GetMapping
    public Iterable<GroupDto> getAllGroups() {
        return groupService.getAllGroups();
    }

    @PutMapping("{id}")
    public Boolean updateGroupById(@PathVariable String id,@RequestBody UpdateGroupByIdDto updateGroupByIdDto) {
        return groupService.updateGroupById(id, updateGroupByIdDto);
    }

    @GetMapping("/{id}/student/{studentId}")
    public Boolean addStudentToGroup(@PathVariable String id,@PathVariable String studentId) {
        return groupService.addStudentToGroup(id, studentId);
    }

    @GetMapping("/{id}/student/{studentId}/group/{groupId}")
    public Boolean moveStudent(@PathVariable String id, @PathVariable String studentId, @PathVariable String groupId) {
        return groupService.moveStudent(id, studentId, groupId);
    }

    @GetMapping("/{id}/webinarLecturer/{lecturerId}")
    public Boolean addWebinarLector(@PathVariable String id,@PathVariable String lecturerId, @RequestBody GroupDto groupDto) {
        return null;
    }

    @PutMapping("/{groupId}/lessonLecturer/{lecturerId}")
    public Boolean addLessonsLecturer(@PathVariable String groupId, @PathVariable String lecturerId, @RequestBody GroupDto groupDto) {
        return groupService.addLessonsLecturer(groupId, lecturerId, groupDto);
    }

    @DeleteMapping("/{groupId}/lessonLecturer/{lecturerId}")
    public Boolean archiveGroup(@PathVariable String groupId, @PathVariable String lecturerId, @RequestBody GroupDto groupDto) {

        return groupService.archiveGroup(groupId, lecturerId, groupDto);
    }

    @DeleteMapping("/{groupId}/student/{studentId}")
    public Boolean removeStudentFromGroup(@PathVariable String groupId,@PathVariable String studentId) {
        return groupService.removeStudentFromGroup(groupId, studentId);
    }
}
