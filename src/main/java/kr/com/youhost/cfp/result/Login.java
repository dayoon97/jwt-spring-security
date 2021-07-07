package kr.com.youhost.cfp.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.UUID;

@Data
public class Login {

    private long 	loginNo;
    private long 	userNo;
    private String loginStatus; 	// 로그인상태(1:로그인, 2:로그아웃)

    private String loginAt;
    private String logoutAt;

    private String authToken;

    @JsonIgnore
    public boolean isLogin() {
        return "1".equals(loginStatus);
    }
    @JsonIgnore
    public boolean isLogout() {
        return !isLogin();
    }

    @JsonIgnore
    public static String newAuthToken( ) {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
    @JsonIgnore
    public static Login newLogin( final long userNo ) {
        Login login = new Login();
        login.setUserNo( userNo );
        login.setAuthToken( newAuthToken() );

        return login;
    }
}
