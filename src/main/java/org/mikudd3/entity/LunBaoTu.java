package org.mikudd3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project: 轮播图
 * @author: mikudd3
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LunBaoTu {

    private Integer id;
    private String url;
    private String title;
    private String color;
}
