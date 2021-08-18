package com.huan.utils;

import com.huan.dto.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 树结构工具类
 * @author YueDong Huan
 * @date 2021/8/18 14:52
 * @version 1.0
 */
public class TreeUtils {

    public static <T extends TreeNode> List<T> build(List<T> treeNodes) {

        List<T> result = new ArrayList<>();
        Map<String, T> map = new HashMap<>(treeNodes.size());

        for (T treeNode : treeNodes) {
            map.put(treeNode.getId(), treeNode);
        }

        for (T node : map.values()) {
            T parent = map.get(node.getParentId());
            if (parent != null && !node.getId().equals(parent.getId())) {
                parent.getChildren().add(node);
                continue;
            }
            result.add(node);
        }
        return result;
    }

}
