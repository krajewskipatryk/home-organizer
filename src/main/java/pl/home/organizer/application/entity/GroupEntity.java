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
@Table(name="groups")
public class GroupEntity {
    @Id
    @Column(name="id")
    private String groupId;

    @Column
    private String groupName;

    String usersList;
}
