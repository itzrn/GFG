package src.FlipKart;
import java.util.ArrayList;

/**
 * Given an undirected graph with V vertices labelled from 0 to V-1 and E edges,
 * check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.
 *
 * Example 1:
 *
 * Input:
 * V = 5, E = 5
 * adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
 * Output: 1
 * Explanation:
 *
 * 1->2->3->4->1 is a cycle.
 * Example 2:
 *
 * Input:
 * V = 4, E = 2
 * adj = {{}, {2}, {1, 3}, {2}}
 * Output: 0
 * Explanation:
 *
 * No cycle in the graph.
 *
 *
 * Your Task:
 * You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting
 * the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected
 * graph contains any cycle or not, return 1 if a cycle is present else return 0.
 *
 * NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.
 *
 *
 *
 * Expected Time Complexity: O(V + E)
 * Expected Space Complexity: O(V)
 *
 *
 *
 *
 * Constraints:
 * 1 ≤ V, E ≤ 10^5
 */

/*
Here point is to remember that the algo contain parent and current node
 */

public class DetectCycleInAnUndirectedGraph {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for(int i = 0; i<V; i++){
            if(!visited[i] && recursion(i, adj, -1, visited)){ // this is to check all the graphs if in case there are non connected graphs
                return true;
            }
        }

        return false;
    }

    public static boolean recursion(int start, ArrayList<ArrayList<Integer>> adj, int parent, boolean[] visited){ // this is doing proper dfs
        visited[start] = true;
        for(int i:adj.get(start)){
            if(i == parent){ // when this condition is true, means need to skip bcz we can not go back in the path
                continue;
            }

            if(visited[i] || recursion(i, adj, start, visited)){ // this condition gets true means there is cycle
                return true;
            }
        }

        return false;
    }
}
