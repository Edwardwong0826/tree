package com.vantagefx;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void buildUserTree(Node<User> node) {
        /**
         * implement this method
         * build the tree data structure
         *
         */
    }

    public static void main(String[] args) {
        Map<Integer, User> userMap = SampleData.getUserData();
        //construct Node Tree of User
        Integer rootUserId = SampleData.getRelationMap().entrySet().stream()
                .filter(p -> null == p.getValue()).findAny().get().getKey();
        Node<User> root = new Node<>(userMap.get(rootUserId));
        root.setParent(null);
        buildUserTree(root);

        NodeHelper.printDecendants(root, "|--");
    }
}
