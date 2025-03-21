package project.redis.seat.entity;

import jakarta.persistence.*;
import lombok.*;
import project.redis.common.entity.BaseEntity;
import project.redis.screen.entity.ScreenEntity;
import project.redis.domain.seat.SeatStatus;

@Entity
@Table(name = "seat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "screen_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ScreenEntity screen;

    @Column(name = "seat_row")
    private String row;

    @Column(name = "seat_column")
    private String column;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_status")
    private SeatStatus status;

}
