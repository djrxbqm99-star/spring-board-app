package kr.co.sboard.config;

import kr.co.sboard.dto.AppInfoDTO;
import kr.co.sboard.interceptor.AppInfoInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    private AppInfoDTO appInfo;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AppInfoInterceptor(appInfo));
    }

    @Bean
    public AppInfoDTO appInfo(){
        appInfo = new AppInfoDTO();
        return appInfo;
    }

}
