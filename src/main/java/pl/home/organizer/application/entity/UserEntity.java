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
@Table(name="users")
public class UserEntity {
    private static final long serialVersionUID = -2489717557407818997L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(length = 50)
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;

    @Column
    private String email;

    @JsonIgnore
    @OneToMany
    private Set<UsersGroupsJoinEntity> groups = new HashSet<>();
}