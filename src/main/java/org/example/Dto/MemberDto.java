package org.example.Dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.entity.Member;
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private Long userId;
    private String userName;
    private Long userNumber;

}
