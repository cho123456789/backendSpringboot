package org.example.Service;

import org.example.Dto.APIResponse;
import org.example.Dto.MemberDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    List<MemberDto> getMember();

    List<MemberDto> getMemberById(Long from);

    APIResponse postMember(MemberDto memberDto);

    Long deleteMember(Long id);

    Long updateMember(MemberDto memberDto);

}
