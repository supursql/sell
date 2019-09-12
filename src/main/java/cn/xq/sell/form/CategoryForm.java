package cn.xq.sell.form;

import lombok.Data;

/**
 * @author: 紫苏
 * @date: 19-9-11 下午3:37
 * @description:
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

}
