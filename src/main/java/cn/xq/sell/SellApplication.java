package cn.xq.sell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SpringBootApplication
@RestController
@Slf4j
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }

    @GetMapping
    public String getWxUserInfo(HttpServletRequest request,
                                @RequestParam(required = false) String echostr,
                                @RequestParam(required = false) String signature,
                                @RequestParam(required = false) String timestamp,
                                @RequestParam(required =false) String nonce
    ) {
        try {
            //只需要把微信请求的 echostr, 返回给微信就可以了
            log.info("测试来过===================" + echostr);
            log.info("测试来过===================" + signature);
            log.info("测试来过===================" + timestamp);
            log.info("测试来过===================" + nonce);
            return echostr;
        } catch (Exception e) {
            log.info("测试微信公众号的接口配置信息发生异常：", e);
            return "错误！！！";
        }

    }

}
