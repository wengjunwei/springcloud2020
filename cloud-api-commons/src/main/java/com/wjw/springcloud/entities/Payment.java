package com.wjw.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2020/12/25 0025
 *
 * @author weng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
