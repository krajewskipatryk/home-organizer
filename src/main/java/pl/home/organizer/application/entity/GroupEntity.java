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
@Table(name="groups")
public class GroupEntity {
    private static final long serialVersionUID = 1029124663751119778L;
    @Id
    private String id;

    @Column()
    private String groupName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "group_has_users",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private List<UserEntity> users = new ArrayList<>();

    public void addUser(UserEntity user) {
        this.users.add(user);
    }
}
