package com.vrmlstudio.system.material.controller;

import com.vrmlstudio.common.web.entity.controller.BaseController;
import com.vrmlstudio.system.api.file.domain.dto.SysMaterialDto;
import com.vrmlstudio.system.material.service.ISysMaterialService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 素材管理 业务处理
 *
 * @author vrmlstudio
 */
@RestController
@RequestMapping("/material")
public class SysMaterialController extends BaseController<SysMaterialDto, ISysMaterialService> {

    /** 定义节点名称 */
    protected String getNodeName() {
        return "素材";
    }
}
