package pl.home.organizer.application.dto;

import lombok.Getter;
import lombok.Setter;
import pl.home.organizer.application.entity.GroupEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private static final long serialVersionUID = -5778383570944591732L;
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<GroupEntity> groups = new ArrayList<>();
}
