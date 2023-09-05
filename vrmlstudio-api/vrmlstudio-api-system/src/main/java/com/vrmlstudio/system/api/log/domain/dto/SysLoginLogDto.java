package com.vrmlstudio.system.api.log.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vrmlstudio.system.api.log.domain.po.SysLoginLogPo;

/**
 * 访问日志 数据传输对象
 *
 * @author vrmlstudio
 */
@TableName(value = "sys_login_log",excludeProperty = {"name","sort","createBy","createTime","updateBy","updateTime","remark"})
public class SysLoginLogDto extends SysLoginLogPo {

    private static final long serialVersionUID = 1L;

}
