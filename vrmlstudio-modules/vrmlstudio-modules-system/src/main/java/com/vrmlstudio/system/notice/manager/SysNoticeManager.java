package com.vrmlstudio.system.notice.manager;

import com.vrmlstudio.common.web.entity.manager.BaseManager;
import com.vrmlstudio.system.notice.domain.dto.SysNoticeDto;
import com.vrmlstudio.system.notice.mapper.SysNoticeMapper;
import org.springframework.stereotype.Component;

/**
 * 通知公告管理 数据封装层
 *
 * @author vrmlstudio
 */
@Component
public class SysNoticeManager extends BaseManager<SysNoticeDto, SysNoticeMapper> {
}
