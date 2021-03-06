package com.zscat.ums.impl;

import com.github.pagehelper.PageHelper;
import com.zscat.ums.mapper.SmsCouponHistoryMapper;
import com.zscat.ums.model.SmsCouponHistory;
import com.zscat.ums.model.SmsCouponHistoryExample;
import com.zscat.ums.service.SmsCouponHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠券领取记录管理Service实现类
 * Created by zscat on 2018/11/6.
 */
@Service("smsCouponHistoryService")
public class SmsCouponHistoryServiceImpl implements SmsCouponHistoryService {
    @Resource
    private SmsCouponHistoryMapper historyMapper;

    @Override
    public List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsCouponHistoryExample example = new SmsCouponHistoryExample();
        SmsCouponHistoryExample.Criteria criteria = example.createCriteria();
        if (couponId != null) {
            criteria.andCouponIdEqualTo(couponId);
        }
        if (useStatus != null) {
            criteria.andUseStatusEqualTo(useStatus);
        }
        if (!StringUtils.isEmpty(orderSn)) {
            criteria.andOrderSnEqualTo(orderSn);
        }
        return historyMapper.selectByExample(example);
    }

    @Override
    public List<SmsCouponHistory> selectByExample(SmsCouponHistoryExample example){
        return historyMapper.selectByExample(example);
    }

    @Override
    public SmsCouponHistory selectByPrimaryKey(Long id){
        return historyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmsCouponHistory record){
        return historyMapper.updateByPrimaryKeySelective(record);
    }
}
