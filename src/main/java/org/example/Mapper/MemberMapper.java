package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.Dto.MemberDto;
import org.example.entity.Member;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<Member> getAllMember();

    List<Member> getMemberList(@Param("userId") Long from);

    long postMember(MemberDto memberDto);
    long deleteMember(MemberDto memberDto);

}