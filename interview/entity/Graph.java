package interview.entity;

/**
 * 예제로 사용할 공통 트리 노드
 */
public class Graph<E> {
    public Graph<E> left;
    public Graph<E> right;
    public int value;

    public Graph(int value) {
        this.value = value;
    }
}
