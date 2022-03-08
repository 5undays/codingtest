package programmers;

import java.util.LinkedList;

public class GameMap {
    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
        int answer1 = gameMap
                .solution(new int[][] { { 1, 0, 1, 1, 1 }, 
                { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                        { 0, 0, 0, 0, 1 } });
        int answer2 = gameMap
                .solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1 } });
        System.out.println(answer1);
        System.out.println(answer2);
    }

    int width, height;
    int[][] visited;
    LinkedList<Node> queue;
    int[][] maps;

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int answer = 0;
        queue = new LinkedList<>();
        Node node = new Node();
        // 처음 위치
        node.x = node.y = 0;
        queue.add(node);
        
        width = maps[0].length; // 가로 길이
        height = maps.length; // 세로 길이
        this.maps = new int[width][height];
        visited = new int[width][height];
        visited[node.x][node.y] = 1;
        this.maps = maps;

        while (!queue.isEmpty()) {
            Node next = queue.remove();
            int cX = next.x;
            int cY = next.y;

            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                
                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                    continue;
                
                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    visited[nX][nY] = visited[cX][cY] + 1;
                    Node aa = new Node();
                    aa.x = nX;
                    aa.y = nY;
                    queue.add(aa);
                }
            }

            // 방문 가능한 모든 경우의 수
            // visit(next.x, next.y, next.x + 1, next.y);
            // visit(next.x, next.y, next.x, next.y + 1);
            // visit(next.x, next.y, next.x - 1, next.y);
            // visit(next.x, next.y, next.x, next.y - 1);
        }

        answer = visited[width - 1][height - 1];
        return answer == 0 ? -1 : answer;
    }

    // 방문 여부 확인
    public void visit(int x, int y, int addX, int addY) {
        System.out.println(x + "," + y + "," + addX + "," + addY);
        Node node = new Node();
        node.x = x + addX;
        node.y = y + addY;
        if (valid(node)) {
            //System.out.println("x : " + x + ", y : "+ y);
            System.out.println("node.x : " + node.x + ", node.y : "+ node.y);
            visited[node.x][node.y] = visited[x][y] + 1;
            queue.add(node);
        }
    }

    // 유효 범위 확인
    public boolean valid(Node node) {
        boolean isValid = false;
        if (0 <= node.x && node.x < width // x 범위
                && 0 <= node.y && node.y < height // y범위
                && visited[node.x][node.y] == 0 // 방문 한 장소인지 확인
                && maps[node.x][node.y] == 1// 갈 수 있는 위치인지 확인한다
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
