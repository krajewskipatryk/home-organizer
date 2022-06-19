package pl.home.organizer.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="groups")
public class GroupEntity {
    private static final long serialVersionUID = 1029124663751119778L;

    @Id
    @Column(name="id")
    private String id;

    @Column
    private String groupName;

    @JsonIgnore
    @OneToMany
    private Set<UsersGroupsJoinEntity> users = new HashSet<>();
}
