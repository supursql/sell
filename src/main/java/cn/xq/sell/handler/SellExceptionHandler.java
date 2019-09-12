package cn.xq.sell.handler;

import cn.xq.sell.exception.SellException;
import cn.xq.sell.exception.SellerAuthorizeException;
import cn.xq.sell.utils.ResultVOUtil;
import cn.xq.sell.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: 紫苏
 * @date: 19-9-11 下午11:01
 * @description:
 */
@ControllerAdvice
public class SellExceptionHandler {

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"+ "http://127.0.0.1:8080/sell/wechat/qrAuthorize?returnUrl=http://127.0.0.1:8080/sell/seller/login");
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

}
