package cn.xq.sell.controller;

import cn.xq.sell.dataobject.ProductCategory;
import cn.xq.sell.dataobject.ProductInfo;
import cn.xq.sell.service.ProductCategoryService;
import cn.xq.sell.service.ProductInfoService;
import cn.xq.sell.utils.ResultVOUtil;
import cn.xq.sell.vo.ProductInfoVO;
import cn.xq.sell.vo.ProductVO;
import cn.xq.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 紫苏
 * @date: 19-9-4 下午2:24
 * @description:
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO list() {

        //1. 查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2. 查询类目
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装

        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);

            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

}
