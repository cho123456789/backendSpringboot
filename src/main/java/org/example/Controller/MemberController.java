package org.example.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.Dto.APIResponse;
import org.example.Dto.MemberDto;
import org.example.Service.MemberService;
import org.example.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.Util.Constants.FAILURE_CODE;
import static org.example.Util.Constants.SUCCESS_CODE;

@RestController
@Slf4j
@RequestMapping("/api/v1/")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/save")
    public ResponseEntity<APIResponse> postMemberList(@RequestBody MemberDto memberDto){
        try{
            return new ResponseEntity<>(
                    memberService.postMember(memberDto),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    APIResponse.builder()
                            .resultCode(FAILURE_CODE)
                            .resultMessage("Failed to member List")
                            .result(0)
                            .build(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
    @GetMapping("/memberList")
    public ResponseEntity<APIResponse> getMemberList(@RequestParam("userId") final Long userId) {
        try {
            // service
            List<MemberDto> members = memberService.getMemberById(userId); // 리스트 반환
            return new ResponseEntity<>(
                    APIResponse.builder()
                            .resultCode(SUCCESS_CODE)
                            .result(members)
                            .resultMessage("Succees")
                            .build(),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            log.error("Error fetching member list: ", e);
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
