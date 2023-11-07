package cn.hanamizu.campushelpba.service.impl;

import cn.hanamizu.campushelpba.Mapper.ServeMapper;
import cn.hanamizu.campushelpba.entity.Lost;
import cn.hanamizu.campushelpba.entity.Serve;
import cn.hanamizu.campushelpba.service.ServeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ServeServiceImpl extends ServiceImpl<ServeMapper, Serve>
        implements ServeService{
    private final ServeMapper serveMapper;

    public ServeServiceImpl(ServeMapper serveMapper) {
        this.serveMapper = serveMapper;
    }

    @Override
    public void saveLost(Lost deleted) {
        Serve serve = new Serve();
        serve.setServiceTime(new Date());
        serve.setStatus(1);
        serve.setType("丢失物品");
        serve.setUserId(deleted.getUserId());
        serve.setDestId(deleted.getId());
        serveMapper.insert(serve);
    }
}

