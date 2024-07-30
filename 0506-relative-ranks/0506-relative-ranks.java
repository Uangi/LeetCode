import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        
        // 우선순위 큐를 사용하여 점수를 내림차순으로 정렬
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        // 점수와 인덱스를 큐에 삽입
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[]{score[i], i});
        }
        
        // 순위 매핑
        for (int rank = 0; rank < n; rank++) {
            int[] pair = maxHeap.poll();
            int index = pair[1];
            if (rank == 0) {
                result[index] = "Gold Medal";
            } else if (rank == 1) {
                result[index] = "Silver Medal";
            } else if (rank == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank + 1);
            }
        }
        return result;
    }
}
