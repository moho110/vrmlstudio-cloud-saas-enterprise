package com.vrmlstudio.system.authority.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.vrmlstudio.common.core.domain.R;
import com.vrmlstudio.common.security.annotation.InnerAuth;
import com.vrmlstudio.common.security.utils.SourceUtils;
import com.vrmlstudio.common.web.entity.controller.BasisController;
import com.vrmlstudio.system.api.authority.domain.dto.SysRoleDto;
import com.vrmlstudio.system.api.model.DataScope;
import com.vrmlstudio.system.api.model.LoginUser;
import com.vrmlstudio.system.api.organize.domain.dto.SysEnterpriseDto;
import com.vrmlstudio.system.api.organize.domain.dto.SysUserDto;
import com.vrmlstudio.system.api.source.domain.Source;
import com.vrmlstudio.system.authority.service.ISysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vrmlstudio.common.core.context.SecurityContextHolder;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 权限管理 业务处理
 *
 * @author vrmlstudio
 */
@RestController
@RequestMapping("/login")
public class SysLoginController extends BasisController {

    @Autowired
    ISysLoginService loginService;

    /**
     * 获取登录信息 | 内部调用
     */
    @InnerAuth
    @GetMapping("/inner/loginInfo/{enterpriseName}/{userName}/{password}")
    public R<LoginUser> getLoginInfo(@PathVariable("enterpriseName") String enterpriseName, @PathVariable("userName") String userName, @PathVariable("password") String password) {
        SysEnterpriseDto enterprise = loginService.loginByEnterpriseName(enterpriseName);
        // 不存在直接返回空数据 | 与网络调用错误区分
        if (ObjectUtil.isNull(enterprise))
            return R.ok(null, "企业账号不存在");
        SecurityContextHolder.setEnterpriseId(enterprise.getId().toString());
        SecurityContextHolder.setIsLessor(enterprise.getIsLessor());
        Source source = SourceUtils.getSourceCache(enterprise.getStrategyId());
        // 不存在直接返回空数据 | 与网络调用错误区分
        if (ObjectUtil.isNull(source))
            return R.ok(null, "数据源不存在");
        SecurityContextHolder.setSourceName(source.getMaster());
        SysUserDto user = loginService.loginByUser(userName, password);
        // 不存在直接返回空数据 | 与网络调用错误区分
        if (ObjectUtil.isNull(user))
            return R.ok(null, "用户账号不存在");
        SecurityContextHolder.setUserType(user.getUserType());
        // 角色权限标识
        Set<String> roles = loginService.getRolePermission(user.getRoles(), user.getUserType());
        // 角色Id集合
        Set<Long> roleIds = CollUtil.isNotEmpty(user.getRoles())
                ? user.getRoles().stream().map(SysRoleDto::getId).collect(Collectors.toSet())
                : new HashSet<>();

        // 菜单权限标识
        Set<String> permissions = loginService.getMenuPermission(roleIds, user.getUserType());

        // 权限范围
        DataScope dataScope = loginService.getDataScope(user.getRoles(), user);
        dataScope.setRoles(roles);
        dataScope.setRoleIds(roleIds);
        dataScope.setPermissions(permissions);

        // 路由路径集合
        Map<String, String> routeMap = loginService.getMenuRouteMap(roleIds, user.getUserType());
        LoginUser loginUser = new LoginUser();
        loginUser.setEnterprise(enterprise);
        loginUser.setEnterpriseId(enterprise.getId());
        loginUser.setEnterpriseName(enterprise.getName());
        loginUser.setIsLessor(enterprise.getIsLessor());
        loginUser.setSource(source);
        loginUser.setSourceName(source.getMaster());
        loginUser.setUser(user);
        loginUser.setUserId(user.getId());
        loginUser.setUserName(user.getUserName());
        loginUser.setUserType(user.getUserType());
        loginUser.setScope(dataScope);
        loginUser.setRouteURL(routeMap);
        return R.ok(loginUser);
    }
}
