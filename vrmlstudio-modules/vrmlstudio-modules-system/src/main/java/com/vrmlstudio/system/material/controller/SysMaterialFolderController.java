package com.vrmlstudio.system.material.controller;

import com.vrmlstudio.common.web.entity.controller.SubTreeController;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialDto;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialFolderDto;
import com.vrmlstudio.system.material.service.ISysMaterialFolderService;
import com.vrmlstudio.system.material.service.ISysMaterialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 素材分类管理 业务处理
 *
 * @author vrmlstudio
 */
@RestController
@RequestMapping("/material/folder")
public class SysMaterialFolderController extends SubTreeController<SysMaterialFolderDto, ISysMaterialFolderService, SysMaterialDto, ISysMaterialService> {

    /** 定义节点名称 */
    protected String getNodeName() {
        return "文件夹";
    }

    /** 定义子数据名称 */
    protected String getSubName() {
        return "素材";
    }
}
