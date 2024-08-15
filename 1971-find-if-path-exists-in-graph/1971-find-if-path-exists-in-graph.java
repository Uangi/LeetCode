import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
     List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(source);
        visited[source] = true;
        
        // BFS 수행
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == destination) {
                return true;
            }
            
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        
        return false;
    }
}