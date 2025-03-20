package project.redis.seat.entity;

import jakarta.persistence.*;
import lombok.*;
import project.redis.common.entity.BaseEntity;
import project.redis.screen.entity.ScreenEntity;
import project.redis.seat.SeatStatus;

@Entity
@Table(name = "SEAT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCREEN_ID", nullable = false)
    private ScreenEntity screen;

    @Column(name = "SEAT_ROW")
    private String row;

    @Column(name = "SEAT_COLUMN")
    private String column;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEAT_STATUS")
    private SeatStatus status;

}
