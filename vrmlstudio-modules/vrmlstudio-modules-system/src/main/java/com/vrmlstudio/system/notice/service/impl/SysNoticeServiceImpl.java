package com.vrmlstudio.system.notice.service.impl;

import com.vrmlstudio.common.datascope.annotation.DataScope;
import com.vrmlstudio.common.web.entity.service.impl.BaseServiceImpl;
import com.vrmlstudio.system.notice.domain.dto.SysNoticeDto;
import com.vrmlstudio.system.notice.manager.SysNoticeManager;
import com.vrmlstudio.system.notice.mapper.SysNoticeMapper;
import com.vrmlstudio.system.notice.service.ISysNoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.vrmlstudio.common.core.constant.basic.SecurityConstants.CREATE_BY;

/**
 * 通知公告管理 服务层处理
 *
 * @author vrmlstudio
 */
@Service
public class SysNoticeServiceImpl extends BaseServiceImpl<SysNoticeDto, SysNoticeManager, SysNoticeMapper> implements ISysNoticeService {

    /**
     * 查询通知公告对象列表 | 数据权限 | 附加数据
     *
     * @param notice 通知公告对象
     * @return 通知公告对象集合
     */
    @Override
    @DataScope(userAlias = CREATE_BY, mapperScope = {"SysNoticeMapper"})
    public List<SysNoticeDto> selectListScope(SysNoticeDto notice) {
        return baseManager.selectListExtra(notice);
    }
}
