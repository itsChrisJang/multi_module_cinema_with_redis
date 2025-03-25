package project.redis.movie.controller;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSearchRequest {

    @Size(max = 255, message = "영화 제목은 255자 이하로 입력해주세요.")
    private String title;
    @Size(max = 20, message = "비정상적인 장르 값입니다.")
    private String genre;

}
