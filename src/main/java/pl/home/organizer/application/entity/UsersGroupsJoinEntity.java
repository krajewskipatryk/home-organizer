package pl.home.organizer.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users_groups_join")
public class UsersGroupsJoinEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user", referencedColumnName="users")
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="group", referencedColumnName="groups")
    private GroupEntity group;

    @Column
    private boolean administrator = false;

    @Column
    private boolean moderator = false;
}
