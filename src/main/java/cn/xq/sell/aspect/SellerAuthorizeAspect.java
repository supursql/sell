package cn.xq.sell.aspect;

import cn.xq.sell.constant.CookieConstant;
import cn.xq.sell.constant.RedisConstant;
import cn.xq.sell.exception.SellException;
import cn.xq.sell.exception.SellerAuthorizeException;
import cn.xq.sell.utils.CookieUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: 紫苏
 * @date: 19-9-11 下午10:44
 * @description:
 */
@Aspect
@Component
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * cn.xq.sell.controller.Seller*.*(..))" +
            "&& !execution(public * cn.xq.sell.controller.Seller*.*(..))")
    public void verify() {}

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        //查询Cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        if (cookie == null) {
            throw new SellerAuthorizeException();
        }

        String tokenValue = redisTemplate.opsForValue().get(new StringBuffer(RedisConstant.TOKEN_PREFIX).append(cookie.getValue()).toString());
        if (StringUtils.isEmpty(tokenValue)) {
            throw new SellerAuthorizeException();
        }
    }

}
