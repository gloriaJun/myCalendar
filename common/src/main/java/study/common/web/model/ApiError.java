package study.common.web.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ApiError {
    private ApiErrorType type;
    private ApiErrorCode code;
    private String message;

    public ApiError() {
        type = ApiErrorType.UNKNOWN;
    }

    public ApiError(ApiErrorType type, ApiErrorCode code, String message) {
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public ApiError(ApiErrorType type, ApiErrorCode code, String message, Throwable e) {
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public ApiError(Throwable e) {
        this.type = ApiErrorType.UNKNOWN;
        this.code = ApiErrorCode.UNKNOWN_SERVER_ERROR;
        this.message = e.toString();
    }

    public ApiError(Throwable e, String message, ApiErrorCode code) {
        this.type = ApiErrorType.UNKNOWN;
        this.message = message;
        this.code = code;
        this.message = e.toString();
    }
}