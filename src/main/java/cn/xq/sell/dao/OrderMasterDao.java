package cn.xq.sell.dao;

import cn.xq.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 紫苏
 * @date: 19-9-4 下午9:39
 * @description:
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
