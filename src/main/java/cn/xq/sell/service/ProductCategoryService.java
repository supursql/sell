package cn.xq.sell.service;

import cn.xq.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author: 紫苏
 * @date: 19-9-4 下午1:30
 * @description:
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
