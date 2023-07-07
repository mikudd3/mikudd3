package org.mikudd3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project: 商品
 * @author: mikudd3
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    //主键
    private Integer id;
    //商品名字
    private String name;
    //价格
    private Double price;
    private Double currentPrice;
    //图片
    private String image;
    //商品描述
    private String description;
    //库存id
    private Integer stockId;
    //类别id
    private Integer categoryId;
    //状态
    private Integer status;
    //库存数量
    private Integer number;
    //卖出数量
    private Long total;
}
