package com.vantagefx;

import java.util.*;

/**
 * Code challenge of VantageFX Java Developer
 * Please finish this task within 1.5 hours
 *  
 * This application requires printing a user relation tree structure based on
 * User - Basic Java Bean
 * Node - Node class of the tree
 * SampleData - Samples of user data and relation
 * NodeHelper - A helper class for Node
 * 
 * Supposing we manage users in this way:
 * 1. Every user has a unique ID (Integer)
 * 2. Every user has a parent user, except for root user
 * 3. Every user can have any number of child user(s)
 * 4. There is only one root user
 * 
 * Please implement 
 * 1. Application.buildUserTree(Node<User> node)
 * 2. NodeHelper.printDecendants(Node<T> node, String appender)
 * and the expected output should be:
 * 1
 *   |--2
 *     |--5
 *     |--6
 *       |--11
 *       |--12
 *     |--7
 *       |--13
 *   |--3
 *     |--8
 *       |--14
 *       |--15
 *         |--21
 *       |--16
 *         |--22
 *           |--23
 *             |--24
 *       |--17
 *       |--18
 *     |--9
 *   |--4
 *     |--10
 *       |--19
 *       |--20
 *
 */
public class Application {

    public static Map<Integer, User> userMap = SampleData.getUserData();
    public static Map<Integer, Integer> relationMap = SampleData.getRelationMap();

    public static void buildUserTree(Node<User> node) {
        /**
         * implement this method
         * build the tree data structure
         *
         */

        Tree<Integer, User> tree = new Tree<>(1, node.getData());

        Set<Integer> childID = userMap.keySet();
        Collection<Integer> parentID = relationMap.values();
        List<Integer> ChildID = new ArrayList<>(childID);
        List<Integer> ParentID = new ArrayList<>(parentID);

        int i = 0;

        for(Map.Entry<Integer,Integer> relationEntry : relationMap.entrySet())
        {
            tree.addChild(ParentID.get(i), ChildID.get(i), userMap.get(i+1) );
            i++;
        }

        System.out.println(tree.subtreeToString(1));
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
