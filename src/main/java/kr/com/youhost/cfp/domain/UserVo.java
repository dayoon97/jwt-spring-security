package kr.com.youhost.cfp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String email;
    private String mobile;
    private String userRole;    // 1:admin, 2:사용자
    private String useYn;
    private String emailAlarm;
    private String smsAlarm;
    private String regDate;
    private String modDate;

}
