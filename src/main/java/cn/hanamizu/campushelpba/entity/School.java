package cn.hanamizu.campushelpba.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("school")
public class School {

    private Integer id;
    private String schoolName;
    private String schoolAddress;


}
