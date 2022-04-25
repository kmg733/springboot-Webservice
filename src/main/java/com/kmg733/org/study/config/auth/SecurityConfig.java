package com.kmg733.org.study.config.auth;

import com.kmg733.org.study.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
// Spring Security 설정들을 활성화 시켜줌
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // h2-console 화면을 사용하기 위해 해당 옵션들을 disable 해줌
        http.csrf().disable().headers().frameOptions().disable()
                .and()
                    // URL별 권한 관리를 설정하는 옵션의 시작점
                    .authorizeRequests()
                    // 권한 관리 대상을 지정하는 옵션
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    // 설정된 값들 이외 나머지 URL들을 나타냄, authenticated을 추가하여 인증된 사용자만 접근 허용
                    .anyRequest().authenticated()
                .and()
                    // 로그아웃 기능에 대한 설정의 진입점
                    .logout()
                        // 로그아웃 성공 시 주소
                        .logoutSuccessUrl("/")
                .and()
                    // OAuth 2 로그인 기능에 대한 설정의 진입점
                    .oauth2Login()
                        // OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당
                        .userInfoEndpoint()
                            // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
                            .userService(customOAuth2UserService);

    }
}
