package baekjoon;

import java.util.Scanner;

public class AgeSort {
    static User[] userArr;
    static User[] sortedArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userNum = sc.nextInt();
        userArr = new User[userNum];
        sortedArr = new User[userNum];
        for (int i = 0; i < userNum; i++) {
            userArr[i] = new User(sc.nextInt(), sc.next());
        }

//        bubbleSort(userArr);
//        insertionSort(userArr);
        mergeSort(userArr, 0, userNum - 1);

        for (User u : userArr) {
            System.out.println(u.toString());
        }

    }

    private static void bubbleSort(User[] userArr) {
        int length = userArr.length;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (userArr[j].getAge() > userArr[j + 1].getAge()) {
                    swap(userArr, j, j + 1);
                }
            }
        }

    }

    private static void insertionSort(User[] userArr) {
        int length = userArr.length;

        for (int i = 1; i < length; i++) {
            int sortTarget = userArr[i].getAge();
            int loopIndex = i;

            while (loopIndex >= 1 && sortTarget < userArr[loopIndex - 1].getAge()) {
                swap(userArr, loopIndex, loopIndex - 1);
                loopIndex--;
            }
        }
    }

    private static void mergeSort(User[] userArr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(userArr, left, mid);
            mergeSort(userArr, mid + 1, right);
            merge(userArr, left, right, mid);
        }
    }

    private static void merge(User[] userArr, int left, int right, int mid) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        //두 배열의 인덱스를 증가시키면서 확인
        while (l <= mid && r <= right) {

            //왼쪽 배열의 제일 작은값 보다 오른쪽배열의 제일 작은값이 크면
            if (userArr[l].getAge() <= userArr[r].getAge()) {
                sortedArr[idx++] = userArr[l++];
            } else {
                sortedArr[idx++] = userArr[r++];
            }
        }

        //왼쪽 배열에 있는 모든 수를 다 썼을때 남은배열을 담기
        if (l > mid) {
            while (r <= right) {
                sortedArr[idx++] = userArr[r++];
            }
        } else {
            while (l <= mid) {
                sortedArr[idx++] = userArr[l++];
            }
        }
        //정렬된 배열 넣기
        for (int i = left; i <= right; i++) {
            userArr[i] = sortedArr[i];
        }
    }

    private static void swap(User[] userArr, int x, int y) {
        User tempUser = userArr[x];
        userArr[x] = userArr[y];
        userArr[y] = tempUser;
    }
}
class User {

    private final int age;
    private final String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}
