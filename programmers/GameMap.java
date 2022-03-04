package programmers;

import java.util.LinkedList;

public class GameMap {
    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
        int answer1 = gameMap
                .solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                        { 0, 0, 0, 0, 1 } });
        int answer2 = gameMap
                .solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1 } });
        System.out.println(answer1);
        System.out.println(answer2);
    }

    int width, height;
    // int[][] visited;
    int[][] maps;
    LinkedList<Node> queue;

    public int solution(int[][] maps) {
        this.maps = maps;
        width = maps[0].length; // 가로 길이
        height = maps.length; // 세로 길이
        int answer = 0;
        queue = new LinkedList<>();
        Node node = new Node();
        int[][] visited = new int[width][height];
        // 처음 위치
        node.x = node.y = 0;
        queue.add(node);
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Node next = queue.remove();
            if (visited[next.x][next.y] == 0) { // 방문 한 곳인지 확인
                // 방문 가능한 모든 경우의 수
                visit(next.x, next.y, next.x + 1, next.y, visited);
                visit(next.x, next.y, next.x, next.y + 1, visited);
                visit(next.x, next.y, next.x - 1, next.y, visited);
                visit(next.x, next.y, next.x, next.y - 1, visited);
            }
        }

        answer = visited[width - 1][height - 1];
        return answer == 0 ? -1 : answer;
    }

    // 방문 여부 확인
    public void visit(int x, int y, int addX, int addY, int[][] visited) {
        Node node = new Node();
        node.x = x + addX;
        node.y = y + addY;
        if (valid(node)) {
            visited[node.x][node.y] = visited[x][y] + 1;
            queue.add(node);
        }
    }

    // 유효 범위 확인
    public boolean valid(Node node) {
        boolean isValid = false;
        if (0 <= node.x && node.x < width // x 범위
                && 0 <= node.y && node.y < height // y범위
                && maps[node.x][node.y] == 1 // 갈 수 있는 위치인지 확인한다
        ) {
            isValid = true;
        }
        return isValid;
    }

    public class Node {
        int x;
        int y;
    }
}
