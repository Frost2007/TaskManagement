package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Task {
    private int id;
    private String taskName;
    private String description;
    private Date deadline;
    private TaskStatus status;
    private User user;


}
