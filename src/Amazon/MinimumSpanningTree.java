package src.Amazon;

/**
 * Given a weighted, undirected and connected graph of V vertices and E edges.
 * The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
 * Given adjacency list adj as input parameters . Here adj[i] contains vectors of size 2,
 * where the first integer in that vector denotes the end of the edge and the second integer denotes the edge weight.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * 3 3
 * 0 1 5
 * 1 2 3
 * 0 2 1
 *
 * Output:
 * 4
 * Explanation:
 *
 * The Spanning Tree resulting in a weight
 * of 4 is shown above.
 * Example 2:
 *
 * Input:
 * 2 1
 * 0 1 5
 *
 * Output:
 * 5
 * Explanation:
 * Only one Spanning Tree is possible
 * which has a weight of 5.
 *
 *
 * Your task:
 * Since this is a functional problem you don't have to worry about input,
 * you just have to complete the function spanningTree() which takes a number of vertices V and an
 * adjacency list adj as input parameters and returns an integer denoting the sum of weights of the
 * edges of the Minimum Spanning Tree. Here adj[i] contains vectors of size 2, where the first integer in that vector
 * denotes the end of the edge and the second integer denotes the edge weight.
 *
 * Expected Time Complexity: O(ElogV).
 * Expected Auxiliary Space: O(V2).
 *
 *
 * Constraints:
 * 2 ≤ V ≤ 1000
 * V-1 ≤ E ≤ (V*(V-1))/2
 * 1 ≤ w ≤ 1000
 * The graph is connected and doesn't contain self-loops & multiple edges.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumSpanningTree {
    static int spanningTree(int V, int E, int[][] edges){
        // here arrayList contains the list of array, where each array contains 2 thins -> weight to visit the node and the node
        ArrayList<int[]>[] graph = new ArrayList[V];

        // building the graph
        for(int[] i:edges){
            if(graph[i[0]] == null){
                graph[i[0]] = new ArrayList<>();
            }

            if(graph[i[1]] == null){
                graph[i[1]] = new ArrayList<>();
            }
            // wt,   node
            graph[i[0]].add(new int[]{i[2], i[1]});
            graph[i[1]].add(new int[]{i[2], i[0]});
        }

        // used PriorityQueue just the pick the smallest weight node
        Queue<int[]> pq = new PriorityQueue<>((x, y)->(x[0]-y[0]));

        pq.offer(new int[]{0, 0}); // starting from node 0, so pushed the node '0' with its weight
        boolean[] visited = new boolean[V];
        int sum = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int wt = temp[0];
            int node = temp[1];

            if(visited[node]){
                continue;
            }

            visited[node] = true; // making th e node visited
            sum += wt;

            for(int[] i:graph[node]){
                int neighbour = i[1];
                int neighWt = i[0];
                if(!visited[neighbour]){ // pushing all the unvisited node to priority queue
                    pq.offer(new int[]{neighWt, neighbour});
                }
            }
        }

        return sum;
    }
}

