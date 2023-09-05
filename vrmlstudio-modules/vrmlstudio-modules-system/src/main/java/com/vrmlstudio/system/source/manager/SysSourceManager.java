package com.vrmlstudio.system.source.manager;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.vrmlstudio.common.core.constant.basic.BaseConstants;
import com.vrmlstudio.common.web.entity.manager.BaseManager;
import com.vrmlstudio.system.api.source.domain.Source;
import com.vrmlstudio.system.source.mapper.SysSourceMapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 策略组管理 数据封装层
 *
 * @author vrmlstudio
 */
@Component
public class SysSourceManager extends BaseManager<Source, SysSourceMapper> {

    /**
     * 查询源策略组列表
     *
     * @return 策略组集合
     */
    public List<Source> selectSourceList() {
        return baseMapper.selectList(
                Wrappers.<Source>query().lambda()
                        .eq(Source::getStatus, BaseConstants.Status.NORMAL.getCode()));
    }

    /**
     * 根据Id查询源策略组
     *
     * @param id 源策略Id
     * @return 源策略组
     */
    @Override
    public Source selectById(Serializable id) {
        return baseMapper.selectOne(Wrappers.<Source>query().lambda()
                .eq(Source::getId, id)
                .eq(Source::getStatus, BaseConstants.Status.NORMAL.getCode()));
    }
}
