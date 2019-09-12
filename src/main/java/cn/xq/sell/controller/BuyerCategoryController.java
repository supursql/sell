package cn.xq.sell.controller;

import cn.xq.sell.dataobject.ProductCategory;
import cn.xq.sell.exception.SellException;
import cn.xq.sell.form.CategoryForm;
import cn.xq.sell.form.ProductForm;
import cn.xq.sell.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author: 紫苏
 * @date: 19-9-11 下午1:19
 * @description:
 */
@Controller
@RequestMapping("/seller/category")
@Slf4j
public class BuyerCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = productCategoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory productCategory = productCategoryService.findOne(categoryId);
            map.put("category", productCategory);
        }

        return new ModelAndView("category/index");
    }

    @PostMapping(value = "/save", consumes = "application/x-www-form-urlencoded")
    public ModelAndView save(@Valid CategoryForm form, BindingResult bindingResult, Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();

        try {
            if (form.getCategoryId() != null) {
                productCategory = productCategoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, productCategory);

            productCategoryService.save(productCategory);
        } catch (SellException e) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }


        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);

    }

}
