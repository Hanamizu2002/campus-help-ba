package cn.hanamizu.campushelpba.controller;

import cn.hanamizu.campushelpba.Mapper.UserMapper;
import cn.hanamizu.campushelpba.entity.User;
import cn.hanamizu.campushelpba.service.UserService;
import cn.hanamizu.campushelpba.util.result.Result;
import cn.hanamizu.campushelpba.util.result.ResultUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public Result signIn(@RequestBody User user) {
        User result = userService.login(user.getStudentId(), user.getPassword(), user.getSchoolId());
        if (result != null) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("student_id", user.getStudentId());
            return ResultUtil.success(userMapper.selectOne(queryWrapper)); //返回用户信息
        } else {
            return ResultUtil.failure("登录失败，用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public Result signUp(@RequestBody User user) {
        User registeredUser = userService.Register(user.getUsername(), user.getStudentId(), user.getPhone(), user.getPassword(), user.getSchoolId(), user.getInvitedCode());
        if (registeredUser != null) {
            // TODO 返回user表对应的所有信息
            // TODO session
            return ResultUtil.success(registeredUser);
        } else {
            return ResultUtil.failure("注册失败，用户名、学号、手机号等信息不合法");
        }
    }
    // TODO 忘记密码
    @PostMapping("/updateHeadImg")
    public Result updateHeadImg(@RequestBody User user) {
        User result = userService.updateHeadImg(user.getStudentId(), user.getHeadImg());
        if (result != null) {
            return ResultUtil.success(result);
        } else {
            return ResultUtil.failure("更新失败");
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        User result = userService.update(user.getStudentId(), user.getUsername(), user.getPhone(), user.getEmail());
        if (result != null) {
            return ResultUtil.success(result);
        } else {
            return ResultUtil.failure("更新失败");
        }
    }
    @PostMapping("/getTotalUserCount")
    public Result getTotalUserCount() {
        int result = userService.getTotalUserCount();
        if (result != 0) {
            return ResultUtil.success(result);
        } else {
            return ResultUtil.failure("获取失败");
        }
    }
}
