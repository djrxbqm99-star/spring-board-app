package kr.co.sboard.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.sboard.dto.AppInfoDTO;
import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.service.TermsService;
import kr.co.sboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final TermsService termsService;


    @GetMapping("/user/info")
    public String info(){
        return "/user/info";
    }
    @GetMapping("/user/login")
    public String login(){
        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register(){
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO userDTO, HttpServletRequest req){
        // 클라이언트 IP
        String regip = req.getRemoteAddr();
        userDTO.setRegip(regip);

        log.info(userDTO);

        // 등록 서비스 호출
        userService.register(userDTO);

        // 로그인 이동
        return "redirect:/user/login?register=success";
    }
    
    
    @GetMapping("/user/terms")
    public String terms(Model model){
        
        // 약관 조회 서비스 호출
        TermsDTO termsDTO = termsService.get(1);
        log.info(termsDTO);

        // 모델 참조
        model.addAttribute(termsDTO);
        
        return "/user/terms";
    }
}
