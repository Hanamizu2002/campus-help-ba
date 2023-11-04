package cn.hanamizu.campushelpba.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @TableName task
 * @Description 任务
 */
@Data
@TableName("task")
public class Task {

    private Integer id;

    /**
     *
     */
    private Integer userId;

    /**
     * 物品的标题
     */
    private String title;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private Date addTime;

    /**
     *
     */
    private String imgSrc;

    /**
     *
     */
    private Integer schoolId;

    /**
     *
     */
    private String contactPhone;

    /**
     *
     */
    private String contactQq;

    /**
     *
     */
    private String contactWx;

    /**
     * 0表示丢东西，1表示捡到东西
     */
    private Integer status;
}
