package com.study.common.web.model;

/**
 * Created by gloria on 2017. 4. 13..
 */
public enum ApiErrorType {
    /**
     * 입력값이 잘못되었을 경우
     */
    INVALIDATE_INPUT,

    /**
     * 사용자에게 알려줘야하는 메세지
     */
    MESSAGE,

    /**
     * 알 수 없는 서버 오류
     */
    UNKNOWN,

    /**
     * API 인증 오류
     */
    AUTHENTICATION
}
