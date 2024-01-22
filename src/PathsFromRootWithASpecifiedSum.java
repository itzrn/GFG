package src;

/**
 * Given a Binary tree and a sum S, print all the paths, starting from root, that sums upto the given sum. Path not necessarily end on a leaf node.
 *
 * Example 1:
 *
 * Input :
 * sum = 8
 * Input tree
 *          1
 *        /   \
 *      20      3
 *            /    \
 *          4       15
 *         /  \     /  \
 *        6    7   8    9
 *
 * Output :
 * 1 3 4
 * Explanation :
 * Sum of path 1, 3, 4 = 8.
 * Example 2:
 *
 * Input :
 * sum = 38
 * Input tree
 *           10
 *        /     \
 *      28       13
 *            /     \
 *          14       15
 *         /   \     /  \
 *        21   22   23   24
 * Output :
 * 10 28
 * 10 13 15
 * Explanation :
 * Sum of path 10, 28 = 38 and
 * Sum of path 10, 13, 15 = 38.
 * Your task :
 * You don't have to read input or print anything. Your task is to complete the function printPaths() that takes the
 * root of the tree and sum as input and returns a vector of vectors containing the paths that lead to the sum.
 *
 * Expected Time Complexity: O(N)
 * Expected Space Complexity: O(N2)
 *
 * Your Task :
 * 1 <= N <= 2*10^3
 * -103 <= sum, Node.key <= 10^3
 */

import java.util.ArrayList;

public class PathsFromRootWithASpecifiedSum {
    public ArrayList<ArrayList<Integer>> printPaths(TreeNode root, int sum){
        recursion(root, 0, sum);
        return ans;
    }

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public void recursion(TreeNode root, int pSum, int tSum){
        if(root == null){
            return;
        }

        list.add(root.data);
        pSum += root.data;

        if(pSum == tSum){
            ans.add(new ArrayList<>(list));
        }

        recursion(root.left, pSum, tSum);
        recursion(root.right, pSum, tSum);
        list.remove(list.size()-1);
    }
}
