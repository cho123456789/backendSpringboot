package org.example.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class APIResponse {

    private int resultCode;

    private String resultMessage;

    private Object result;
}
