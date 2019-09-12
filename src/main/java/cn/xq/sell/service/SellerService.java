package cn.xq.sell.service;

import cn.xq.sell.dataobject.SellerInfo;

/**
 * @author: 紫苏
 * @date: 19-9-11 下午4:09
 * @description:
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenId(String openid);

}
