package com.vrmlstudio.common.security.interceptor;

import com.vrmlstudio.common.core.constant.basic.SecurityConstants;
import com.vrmlstudio.common.core.context.SecurityContextHolder;
import com.vrmlstudio.common.core.utils.ServletUtils;
import com.vrmlstudio.common.core.utils.StringUtils;
import com.vrmlstudio.common.security.auth.AuthUtil;
import com.vrmlstudio.common.security.utils.SecurityUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义请求头拦截器，将Header数据封装到线程变量中方便获取
 * 注意：此拦截器会同时验证当前用户有效期自动刷新有效期
 *
 * @author vrmlstudio
 */
public class HeaderInterceptor implements AsyncHandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        SecurityContextHolder.setEnterpriseId(ServletUtils.getHeader(request, SecurityConstants.ENTERPRISE_ID));
        SecurityContextHolder.setEnterpriseName(ServletUtils.getHeader(request, SecurityConstants.ENTERPRISE_NAME));
        SecurityContextHolder.setIsLessor(ServletUtils.getHeader(request, SecurityConstants.IS_LESSOR));
        SecurityContextHolder.setUserId(ServletUtils.getHeader(request, SecurityConstants.USER_ID));
        SecurityContextHolder.setUserName(ServletUtils.getHeader(request, SecurityConstants.USER_NAME));
        SecurityContextHolder.setNickName(ServletUtils.getHeader(request, SecurityConstants.NICK_NAME));
        SecurityContextHolder.setUserType(ServletUtils.getHeader(request, SecurityConstants.USER_TYPE));
        SecurityContextHolder.setSourceName(ServletUtils.getHeader(request, SecurityConstants.SOURCE_NAME));
        SecurityContextHolder.setUserKey(ServletUtils.getHeader(request, SecurityConstants.USER_KEY));

        String token = SecurityUtils.getToken();
        if (StringUtils.isNotEmpty(token)) {
            AuthUtil.verifyLoginUserExpire(token);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        SecurityContextHolder.remove();
    }
}