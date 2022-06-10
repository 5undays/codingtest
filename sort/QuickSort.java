package sort;

// https://www.geeksforgeeks.org/quick-sort/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        printArray(arr, n);
    }

    /**
     * 퀵 정렬
     * 
     * @param arr  정렬하고자 하는 배열
     * @param low  시작 인덱스
     * @param high 종료 인덱스
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗 인덱스
            int pivot = partition(arr, low, high);
            // 피벗 값 이전 정렬
            quickSort(arr, low, pivot - 1);
            // 피벗 값 이후 정렬
            quickSort(arr, pivot + 1, high);
        }
    }

    /**
     * 두 값의 교환
     * 
     * @param arr 교환할 배열
     * @param i   교환할 배열 인덱스 1
     * @param j   교환할 배열 인덱스 2
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 피벗 값
     * 
     * @param arr  배열
     * @param low 시작 인덱스
     * @param high 종료 인덱스
     * @return 피벗 인덱스
     */
    static int partition(int[] arr, int low, int high) {
        // 피벗 값
        int pivot = arr[high];
        int index = low - 1;
        for (int j = low; j <= high - 1; j++) {
            // 피벗 값보다 작을 경우 인덱스 값과 바꿔준다
            if (arr[j] < pivot) {
                index++;
                swap(arr, index, j);
            }
        }
        swap(arr, index + 1, high);
        return index + 1;
    }

    /**
     * 배열 출력
     * 
     * @param arr  출력할 배열
     * @param size 사이즈
     */
    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
