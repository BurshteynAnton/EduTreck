package antonburshteyn.groups.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AddReminderDto {
    LocalDateTime dateRemind;
    String text;
    String author;
}
