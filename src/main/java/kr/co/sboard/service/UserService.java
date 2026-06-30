package kr.co.sboard.service;

import kr.co.sboard.dao.ArticleDAO;
import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.repository.ArticleRepository;
import kr.co.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserDAO dao;
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public UserDTO get(String userid){
        return null;
    }
    public List<UserDTO> getAll(){
        return null;
    }

    public int getCount(String value){

        // JPA
        int count = repository.countByUserid(value);


        return count;
    }

    public void register(UserDTO dto){
        // 비밀번호 암호화
        String encoded = passwordEncoder.encode(dto.getPass());
        dto.setPass(encoded);

        // Mybatis
        //dao.insert(dto);

        // JPA
        repository.save(dto.toEntity());
    }

    public void modify(UserDTO dto){

    }
    public void remove(String userid){

    }



}
