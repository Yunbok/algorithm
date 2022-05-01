package baekjoon;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[40];
        for (int i = 0; i < 40; i++) {
            arr[i] = (int)(Math.random() * 50);
            System.out.println(arr[i]);
        }

        int[] answerArr = countingSort(arr, 50);

        for (int i : answerArr) {
            System.out.print(i + " ");
        }
    }


    private static int[] countingSort(int[] arr, int range) {
        int[] countArr = new int[range + 1];
        int[] answerArr = new int[arr.length];

        for (int num : arr) {
            countArr[num]++;
        }

        for (int i = 0; i < range - 1; i++) {
            countArr[i + 1] = countArr[i] + countArr[i + 1];
        }

        for (int i = arr.length - 1; i >= 0; i-- ) {
            answerArr[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]]--;
        }
        return answerArr;
    }
}
