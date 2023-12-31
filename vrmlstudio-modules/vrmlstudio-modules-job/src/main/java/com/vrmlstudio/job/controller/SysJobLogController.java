package com.vrmlstudio.job.controller;

import com.vrmlstudio.common.core.domain.R;
import com.vrmlstudio.common.core.web.result.AjaxResult;
import com.vrmlstudio.common.log.annotation.Log;
import com.vrmlstudio.common.log.enums.BusinessType;
import com.vrmlstudio.common.security.annotation.InnerAuth;
import com.vrmlstudio.common.security.annotation.RequiresPermissions;
import com.vrmlstudio.common.security.auth.Auth;
import com.vrmlstudio.common.web.entity.controller.BaseController;
import com.vrmlstudio.job.api.domain.dto.SysJobLogDto;
import com.vrmlstudio.job.service.ISysJobLogService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 调度日志管理 业务处理
 *
 * @author vrmlstudio
 */
@RestController
@RequestMapping("/job/log")
public class SysJobLogController extends BaseController<SysJobLogDto, ISysJobLogService> {

    /** 定义节点名称 */
    @Override
    protected String getNodeName() {
        return "调度日志";
    }

    /**
     * 新增调度日志 | 内部调用
     */
    @InnerAuth
    @PostMapping
    public R<Boolean> addInner(@RequestBody SysJobLogDto jobLog) {
        baseService.insert(jobLog);
        return R.ok();
    }

    /**
     * 查询调度日志列表
     */
    @Override
    @GetMapping("/list")
    @RequiresPermissions(Auth.SCHEDULE_JOB_LIST)
    public AjaxResult list(SysJobLogDto jobLog) {
        return super.list(jobLog);
    }

    /**
     * 查询调度日志详细
     */
    @Override
    @GetMapping(value = "/{id}")
    @RequiresPermissions(Auth.SCHEDULE_JOB_SINGLE)
    public AjaxResult getInfoExtra(@PathVariable Serializable id) {
        return super.getInfoExtra(id);
    }

    /**
     * 调度日志导出
     */
    @Override
    @PostMapping("/export")
    @RequiresPermissions(Auth.SCHEDULE_JOB_EXPORT)
    @Log(title = "调度日志管理", businessType = BusinessType.EXPORT)
    public void export(HttpServletResponse response, SysJobLogDto jobLog) {
        super.export(response, jobLog);
    }

    /**
     * 清空调度日志
     */
    @DeleteMapping("/clean")
    @RequiresPermissions(Auth.SCHEDULE_JOB_DELETE)
    @Log(title = "调度日志管理", businessType = BusinessType.CLEAN)
    public AjaxResult clean() {
        baseService.cleanLog();
        return AjaxResult.success();
    }
}
