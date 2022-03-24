package interview;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */
public class BFSExample {

    private static class Graph {
        private int size;
        private LinkedList<Integer> adj[];

        private Graph(int size) {
            this.size = size;
            adj = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        private void addEdge(int startIdx, int endIdx) {
            adj[startIdx].add(endIdx);
        }

        private void BFS(int start) {
            boolean[] visited = new boolean[size];
            LinkedList<Integer> queue = new LinkedList<>();
            // 시작점을 수동으로 넣어줌
            visited[start] = true;
            queue.add(start);
            while (queue.size() > 0) {
                start = queue.poll();
                System.out.println(start);
                // start에서 접근 가능한 리스트를 가져온다
                Iterator<Integer> i = adj[start].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    // 방문하지 않은 곳을 방문 표시한 후 다음에 접근한다
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.BFS(2);
    }

}
