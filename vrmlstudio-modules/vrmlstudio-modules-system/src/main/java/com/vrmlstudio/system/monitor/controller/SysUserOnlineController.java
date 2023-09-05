package com.vrmlstudio.system.monitor.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.vrmlstudio.common.core.constant.basic.CacheConstants;
import com.vrmlstudio.common.core.constant.basic.SecurityConstants;
import com.vrmlstudio.common.core.utils.StringUtils;
import com.vrmlstudio.common.core.web.result.AjaxResult;
import com.vrmlstudio.common.log.annotation.Log;
import com.vrmlstudio.common.log.enums.BusinessType;
import com.vrmlstudio.common.redis.service.RedisService;
import com.vrmlstudio.common.security.annotation.RequiresPermissions;
import com.vrmlstudio.common.security.auth.Auth;
import com.vrmlstudio.common.security.utils.SecurityUtils;
import com.vrmlstudio.common.web.entity.controller.BasisController;
import com.vrmlstudio.system.api.model.LoginUser;
import com.vrmlstudio.system.monitor.domain.SysUserOnline;
import com.vrmlstudio.system.monitor.service.ISysUserOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 在线用户监控
 *
 * @author vrmlstudio
 */
@RestController
@RequestMapping("/online")
public class SysUserOnlineController extends BasisController {

    @Autowired
    private ISysUserOnlineService userOnlineService;

    @Autowired
    private RedisService redisService;

    @GetMapping("/list")
    @RequiresPermissions(Auth.SYS_ONLINE_LIST)
    public AjaxResult list(String ipaddr, String userName) {
        Collection<String> keys = redisService.keys(CacheConstants.LOGIN_TOKEN_KEY + SecurityUtils.getEnterpriseId() + StrUtil.COLON + "*");
        List<SysUserOnline> userOnlineList = new ArrayList<>();
        for (String key : keys) {
            LoginUser loginUser = redisService.getCacheMapValue(key, SecurityConstants.LOGIN_USER);
            if (StringUtils.isNotEmpty(ipaddr) && StringUtils.isNotEmpty(userName)) {
                if (StringUtils.equals(ipaddr, loginUser.getIpaddr()) && StringUtils.equals(userName, loginUser.getUserName())) {
                    userOnlineList.add(userOnlineService.selectOnlineByInfo(ipaddr, userName, loginUser));
                }
            } else if (StringUtils.isNotEmpty(ipaddr)) {
                if (StringUtils.equals(ipaddr, loginUser.getIpaddr())) {
                    userOnlineList.add(userOnlineService.selectOnlineByIpaddr(ipaddr, loginUser));
                }
            } else if (StringUtils.isNotEmpty(userName)) {
                if (StringUtils.equals(userName, loginUser.getUserName())) {
                    userOnlineList.add(userOnlineService.selectOnlineByUserName(userName, loginUser));
                }
            } else {
                userOnlineList.add(userOnlineService.loginUserToUserOnline(loginUser));
            }
        }
        Collections.reverse(userOnlineList);
        userOnlineList.removeAll(Collections.singleton(null));
        return getDataTable(userOnlineList);
    }

    /**
     * 强退用户
     */
    @DeleteMapping("/batch/{idList}")
    @RequiresPermissions(Auth.SYS_ONLINE_FORCE_LOGOUT)
    @Log(title = "在线用户", businessType = BusinessType.FORCE)
    public AjaxResult forceLogout(@PathVariable List<String> idList) {
        if (ArrayUtil.isNotEmpty(idList))
            idList.forEach(id -> redisService.deleteObject(CacheConstants.LOGIN_TOKEN_KEY + id));
        return AjaxResult.success();
    }
}
