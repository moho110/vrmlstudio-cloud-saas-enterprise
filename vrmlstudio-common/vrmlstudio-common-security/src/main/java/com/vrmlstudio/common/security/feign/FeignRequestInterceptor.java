package com.vrmlstudio.common.security.feign;

import cn.hutool.core.util.StrUtil;
import com.vrmlstudio.common.core.constant.basic.SecurityConstants;
import com.vrmlstudio.common.core.utils.ServletUtils;
import com.vrmlstudio.common.core.utils.StringUtils;
import com.vrmlstudio.common.core.utils.ip.IpUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * feign 请求拦截器
 *
 * @author vrmlstudio
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest httpServletRequest = ServletUtils.getRequest();
        if (StringUtils.isNotNull(httpServletRequest)) {
            Map<String, String> headers = ServletUtils.getHeaders(httpServletRequest);
            // 传递用户信息请求头，防止丢失
            String enterpriseId = headers.get(SecurityConstants.ENTERPRISE_ID);
            if (StrUtil.isNotBlank(enterpriseId))
                requestTemplate.header(SecurityConstants.ENTERPRISE_ID, enterpriseId);
            String enterpriseName = headers.get(SecurityConstants.ENTERPRISE_NAME);
            if (StrUtil.isNotBlank(enterpriseName))
                requestTemplate.header(SecurityConstants.ENTERPRISE_NAME, enterpriseName);
            String isLessor = headers.get(SecurityConstants.IS_LESSOR);
            if (StrUtil.isNotBlank(isLessor))
                requestTemplate.header(SecurityConstants.IS_LESSOR, isLessor);
            String userId = headers.get(SecurityConstants.USER_ID);
            if (StrUtil.isNotBlank(userId))
                requestTemplate.header(SecurityConstants.USER_ID, userId);
            String userName = headers.get(SecurityConstants.USER_NAME);
            if (StrUtil.isNotBlank(userName))
                requestTemplate.header(SecurityConstants.USER_NAME, userName);
            String nickName = headers.get(SecurityConstants.NICK_NAME);
            if (StrUtil.isNotBlank(nickName))
                requestTemplate.header(SecurityConstants.NICK_NAME, nickName);
            String userType = headers.get(SecurityConstants.USER_TYPE);
            if (StrUtil.isNotBlank(userType))
                requestTemplate.header(SecurityConstants.USER_TYPE, userType);
            String userKey = headers.get(SecurityConstants.USER_KEY);
            if (StringUtils.isNotEmpty(userKey))
                requestTemplate.header(SecurityConstants.USER_KEY, userKey);
            String sourceName = headers.get(SecurityConstants.SOURCE_NAME);
            if (StrUtil.isNotBlank(sourceName))
                requestTemplate.header(SecurityConstants.SOURCE_NAME, sourceName);
            String authentication = headers.get(SecurityConstants.AUTHORIZATION_HEADER);
            if (StrUtil.isNotBlank(authentication))
                requestTemplate.header(SecurityConstants.AUTHORIZATION_HEADER, authentication);
            // 配置客户端IP
            requestTemplate.header("X-Forwarded-For", IpUtils.getIpAddr(ServletUtils.getRequest()));
        }
    }
}