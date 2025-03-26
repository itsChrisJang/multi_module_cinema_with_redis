package project.redis.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project.redis.MovieApplicationErrorMessages;

@Getter
@NoArgsConstructor
public class ApiResponse<T> {
    private String code;
    private String message;
    private T data;

    public ApiResponse(MovieApplicationErrorMessages movieApplicationErrorMessages) {
        this.code = movieApplicationErrorMessages.getCode();
        this.message = movieApplicationErrorMessages.getDescription();
    }

    public ApiResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
