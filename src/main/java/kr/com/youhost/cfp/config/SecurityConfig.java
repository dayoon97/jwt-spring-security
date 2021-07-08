package kr.com.youhost.cfp.config;

import kr.com.youhost.cfp.jwt.JwtAccessDeniedHandler;
import kr.com.youhost.cfp.jwt.JwtAuthenticationEntryPoint;
import kr.com.youhost.cfp.jwt.JwtSecurityConfig;
import kr.com.youhost.cfp.jwt.TokenProvider;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //@PreAuthorize 어노테이션을 메소드단위로 추가하기 위해서 적용
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(TokenProvider tokenProvider, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAccessDeniedHandler jwtAccessDeniedHandler) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).antMatchers("/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic().disable() //security에서 기본으로 생성하는 login 페이지 사용 안함
                .csrf().disable()  //csrf 사용 안 함 == REST API 사용하기 때문
                .cors().disable()

                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //JWT 인증 사용하므로로 세션 사용 안함 (스프링시큐리티가 생성하지도 않고 기존 것을 사용하지도 않음)

                .and()
                 .authorizeRequests() //다음 리퀘스트에 대한 사용권한 체크
                   .antMatchers("/**").permitAll() //모든 페이지 누구나 접근 가능
                   .anyRequest().authenticated(); //그 외 나머지 요청은 모두 인증된 회원만 접근 가능


//        http
//                .httpBasic().disable()
//                .csrf().disable()
//
//                .exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .accessDeniedHandler(jwtAccessDeniedHandler)
//
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .antMatchers("/api/hello").permitAll()
//                .antMatchers("/user/login").permitAll()
//                .antMatchers("/user/signup").permitAll()
//
//                .anyRequest().authenticated();

//                .and()
//                .apply(new JwtSecurityConfig(tokenProvider));
    }

}
