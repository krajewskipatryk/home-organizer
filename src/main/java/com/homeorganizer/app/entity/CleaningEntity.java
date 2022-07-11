package com.homeorganizer.app.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cleaning")
public class CleaningEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate lastCleaningDate;
    private LocalDate nextCleaningDate;
    @OneToOne
    private UserEntity recentlyCleaningUser;
    @OneToOne
    private UserEntity nextCleaningUser;
    @OneToOne
    private GroupEntity assignedGroup;
}
