package cn.hanamizu.campushelpba.entity;

import java.util.Date;

public class Serve {
    private Integer id;
    private Date serviceTime; //发布时间
    private Integer status; // 0表示发布 1表示删除
    private String type; //类型
    private Integer userId; //发布者id
    private Integer destId; //帖子id
}
