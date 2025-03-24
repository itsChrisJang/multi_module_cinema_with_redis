package project.redis.movie.controller;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MovieSearchRequest {

    @Size(max = 255, message = "영화 제목은 255자 이하로 입력해주세요.")
    private String title;
    @Size(max = 20, message = "비정상적인 장르 값입니다.")
    private String genre;

    private boolean hasMovieTitle() {
        return title != null && !title.isBlank();
    }

    private boolean hasMovieGenre() {
        return genre != null && !genre.isBlank();
    }

//    public boolean filter(OrderDto orderDto) {
//        if (hasMemberNo()) {
//            return orderDto.getMemberNo().equals(getMemberNo());
//        }
//        if (hasOrderNo()) {
//            return orderDto.getOrderNo().equals(getOrderNo());
//        }
//
//        return true;
//    }
}
