package com.vrmlstudio.system.material.service.impl;

import com.vrmlstudio.common.web.entity.service.impl.BaseServiceImpl;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialDto;
import com.vrmlstudio.system.material.manager.SysMaterialManager;
import com.vrmlstudio.system.material.mapper.SysMaterialMapper;
import com.vrmlstudio.system.material.service.ISysMaterialService;
import org.springframework.stereotype.Service;

/**
 * 素材管理 服务层处理
 *
 * @author vrmlstudio
 */
@Service
public class SysMaterialServiceImpl extends BaseServiceImpl<SysMaterialDto, SysMaterialManager, SysMaterialMapper> implements ISysMaterialService {
}
