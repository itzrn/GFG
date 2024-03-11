package src.Microsoft;

/**
 * Given an adjacency list of a graph adj of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
 *
 * Know more about Bipartite Graph: - https://www.geeksforgeeks.org/what-is-bipartite-graph/
 *
 * Example 1:
 *
 * Input:
 *
 * Output: 1
 * Explanation: The given graph can be colored
 * in two colors so, it is a bipartite graph.
 * Example 2:
 *
 * Input:
 *
 * Output: 0
 * Explanation: The given graph cannot be colored
 * in two colors such that color of adjacent
 * vertices differs.
 *
 *
 * Your Task:
 * You don't need to read or print anything. Your task is to complete the function isBipartite()
 * which takes V denoting no. of vertices and adj denoting adjacency list of the graph and returns a
 * boolean value true if the graph is bipartite otherwise returns false.
 *
 *
 * Expected Time Complexity: O(V + E)
 * Expected Space Complexity: O(V)
 *
 * Constraints:
 * 1 ≤ V, E ≤ 105
 */

import java.util.ArrayList;

public class BipartiteGraph {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] color = new int[V];
        for(int i = 0;i<V; i++){ // this is used to check all the unconnected graph
            if(color[i] == 0){ // if it's not visited, then go for further recursion
                if(!recursion(i, adj, color, -1)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean recursion(int index, ArrayList<ArrayList<Integer>>adj, int[] color, int indexColor){ // using dfs, color array is working as visited array
        color[index] = indexColor;

        for(int i:adj.get(index)){
            if(color[index] == color[i]){// this condition check that node is already visited and of same color then as current node return false;
                return false;
            }

            if(color[i] == 0){ // if it is not colored
                color[i] = color[index] == -1?1:-1; // then color it
                if(!recursion(i, adj, color, color[i])){ // and go to explore the nodes connected to this new node
                    return false;
                }
            }
        }

        return true;
    }
}
