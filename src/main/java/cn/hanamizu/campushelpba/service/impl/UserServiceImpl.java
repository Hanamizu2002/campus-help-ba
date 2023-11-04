package cn.hanamizu.campushelpba.service.impl;

import cn.hanamizu.campushelpba.Mapper.UserMapper;
import cn.hanamizu.campushelpba.entity.User;
import cn.hanamizu.campushelpba.service.UserService;
import cn.hanamizu.campushelpba.util.MD5Hash;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;
    MD5Hash md5Hash = new MD5Hash();

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(Integer studentId, String password, Integer schoolId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", studentId);
        password = encrypt(password);
        queryWrapper.eq("password", password);
        queryWrapper.eq("school_id", schoolId);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User Register(String userName, Integer studentId, String phone, String password, Integer schoolId, String invitedCode) {

        password = encrypt(password);
        return null;
    }

    private String encrypt(String password) {
        //加盐
        password = "hanamizu" + password + "campushelp";
        //加密
        return md5Hash.hash(password);
    }




}
