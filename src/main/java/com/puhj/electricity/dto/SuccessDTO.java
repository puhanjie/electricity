package com.puhj.electricity.dto;

import com.puhj.electricity.util.HttpRequestProxy;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuccessDTO {
    private Integer code = 0;
    private String message = "ok";
    private String request = HttpRequestProxy.getRequestUrl();
}
