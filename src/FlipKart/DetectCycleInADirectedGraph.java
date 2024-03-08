package src.FlipKart;

import java.util.ArrayList;

/**
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
 *
 *
 * Example 1:
 *
 * Input:
 *
 *
 *
 * Output: 1
 * Explanation: 3 -> 3 is a cycle
 *
 * Example 2:
 *
 * Input:
 *
 *
 * Output: 0
 * Explanation: no cycle in the graph
 *
 * Your task:
 * You dont need to read input or print anything. Your task is to complete the function isCyclic()
 * which takes the integer V denoting the number of vertices and adjacency list adj as input parameters and
 * returns a boolean value denoting if the given directed graph contains a cycle or not.
 * In the adjacency list adj, element adj[i][j] represents an edge from i to j.
 *
 *
 * Expected Time Complexity: O(V + E)
 * Expected Auxiliary Space: O(V)
 *
 *
 * Constraints:
 * 1 ≤ V, E ≤ 10^5
 */

public class DetectCycleInADirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i] && recursion(i, adj, visited, new boolean[V])){ // this is to check all the graphs if in case there are non connected graphs
                return true;
            }
        }

        return false;
    }

    public static boolean recursion(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] inRecursion){ // this is proper dfs

        // inRecursion is used to check the traversed path is the path where we already visited
        inRecursion[start] = true;
        visited[start] = true;

        for(int i:adj.get(start)){
            if(!visited[i] && recursion(i, adj, visited, inRecursion) || inRecursion[i]){
                return true;
            }
        }

        inRecursion[start] = false;
        return false;
    }
}
