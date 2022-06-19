package pl.home.organizer.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="list")
public class CleaningListHistoryEntity {
    private static final long serialVersionUID = -5100014457792655083L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order;

    @OneToOne
    @JoinColumn(name="id")
    private UserEntity user;

    @Column
    private boolean isApproved = false;

    @Column
    private LocalDate cleaningDate;
}
