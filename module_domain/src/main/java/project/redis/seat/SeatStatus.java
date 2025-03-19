package project.redis.seat;

public enum SeatStatus {
    AVAILABLE("사용 가능"),
    RESERVED("예약됨"),
    OCCUPIED("사용 중"),
    BROKEN("고장남");

    private final String description;

    SeatStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
