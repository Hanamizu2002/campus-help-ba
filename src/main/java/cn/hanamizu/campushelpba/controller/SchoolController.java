package cn.hanamizu.campushelpba.controller;

import cn.hanamizu.campushelpba.entity.School;
import cn.hanamizu.campushelpba.service.SchoolService;
import cn.hanamizu.campushelpba.util.result.Result;
import cn.hanamizu.campushelpba.util.result.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/list")
    public Result getSchoolList(){
        List<School> result = schoolService.getList();
        if(result != null) return ResultUtil.success(result);
        return ResultUtil.failure();
    }
}
