package cn.hanamizu.campushelpba.service.impl;

import cn.hanamizu.campushelpba.Mapper.LostMapper;
import cn.hanamizu.campushelpba.entity.Lost;
import cn.hanamizu.campushelpba.service.LostService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostServiceImpl extends ServiceImpl<LostMapper, Lost> implements LostService {

    private final LostMapper lostMapper;

    public LostServiceImpl(LostMapper lostMapper) {
        this.lostMapper = lostMapper;
    }

    @Override
    public List<Lost> getList() {
        QueryWrapper<Lost> queryWrapper = new QueryWrapper<>();
        return lostMapper.selectList(queryWrapper);
    }

    @Override
    public List<Lost> getList(Lost lost) {
        QueryWrapper<Lost> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("school_id", lost.getSchoolId());
        queryWrapper.eq("status", lost.getStatus());
        return lostMapper.selectList(queryWrapper);
    }

    @Override
    public Lost addList(Lost lost) {
        Lost newLost = new Lost();

        newLost.setUserId(lost.getUserId());
        newLost.setTitle(lost.getTitle());
        newLost.setDescription(lost.getDescription());
        newLost.setAddTime(lost.getAddTime());
        newLost.setImgSrc(lost.getImgSrc());
        newLost.setSchoolId(lost.getSchoolId());
        newLost.setContactPhone(lost.getContactPhone());
        newLost.setContactWx(lost.getContactWx());
        newLost.setContactQq(lost.getContactQq());
        newLost.setStatus(lost.getStatus());

        lostMapper.insert(newLost);
        return newLost;
    }

    @Override
    public Lost updateLost(Lost lost) {
        // 首先检查帖子是否存在
        QueryWrapper<Lost> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", lost.getId());
        Lost existingLost = lostMapper.selectOne(queryWrapper);

        if (existingLost != null) {
            // 更新帖子信息
            existingLost.setTitle(lost.getTitle());
            existingLost.setDescription(lost.getDescription());
            existingLost.setContactPhone(lost.getContactPhone());
            existingLost.setContactWx(lost.getContactWx());
            existingLost.setContactQq(lost.getContactQq());

            // 保存更新后的帖子信息
            int rows = lostMapper.updateById(existingLost);
            if (rows > 0) {
                return existingLost;
            }
        }

        return null; // 更新失败
    }

    @Override
    public boolean deleteLost(Long id) {
        // 首先检查帖子是否存在
        QueryWrapper<Lost> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        Lost existingLost = lostMapper.selectOne(queryWrapper);

        if (existingLost != null) {
            // 删除帖子
            int rows = lostMapper.deleteById(id);
            if (rows > 0) {
                return true; // 删除成功
            }
        }

        return false; // 删除失败
    }
}
