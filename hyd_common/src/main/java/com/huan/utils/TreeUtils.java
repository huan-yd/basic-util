package com.huan.utils;

import com.huan.dto.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author YueDong Huan
 * @Date 2021/5/26
 * @Email huanyued@163.com
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
