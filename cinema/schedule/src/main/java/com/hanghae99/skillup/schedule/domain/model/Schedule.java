package com.hanghae99.skillup.schedule.domain.model;

import com.hanghae99.skillup.screen.domain.model.Screen;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "SCHEDULE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 약결합
    @Column(name = "MOVIE_ID", nullable = false)
    private Long movieId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCREEN_ID", nullable = false)
    private Screen screen;

    @Column(name = "DATE", nullable = false)
    private LocalDate date;

    @Column(name = "START")
    private LocalTime start;

    @Column(name = "END")
    private LocalTime end;

    @Column(name = "STATE", length = 20)
    private String state;

    @Column(name = "REG_DT", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "REG_ID", length = 30, nullable = false)
    private String regId;

    @Column(name = "UPD_DT")
    private LocalDateTime updDt;

    @Column(name = "UPD_ID", length = 30)
    private String updId;
}
