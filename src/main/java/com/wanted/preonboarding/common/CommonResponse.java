package com.wanted.preonboarding.common;

import com.wanted.preonboarding.common.code.Code;
import com.wanted.preonboarding.common.code.CommonCode;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Getter
@Builder
public class CommonResponse {

    private final String timeStamp = ZonedDateTime.now(ZoneId.of("Asia/Seoul"))
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    private final int code;
    private final String message;
    private final Object data;

    public static CommonResponse toResponse(CommonCode commonCode, Object data) {
        return CommonResponse.builder()
                .code(commonCode.getCode().value())
                .message(commonCode.getMessage())
                .data(data)
                .build();
    }

    public static CommonResponse toResponse(CommonCode commonCode) {
        return CommonResponse.builder()
                .code(commonCode.getCode().value())
                .message(commonCode.getMessage())
                .build();
    }

    public static CommonResponse toErrorResponse(Code code) {
        return CommonResponse.builder()
                .code(code.getCode().value())
                .message(code.getMessage())
                .build();
    }

    public static CommonResponse toErrorResponse(Code code, String message) {
        return CommonResponse.builder()
                .code(code.getCode().value())
                .message(message)
                .build();
    }

    public static <T> ResponseEntity<CommonResponse> wrappingData(T responseData, CommonCode code) {
//        CommonResponse commonResponse = CommonResponse.toResponse(code, responseData);
//        return ResponseEntity.ok(commonResponse);
        CommonResponse commonResponse = CommonResponse.toResponse(code, responseData);
        return new ResponseEntity<>(commonResponse, code.getCode());
    }
}
