package cn.hanamizu.campushelpba.service;

import cn.hanamizu.campushelpba.entity.User;

public interface UserService {
    User login(String studentId, String password, Integer schoolId);

    User Register(String userName, String studentId, String phone, String password, Integer schoolId, String invitedCode);

    User updateHeadImg(String studentId, String headImg);

    int getTotalUserCount();

    User update(String studentId, String username, String phone, String headImg);
    // TODO update更新的内容
}
