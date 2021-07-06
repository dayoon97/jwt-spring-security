package kr.com.youhost.cfp.querydsl.entity;

import kr.com.youhost.cfp.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private long userId;
    private String userName;
    private String userPwd;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userName(userName)
                .userPwd(userPwd)
                .build();
    }

    @Builder
    public UserDto(long userId, String userName, String userPwd) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
    }
}
