package com.vrmlstudio.system.material.manager;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.vrmlstudio.common.web.entity.manager.SubTreeManager;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialDto;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialFolderDto;
import com.vrmlstudio.system.material.mapper.SysMaterialFolderMapper;
import com.vrmlstudio.system.material.mapper.SysMaterialMapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 素材分类管理 数据封装层
 *
 * @author vrmlstudio
 */
@Component
public class SysMaterialFolderManager extends SubTreeManager<SysMaterialFolderDto, SysMaterialFolderMapper, SysMaterialDto, SysMaterialMapper> {

    /**
     * 设置主子表中子表外键值
     */
    @Override
    protected void setForeignKey(LambdaQueryWrapper<SysMaterialDto> queryWrapper, LambdaUpdateWrapper<SysMaterialDto> updateWrapper, SysMaterialFolderDto folder, Serializable id) {
        Serializable folderId = ObjectUtil.isNotNull(folder) ? folder.getId() : id;
        if (ObjectUtil.isNotNull(queryWrapper))
            queryWrapper.eq(SysMaterialDto::getFolderId, folderId);
        else
            updateWrapper.eq(SysMaterialDto::getFolderId, folderId);
    }
}
