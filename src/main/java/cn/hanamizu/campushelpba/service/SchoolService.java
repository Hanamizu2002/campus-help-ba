package cn.hanamizu.campushelpba.service;

import cn.hanamizu.campushelpba.entity.School;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SchoolService extends IService<School> {
    List getList();
}
