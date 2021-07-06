package kr.com.youhost.cfp.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_new_user")
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(name="user_name")
    private String userName;
    @Column(name="user_pwd")
    private String userPwd;

    @Builder
    public User(Long userId, String userName, String userPwd) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
    }
}
