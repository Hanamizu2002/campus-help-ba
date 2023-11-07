package cn.hanamizu.campushelpba.service.impl;

import cn.hanamizu.campushelpba.Mapper.UserMapper;
import cn.hanamizu.campushelpba.entity.User;
import cn.hanamizu.campushelpba.service.UserService;
import cn.hanamizu.campushelpba.util.MD5Hash;
import cn.hanamizu.campushelpba.util.checkInfo.UserInfoCheck;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;
    MD5Hash md5Hash = new MD5Hash();
    UserInfoCheck userInfoCheck = new UserInfoCheck();

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String studentId, String password, Integer schoolId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", studentId);
        password = encrypt(password);
        queryWrapper.eq("password", password);
        queryWrapper.eq("school_id", schoolId);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User Register(String userName, String studentId, String phone, String password, Integer schoolId, String invitedCode) {
        if (!userInfoCheck.isValidRegistration(userName, studentId, phone, password, schoolId)) {
            return null; // 返回空表示注册失败
        }

        // 对密码进行加密
        password = encrypt(password);

        // 创建一个新的用户对象
        User newUser = new User();
        newUser.setUsername(userName);
        newUser.setStudentId(studentId);
        newUser.setPhone(phone);
        newUser.setPassword(password);
        newUser.setSchoolId(schoolId);
        newUser.setInvitedCode(invitedCode);

        // 插入用户数据到数据库
        userMapper.insert(newUser);

        return newUser; // 返回新注册的用户信息
    }

    @Override
    public User updateHeadImg(String studentId, String headImg) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", studentId);
        User existingUser = userMapper.selectOne(queryWrapper);

        if (existingUser == null) {
            return null;
        }

        existingUser.setHeadImg(headImg);

        userMapper.updateById(existingUser);

        return existingUser;
    }

    @Override
    public int getTotalUserCount() {
        //TODO 获取学生人数
        return 0;
    }

    @Override
    public User update(String studentId, String username, String phone, String headImg) {
        return null;
    }

    private String encrypt(String password) {
        //加盐
        password = "hanamizu" + password + "campushelp";
        //加密
        return md5Hash.hash(password);
    }
}
