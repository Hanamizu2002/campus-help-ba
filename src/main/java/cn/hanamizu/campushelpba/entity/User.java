package cn.hanamizu.campushelpba.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("user")
public class User {
    private Integer id;

    private String username;

    private String StudentId;

    private String password;

    private Integer schoolId;

    private String phone;

    private String inviteCode;

    private String invitedCode;

    private String headImg;

    private String email;

}
