package antonburshteyn.groups.service;

import antonburshteyn.groups.dto.GroupDto;
import antonburshteyn.groups.dto.AddReminderDto;

public interface GroupService {
    Boolean addNewGroup (GroupDto addNewGroupDto);

    Boolean unarchiveLecture (String id);

    Boolean addReminderToGroup(String id, AddReminderDto addReminderDto);



}
