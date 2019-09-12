package cn.xq.sell.service;

import cn.xq.sell.dataobject.ProductInfo;
import cn.xq.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: 紫苏
 * @date: 19-9-4 下午2:06
 * @description:
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有再仔架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);
}
