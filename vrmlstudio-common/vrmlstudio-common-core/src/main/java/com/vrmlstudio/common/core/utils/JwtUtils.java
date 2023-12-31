package com.vrmlstudio.common.core.utils;

import com.vrmlstudio.common.core.constant.basic.SecurityConstants;
import com.vrmlstudio.common.core.constant.basic.TokenConstants;
import com.vrmlstudio.common.core.text.Convert;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;

/**
 * Jwt工具类
 *
 * @author vrmlstudio
 */
public class JwtUtils {
    public static String secret = TokenConstants.SECRET;

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public static Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    public static String createToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 根据令牌获取企业Id
     *
     * @param token 令牌
     * @return 企业Id
     */
    public static String getEnterpriseId(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstants.ENTERPRISE_ID);
    }

    /**
     * 根据身份信息获取企业Id
     *
     * @param claims 身份信息
     * @return 企业Id
     */
    public static String getEnterpriseId(Claims claims) {
        return getValue(claims, SecurityConstants.ENTERPRISE_ID);
    }

    /**
     * 根据令牌获取企业账号
     *
     * @param token 令牌
     * @return 企业账号
     */
    public static String getEnterpriseName(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstants.ENTERPRISE_NAME);
    }

    /**
     * 根据身份信息获取企业账号
     *
     * @param claims 身份信息
     * @return 企业账号
     */
    public static String getEnterpriseName(Claims claims) {
        return getValue(claims, SecurityConstants.ENTERPRISE_NAME);
    }

    /**
     * 根据令牌获取企业类型
     *
     * @param token 令牌
     * @return 企业类型
     */
    public static String getIsLessor(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstants.IS_LESSOR);
    }

    /**
     * 根据身份信息获取企业类型
     *
     * @param claims 身份信息
     * @return 企业类型
     */
    public static String getIsLessor(Claims claims) {
        return getValue(claims, SecurityConstants.IS_LESSOR);
    }

    /**
     * 根据令牌获取用户Id
     *
     * @param token 令牌
     * @return 用户Id
     */
    public static String getUserId(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstants.USER_ID);
    }

    /**
     * 根据身份信息获取用户Id
     *
     * @param claims 身份信息
     * @return 用户Id
     */
    public static String getUserId(Claims claims) {
        return getValue(claims, SecurityConstants.USER_ID);
    }

    /**
     * 根据令牌获取用户账号
     *
     * @param token 令牌
     * @return 用户账号
     */
    public static String getUserName(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstants.USER_NAME);
    }

    /**
     * 根据身份信息获取用户账号
     *
     * @param claims 身份信息
     * @return 用户账号
     */
    public static String getUserName(Claims claims) {
        return getValue(claims, SecurityConstants.USER_NAME);
    }

    /**
     * 根据令牌获取用户类型
     *
     * @param token 令牌
     * @return 用户类型
     */
    public static String getUserType(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstants.USER_TYPE);
    }

    /**
     * 根据身份信息获取用户类型
     *
     * @param claims 身份信息
     * @return 用户类型
     */
    public static String getUserType(Claims claims) {
        return getValue(claims, SecurityConstants.USER_TYPE);
    }

    /**
     * 根据令牌获取租户策略源
     *
     * @param token 令牌
     * @return 租户策略源
     */
    public static String getSourceName(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstants.SOURCE_NAME);
    }

    /**
     * 根据令牌获取租户策略源
     *
     * @param claims 身份信息
     * @return 租户策略源
     */
    public static String getSourceName(Claims claims) {
        return getValue(claims, SecurityConstants.SOURCE_NAME);
    }

    /**
     * 根据令牌获取用户标识
     *
     * @param token 令牌
     * @return 用户Id
     */
    public static String getUserKey(String token) {
        Claims claims = parseToken(token);
        return getValue(claims, SecurityConstants.USER_KEY);
    }

    /**
     * 根据令牌获取用户标识
     *
     * @param claims 身份信息
     * @return 用户Id
     */
    public static String getUserKey(Claims claims) {
        return getValue(claims, SecurityConstants.USER_KEY);
    }

    /**
     * 根据身份信息获取键值
     *
     * @param claims 身份信息
     * @param key    键
     * @return 值
     */
    public static String getValue(Claims claims, String key) {
        return Convert.toStr(claims.get(key), "");
    }
}
