package pl.home.organizer.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.home.organizer.application.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupDto {
    private static final long serialVersionUID = 7647438710294323902L;
    private String id;
    private String groupName;
    private List<UserEntity> users = new ArrayList<>();
}
