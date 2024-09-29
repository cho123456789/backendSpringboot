package org.example.Service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.Dto.APIResponse;
import org.example.Dto.MemberDto;
import org.example.Mapper.MemberMapper;
import org.example.Service.MemberService;
import org.example.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.Util.Constants.SUCCESS_CODE;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberDto> getMember() {
        List<Member> memberList = memberMapper.getAllMember();

        // Log if the member list is empty
        if (memberList.isEmpty()) {
            log.warn("No members found.");
        }

        return memberList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MemberDto> getMemberById(Long from) {
        List<Member> memberList = memberMapper.getMemberList(from);

        if (memberList == null || memberList.isEmpty()) {
            log.warn("No members found with id: {}", from);
            return List.of(); // Return an empty list if no members found
        }

        return memberList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public APIResponse postMember(MemberDto memberDto) {
        memberMapper.postMember(memberDto);  // Ensure this inserts the member
        return APIResponse.builder()
                .resultCode(SUCCESS_CODE)
                .resultMessage("Inquiry registered")
                .result(memberDto)
                .build();
    }

    @Override
    public Long deleteMember(Long id) {
       // int rowsAffected = memberMapper.deleteMember(id);
        return null; // Return id if deletion was successful
    }

    @Override
    public Long updateMember(MemberDto memberDto) {
        //int rowsAffected = memberMapper.updateMember(memberDto);
        return  null; // Return id if update was successful
    }

    // Private method to map Member to MemberDto
    private MemberDto mapToDto(Member member) {
        return MemberDto.builder()
                .userId(member.getUserId())
                .userName(member.getUserName())
                .userNumber(member.getUserNumber())
                .build();
    }
}
