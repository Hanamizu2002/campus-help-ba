package cn.hanamizu.campushelpba.service;

import cn.hanamizu.campushelpba.entity.User;

public interface UserService {
    User login(Integer studentId, String password, Integer schoolId);

    User Register(String userName, Integer studentId, String phone, String password, Integer schoolId, String invitedCode);

}
