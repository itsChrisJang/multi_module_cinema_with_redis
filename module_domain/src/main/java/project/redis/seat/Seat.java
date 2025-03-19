package project.redis.seat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Seat {

    private Long screenId;
    private SeatStatus status;
    private String row;
    private String column;

    public static Seat of(
            Long screenId,
            SeatStatus status,
            String row,
            String column) {
        return new Seat(screenId, status, row, column);
    }

    public int compareRow(Seat otherSeat) {
        return this.row.compareTo(otherSeat.row);
    }

    public int compareCol(Seat otherSeat) {
        return this.column.compareTo(otherSeat.column);
    }

}
