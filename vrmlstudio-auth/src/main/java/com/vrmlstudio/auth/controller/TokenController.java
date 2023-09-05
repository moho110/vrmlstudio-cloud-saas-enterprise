package com.vrmlstudio.auth.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.vrmlstudio.auth.form.LoginBody;
import com.vrmlstudio.auth.form.RegisterBody;
import com.vrmlstudio.auth.service.SysLoginService;
import com.vrmlstudio.common.core.utils.JwtUtils;
import com.vrmlstudio.common.core.web.result.AjaxResult;
import com.vrmlstudio.common.security.auth.AuthUtil;
import com.vrmlstudio.common.security.service.TokenService;
import com.vrmlstudio.common.security.utils.SecurityUtils;
import com.vrmlstudio.system.api.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * token 控制
 *
 * @author vrmlstudio
 */
@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysLoginService sysLoginService;

    @PostMapping("login")
    public AjaxResult login(@RequestBody LoginBody form) {
        // 用户登录
        LoginUser userInfo = sysLoginService.login(form.getEnterpriseName(), form.getUserName(), form.getPassword());
        // 获取登录token
        return AjaxResult.success(tokenService.createToken(userInfo));
    }

    @DeleteMapping("logout")
    public AjaxResult logout(HttpServletRequest request) {
        String token = SecurityUtils.getToken(request);
        if (StrUtil.isNotEmpty(token)) {
            LoginUser loginUser = tokenService.getLoginUser(request);
            // 删除用户缓存记录
            AuthUtil.logoutByToken(token);
            if (ObjectUtil.isNotNull(loginUser)) {
                String sourceName = JwtUtils.getSourceName(token);
                Long enterpriseId = Long.valueOf(JwtUtils.getEnterpriseId(token));
                String enterpriseName = JwtUtils.getEnterpriseName(token);
                Long userId = Long.valueOf(JwtUtils.getUserId(token));
                String userName = JwtUtils.getUserName(token);
                String userNick = loginUser.getUser().getNickName();
                // 记录用户退出日志
                sysLoginService.logout(sourceName, enterpriseId, enterpriseName, userId, userName, userNick);
            }
        }
        return AjaxResult.success();
    }

    @PostMapping("refresh")
    public AjaxResult refresh(HttpServletRequest request) {
        tokenService.refreshToken(request);
        return AjaxResult.success();
    }

    @PostMapping("register")
    public AjaxResult register(@RequestBody RegisterBody registerBody) {
        // 用户注册
        sysLoginService.register(registerBody);
        return AjaxResult.success();
    }
}