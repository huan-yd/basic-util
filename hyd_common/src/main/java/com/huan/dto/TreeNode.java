package com.huan.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author YueDong Huan
 * @Date 2021/5/26
 * @Email huanyued@163.com
 */
@Data
public class TreeNode<T> {

    private String id;

    private String parentId;

    private List<T> children;

}
