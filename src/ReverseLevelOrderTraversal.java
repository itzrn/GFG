package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree of size N, find its reverse level order traversal. ie- the traversal must begin from the last level.
 *
 * Example 1:
 *
 * Input :
 *         1
 *       /   \
 *      3     2
 *
 * Output: 3 2 1
 * Explanation:
 * Traversing level 1 : 3 2
 * Traversing level 0 : 1
 * Example 2:
 *
 * Input :
 *        10
 *       /  \
 *      20   30
 *     / \
 *    40  60
 *
 * Output: 40 60 20 30 10
 * Explanation:
 * Traversing level 2 : 40 60
 * Traversing level 1 : 20 30
 * Traversing level 0 : 10
 *
 * Your Task:
 * You dont need to read input or print anything.
 * Complete the function reverseLevelOrder() which takes the root of the tree as input parameter and
 * returns a list containing the reverse level order traversal of the given tree.
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 *
 *
 * Constraints:
 * 1 ≤ N ≤ 10^4
 */

public class ReverseLevelOrderTraversal {
    public ArrayList<Integer> reverseLevelOrder(TreeNode root) {// there will always atleast one node in the tree, so in starting root will not null

        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while(queue.peek() != null){
            while(queue.peek() != null){

                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }

                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }

                list.add(0, queue.poll().data);
            }

            queue.poll(); // removing null
            queue.offer(null); // this is to identify the end of level
        }

        return list;
    }
}
