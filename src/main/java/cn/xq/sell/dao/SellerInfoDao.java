package cn.xq.sell.dao;

import cn.xq.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 紫苏
 * @date: 19-9-11 下午3:58
 * @description:
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);

}
