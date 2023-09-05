package com.vrmlstudio.system.notice.mapper;

import com.vrmlstudio.common.datasource.annotation.Isolate;
import com.vrmlstudio.common.web.entity.mapper.BaseMapper;
import com.vrmlstudio.system.notice.domain.dto.SysNoticeDto;

/**
 * 通知公告管理 数据层
 *
 * @author vrmlstudio
 */
@Isolate
public interface SysNoticeMapper extends BaseMapper<SysNoticeDto> {
}
