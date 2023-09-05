package com.vrmlstudio.tenant.tenant.manager;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.vrmlstudio.common.core.constant.basic.SqlConstants;
import com.vrmlstudio.common.web.entity.manager.BaseManager;
import com.vrmlstudio.tenant.api.tenant.domain.dto.TeStrategyDto;
import com.vrmlstudio.tenant.tenant.mapper.TeStrategyMapper;
import org.springframework.stereotype.Component;


/**
 * 数据源策略管理 数据封装层
 *
 * @author vrmlstudio
 */
@Component
public class TeStrategyManager extends BaseManager<TeStrategyDto, TeStrategyMapper> {

    /**
     * 校验数据源是否被使用
     *
     * @param sourceId 数据源id
     * @return 结果
     */
    public TeStrategyDto checkSourceExist(Long sourceId) {
        return baseMapper.selectOne(
                Wrappers.<TeStrategyDto>query().lambda()
                        .eq(TeStrategyDto::getSourceId, sourceId)
                        .last(SqlConstants.LIMIT_ONE));
    }
}