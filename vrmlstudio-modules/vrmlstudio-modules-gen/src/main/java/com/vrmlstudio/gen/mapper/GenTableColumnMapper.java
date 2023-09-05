package com.vrmlstudio.gen.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.gen.domain.dto.GenTableColumnDto;

import java.util.List;

/**
 * 业务字段管理 数据层
 *
 * @author vrmlstudio
 */
public interface GenTableColumnMapper extends BaseMapper<GenTableColumnDto> {

    /**
     * 根据表名称查询数据库表列信息
     *
     * @param tableName 表名称
     * @return 数据库表列信息
     */
    @InterceptorIgnore(tenantLine = "1")
    List<GenTableColumnDto> selectDbTableColumnsByName(String tableName);

}