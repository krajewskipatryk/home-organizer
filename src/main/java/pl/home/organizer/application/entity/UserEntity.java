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
@Table(name="users")
public class UserEntity {
    private static final long serialVersionUID = -2489717557407818997L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50)
    private String email;

    private String emailVerificationToken;

    private boolean emailVerificationStatus = false;

    @OneToOne(mappedBy = "user")
    private CleaningListHistoryEntity cleaningListHistoryEntity;
}