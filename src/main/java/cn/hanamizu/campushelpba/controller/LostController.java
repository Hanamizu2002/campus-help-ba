package cn.hanamizu.campushelpba.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.hanamizu.campushelpba.entity.Lost;

import cn.hanamizu.campushelpba.service.LostService;
import cn.hanamizu.campushelpba.service.ServeService;
import cn.hanamizu.campushelpba.util.result.Result;
import cn.hanamizu.campushelpba.util.result.ResultUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lost")
public class LostController {
    private final LostService lostService;
    private final ServeService serveService;

    public LostController(LostService lostService, ServeService serveService) {
        this.lostService = lostService;
        this.serveService = serveService;
    }
    @GetMapping("/list")
    public Result getLostList() {
        List<Lost> result = lostService.getList();
        if (result != null) return ResultUtil.success(result);
        return ResultUtil.failure();
    }

    @PostMapping("/statusList")
    public Result getStatusList(@RequestBody Lost lost) {
        List<Lost> result = lostService.getList(lost);
        if (result != null) return ResultUtil.success(result);
        return ResultUtil.failure();
    }

    @GetMapping("/deleteLost")
    public Result deleteUnused() {
        QueryWrapper<Lost> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 2);
        Lost deleted = lostService.getOne(queryWrapper);
        if (deleted != null) {
            lostService.remove(queryWrapper);
            serveService.saveLost(deleted);
            return ResultUtil.success();
        }
        return ResultUtil.failure();
    }

    @GetMapping("/addLost")
    public Result add(@RequestBody Lost lost) {
        Lost addLost = lostService.addList(lost);
        if (addLost != null) {
            return ResultUtil.success("添加成功");
        } else {
            return ResultUtil.failure("添加失败");
        }
    }

    @PostMapping("/updateLost")
    public Result updateLost(@RequestBody Lost lost) {
        // 实现更新失物招领帖子的逻辑
        Lost updatedLost = lostService.updateLost(lost);
        if (updatedLost != null) {
            return ResultUtil.success("更新成功");
        } else {
            return ResultUtil.failure("更新失败");
        }
    }
    @GetMapping("/deleteLost/{id}")
    public Result deleteLost(@PathVariable Long id) {
        // 实现删除失物招领帖子的逻辑
        boolean deleted = lostService.deleteLost(id);
        if (deleted) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.failure("删除失败");
        }
    }


}
