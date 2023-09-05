package com.vrmlstudio.gen.manager;

import com.vrmlstudio.common.web.entity.manager.BaseManager;
import com.vrmlstudio.gen.domain.dto.GenTableColumnDto;
import com.vrmlstudio.gen.mapper.GenTableColumnMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 业务字段管理 数据封装层
 *
 * @author vrmlstudio
 */
@Component
public class GenTableColumnManager extends BaseManager<GenTableColumnDto, GenTableColumnMapper> {

    /**
     * 根据表名称查询数据库表列信息
     *
     * @param tableName 表名称
     * @return 数据库表列信息
     */
    public List<GenTableColumnDto> selectDbTableColumnsByName(String tableName){
        return baseMapper.selectDbTableColumnsByName(tableName);
    }

}
