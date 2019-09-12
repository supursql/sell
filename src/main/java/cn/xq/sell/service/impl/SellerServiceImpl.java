package cn.xq.sell.service.impl;

import cn.xq.sell.dao.SellerInfoDao;
import cn.xq.sell.dataobject.SellerInfo;
import cn.xq.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 紫苏
 * @date: 19-9-11 下午4:10
 * @description:
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;


    @Override
    public SellerInfo findSellerInfoByOpenId(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }
}
