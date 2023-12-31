package com.vrmlstudio.common.security.auth;

import com.vrmlstudio.common.core.exception.auth.NotLoginException;
import com.vrmlstudio.common.core.exception.auth.NotPermissionException;
import com.vrmlstudio.common.core.exception.auth.NotRoleException;
import com.vrmlstudio.common.security.utils.SecurityUtils;
import com.vrmlstudio.common.core.utils.SpringUtils;
import com.vrmlstudio.common.core.utils.StringUtils;
import com.vrmlstudio.common.security.annotation.Logical;
import com.vrmlstudio.common.security.annotation.RequiresLogin;
import com.vrmlstudio.common.security.annotation.RequiresPermissions;
import com.vrmlstudio.common.security.annotation.RequiresRoles;
import com.vrmlstudio.common.security.service.TokenService;
import com.vrmlstudio.system.api.model.DataScope;
import com.vrmlstudio.system.api.model.LoginUser;
import org.springframework.util.PatternMatchUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Token 权限验证，逻辑实现类
 *
 * @author vrmlstudio
 */
public class AuthLogic {

    /**
     * 所有权限标识
     */
    private static final String ALL_PERMISSION = "*:*:*";

    /**
     * 管理员角色权限标识
     */
    private static final String SUPER_ADMIN = "admin";

    public TokenService tokenService = SpringUtils.getBean(TokenService.class);

    /**
     * 会话注销
     */
    public void logout() {
        String token = SecurityUtils.getToken();
        if (token == null) {
            return;
        }
        logoutByToken(token);
    }

    /**
     * 会话注销，根据指定Token
     */
    public void logoutByToken(String token) {
        tokenService.delLogin(token);
    }

    /**
     * 检验用户是否已经登录，如未登录，则抛出异常
     */
    public void checkLogin() {
        getLoginUser();
    }

    /**
     * 获取当前用户缓存信息, 如果未登录，则抛出异常
     *
     * @return 用户缓存信息
     */
    public LoginUser getLoginUser() {
        String token = SecurityUtils.getToken();
        if (token == null)
            throw new NotLoginException("未提供token");
        LoginUser loginUser = SecurityUtils.getLoginUser();
        ;
        if (loginUser == null)
            throw new NotLoginException("无效的token");
        return loginUser;
    }

    /**
     * 获取当前用户权限范围缓存信息, 如果未登录，则抛出异常
     *
     * @return 用户权限范围缓存信息
     */
    public DataScope getDataScope() {
        String token = SecurityUtils.getToken();
        if (token == null)
            throw new NotLoginException("未提供token");
        DataScope dataScope = SecurityUtils.getDataScope();
        if (dataScope == null) {
            throw new NotLoginException("无效的token");
        }
        return dataScope;
    }

    /**
     * 获取当前用户缓存信息, 如果未登录，则抛出异常
     *
     * @param token 前端传递的认证信息
     * @return 用户缓存信息
     */
    public LoginUser getLoginUser(String token) {
        return tokenService.getLoginUser(token);
    }

    /**
     * 验证当前用户有效期, 如果相差不足360分钟，自动刷新缓存
     *
     * @param token token
     */
    public void verifyLoginUserExpire(String token) {
        tokenService.verifyToken(token);
    }

    /**
     * 验证用户是否具备某权限
     *
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPerm(String permission) {
        return hasPerm(getPermList(), permission);
    }

    /**
     * 验证用户是否具备某权限, 如果验证未通过，则抛出异常: NotPermissionException
     *
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public void checkPerm(String permission) {
        if (!hasPerm(getPermList(), permission)) {
            throw new NotPermissionException(permission);
        }
    }

    /**
     * 根据注解(@RequiresPermissions)鉴权, 如果验证未通过，则抛出异常: NotPermissionException
     *
     * @param requiresPermissions 注解对象
     */
    public void checkPerm(RequiresPermissions requiresPermissions) {
        if (requiresPermissions.logical() == Logical.AND) {
            checkPermAnd(requiresPermissions.value());
        } else {
            checkPermOr(requiresPermissions.value());
        }
    }

    /**
     * 验证用户是否含有指定权限，必须全部拥有
     *
     * @param permissions 权限列表
     */
    public void checkPermAnd(String... permissions) {
        Set<String> permissionList = getPermList();
        for (String permission : permissions) {
            if (!hasPerm(permissionList, permission)) {
                throw new NotPermissionException(permission);
            }
        }
    }

    /**
     * 验证用户是否含有指定权限，只需包含其中一个
     *
     * @param permissions 权限码数组
     */
    public void checkPermOr(String... permissions) {
        Set<String> permissionList = getPermList();
        for (String permission : permissions) {
            if (hasPerm(permissionList, permission)) {
                return;
            }
        }
        if (permissions.length > 0) {
            throw new NotPermissionException(permissions);
        }
    }

    /**
     * 判断用户是否拥有某个角色
     *
     * @param role 角色标识
     * @return 用户是否具备某角色
     */
    public boolean hasRole(String role) {
        return hasRole(getRoleList(), role);
    }

    /**
     * 判断用户是否拥有某个角色, 如果验证未通过，则抛出异常: NotRoleException
     *
     * @param role 角色标识
     */
    public void checkRole(String role) {
        if (!hasRole(role)) {
            throw new NotRoleException(role);
        }
    }

    /**
     * 根据注解(@RequiresRoles)鉴权
     *
     * @param requiresRoles 注解对象
     */
    public void checkRole(RequiresRoles requiresRoles) {
        if (requiresRoles.logical() == Logical.AND) {
            checkRoleAnd(requiresRoles.value());
        } else {
            checkRoleOr(requiresRoles.value());
        }
    }

    /**
     * 验证用户是否含有指定角色，必须全部拥有
     *
     * @param roles 角色标识数组
     */
    public void checkRoleAnd(String... roles) {
        Set<String> roleList = getRoleList();
        for (String role : roles) {
            if (!hasRole(roleList, role)) {
                throw new NotRoleException(role);
            }
        }
    }

    /**
     * 验证用户是否含有指定角色，只需包含其中一个
     *
     * @param roles 角色标识数组
     */
    public void checkRoleOr(String... roles) {
        Set<String> roleList = getRoleList();
        for (String role : roles) {
            if (hasRole(roleList, role)) {
                return;
            }
        }
        if (roles.length > 0) {
            throw new NotRoleException(roles);
        }
    }

    /**
     * 根据注解(@RequiresLogin)鉴权
     *
     * @param at 注解对象
     */
    public void checkByAnnotation(RequiresLogin at) {
        this.checkLogin();
    }

    /**
     * 根据注解(@RequiresRoles)鉴权
     *
     * @param at 注解对象
     */
    public void checkByAnnotation(RequiresRoles at) {
        String[] roleArray = at.value();
        if (at.logical() == Logical.AND) {
            this.checkRoleAnd(roleArray);
        } else {
            this.checkRoleOr(roleArray);
        }
    }

    /**
     * 根据注解(@RequiresPermissions)鉴权
     *
     * @param at 注解对象
     */
    public void checkByAnnotation(RequiresPermissions at) {
        String[] permissionArray = at.value();
        if (at.logical() == Logical.AND) {
            this.checkPermAnd(permissionArray);
        } else {
            this.checkPermOr(permissionArray);
        }
    }

    /**
     * 获取当前账号的角色列表
     *
     * @return 角色列表
     */
    public Set<String> getRoleList() {
        try {
            DataScope dataScope = getDataScope();
            return dataScope.getRoles();
        } catch (Exception e) {
            return new HashSet<>();
        }
    }

    /**
     * 获取当前账号的权限列表
     *
     * @return 权限列表
     */
    public Set<String> getPermList() {
        try {
            DataScope dataScope = getDataScope();
            return dataScope.getPermissions();
        } catch (Exception e) {
            return new HashSet<>();
        }
    }

    /**
     * 判断是否包含权限
     *
     * @param authorities 权限列表
     * @param permission  权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPerm(Collection<String> authorities, String permission) {
        return authorities.stream().filter(StringUtils::hasText)
                .anyMatch(x -> ALL_PERMISSION.contains(x) || PatternMatchUtils.simpleMatch(x, permission));
    }

    /**
     * 判断是否包含角色
     *
     * @param roles 角色列表
     * @param role  角色
     * @return 用户是否具备某角色权限
     */
    public boolean hasRole(Collection<String> roles, String role) {
        return roles.stream().filter(StringUtils::hasText)
                .anyMatch(x -> SUPER_ADMIN.contains(x) || PatternMatchUtils.simpleMatch(x, role));
    }
}
