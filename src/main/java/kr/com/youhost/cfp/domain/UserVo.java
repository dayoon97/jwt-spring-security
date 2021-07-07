package kr.com.youhost.cfp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Data
public class UserVo {

    private Long userId;
    private String username;
    private String password;
    private String nickname;
    private boolean activated;

}
