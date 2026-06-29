package kr.co.sboard.dto;


import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;



@Data
@Component
public class AppInfoDTO {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.version}")
    private String appVersion;


}
