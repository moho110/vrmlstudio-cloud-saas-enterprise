package com.vrmlstudio.system.monitor.mapper;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.api.log.domain.dto.SysLoginLogDto;

/**
 * 访问日志管理 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysLoginLogMapper extends BaseMapper<SysLoginLogDto> {
}
