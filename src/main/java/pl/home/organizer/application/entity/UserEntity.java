package pl.home.organizer.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class UserEntity {
    private static final long serialVersionUID = -2489717557407818997L;

    @Id
    @Column(name = "id")
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @ManyToMany(mappedBy="users")
    private List<GroupEntity> groups = new ArrayList<>();

    public void addGroup(GroupEntity group) {
        this.groups.add(group);
    }
}