package cn.hanamizu.campushelpba.service.impl;

import org.springframework.stereotype.Service;
import cn.hanamizu.campushelpba.Mapper.SchoolMapper;
import cn.hanamizu.campushelpba.entity.School;
import cn.hanamizu.campushelpba.service.SchoolService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements SchoolService {

    private final SchoolMapper schoolMapper;

    public SchoolServiceImpl(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }

    @Override
    public List getList() {
        QueryWrapper<School> queryWrapper = new QueryWrapper<>();
        return schoolMapper.selectList(queryWrapper);
    }
}
