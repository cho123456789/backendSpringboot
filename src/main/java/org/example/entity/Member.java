package org.example.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Dto.MemberDto;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long userId;
    private String userName;
    private Long userNumber;

}


