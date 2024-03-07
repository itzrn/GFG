package src.Amazon;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumIndex {
    static int maxIndexDiff(int[] a, int n) {
        Queue<int[]> queue = new PriorityQueue<>((x, y) -> y[0]-x[0]);
        for(int i=0; i<n; i++){
            queue.offer(new int[]{a[i], i});
        }


        int max = 0;
        for(int i=0; i<n && !queue.isEmpty(); i++){
            while(!queue.isEmpty() && a[i] <= queue.peek()[0]){
                max = Math.max(max, queue.poll()[1]-i);
            }
        }

        return max;
    }
}
