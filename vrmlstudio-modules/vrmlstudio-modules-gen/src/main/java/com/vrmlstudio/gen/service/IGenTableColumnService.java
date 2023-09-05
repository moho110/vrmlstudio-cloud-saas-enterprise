package com.vrmlstudio.gen.service;

import com.vrmlstudio.common.web.entity.service.IBaseService;
import com.vrmlstudio.gen.domain.dto.GenTableColumnDto;

import java.util.List;

/**
 * 业务字段管理 服务层
 *
 * @author vrmlstudio
 */
public interface IGenTableColumnService extends IBaseService<GenTableColumnDto> {

    /**
     * 根据表名称查询数据库表列信息
     *
     * @param tableName 表名称
     * @return 数据库表列信息
     */
    List<GenTableColumnDto> selectDbTableColumnsByName(String tableName);
}