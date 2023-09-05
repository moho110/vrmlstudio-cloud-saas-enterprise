package com.vrmlstudio.gen.service.impl;

import com.vrmlstudio.common.web.entity.service.impl.BaseServiceImpl;
import com.vrmlstudio.gen.domain.dto.GenTableColumnDto;
import com.vrmlstudio.gen.manager.GenTableColumnManager;
import com.vrmlstudio.gen.mapper.GenTableColumnMapper;
import com.vrmlstudio.gen.service.IGenTableColumnService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务字段管理 服务层实现
 *
 * @author vrmlstudio
 */
@Service
public class GenTableColumnServiceImpl extends BaseServiceImpl<GenTableColumnDto, GenTableColumnManager, GenTableColumnMapper> implements IGenTableColumnService {

	/**
	 * 根据表名称查询数据库表列信息
	 *
	 * @param tableName 表名称
	 * @return 数据库表列信息
	 */
	@Override
	public List<GenTableColumnDto> selectDbTableColumnsByName(String tableName){
		return baseManager.selectDbTableColumnsByName(tableName);
	}
}