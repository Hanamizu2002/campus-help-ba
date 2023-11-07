package cn.hanamizu.campushelpba.service;

import cn.hanamizu.campushelpba.entity.Lost;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface LostService extends IService<Lost> {
    List<Lost> getList();
    List<Lost> getList(Lost lost);

    Lost addList(Lost lost);

    Lost updateLost(Lost lost);

    boolean deleteLost(Long id);
}
