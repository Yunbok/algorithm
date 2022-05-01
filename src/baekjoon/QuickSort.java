package baekjoon;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[40];
        for (int i = 0; i < 40; i++) {
            arr[i] = (int)(Math.random() * 50);
            System.out.println(arr[i]);
        }
//        int[] answerArr -;
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] arr, int lo, int hi) {
    /*
        1. 피벗을 하나 선택한다.

        2. 피벗을 기준으로 양쪽에서 피벗보다 큰 값, 혹은 작은 값을 찾는다. 왼쪽에서부터는 피벗보다 큰 값을 찾고, 오른쪽에서부터는 피벗보다 작은 값을 찾는다.

        3. 양 방향에서 찾은 두 원소를 교환한다.

        4. 왼쪽에서 탐색하는 위치와 오른쪽에서 탐색하는 위치가 엇갈리지 않을 때 까지 2번으로 돌아가 위 과정을 반복한다.

        5. 엇갈린 기점을 기준으로 두 개의 부분리스트로 나누어 1번으로 돌아가 해당 부분리스트의 길이가 1이 아닐 때 까지 1번 과정을 반복한다. (Divide : 분할)

        6. 인접한 부분리스트끼리 합친다. (Conqure : 정복)
    */

        if (lo >= hi) {
            return;
        }
        int pivot = partition(arr, lo, hi);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        quickSort(arr, lo, pivot - 1);
        quickSort(arr,pivot + 1, hi);

    }

    private static int partition(int[] arr, int left, int right) {

        int lo = left;
        int hi = right;
        int pivot = arr[left];

        while (lo < hi) {
            // hi가 lo 보다 크면서 pivot 보다 작거나 같은 원소를 찾을때까지 감소
            while (arr[hi] > pivot && lo < hi) {
                hi--;
            }

            while (arr[lo] <= pivot && lo < hi) {
                lo++;
            }

            swap(arr, lo, hi);
        }

        swap(arr, left, lo);

        return lo;
    }

    private static void swap(int[] arr, int x, int y) {
        int tempNum = arr[x];
        arr[x] = arr[y];
        arr[y] = tempNum;
    }
}
