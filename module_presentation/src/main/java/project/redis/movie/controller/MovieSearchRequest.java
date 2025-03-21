package project.redis.movie.controller;

import lombok.Getter;
import project.redis.movie.model.MovieSearchCondition;

@Getter
public class MovieSearchRequest {

    private String title;
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

//    public MovieSearchCondition toCondition() {
//        return MovieSearchCondition.builder()
//                .title(title)
//                .genre(genre)
//                .build();
//    }

}
