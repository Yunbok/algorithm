package baekjoon;

import java.util.Scanner;

public class Parallelogram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] A = new double[2];
        double[] B = new double[2];
        double[] C = new double[2];

        A[0] = sc.nextDouble();
        A[1] = sc.nextDouble();
        B[0] = sc.nextDouble();
        B[1] = sc.nextDouble();
        C[0] = sc.nextDouble();
        C[1] = sc.nextDouble();

        if ( A[0] - B[0] == 0 && A[0] - C[0] == 0 || A[1] - B[1] == 0 && A[1] - C[1] == 0 ) {
            System.out.println(-1.0);
        } else if((A[0]-B[0])*(A[1]-C[1])==(A[1]-B[1])*(A[0]-C[0])) {
            System.out.println(-1.0);
        } else {

            double AB = pythagoras(A,B);
            double AC = pythagoras(A,C);
            double BC = pythagoras(B,C);

            double maxVel = AB + AC + BC - Math.min(AB, Math.min(BC,AC));
            double minVel = AB + AC + BC - Math.max(AB, Math.max(BC,AC));
            System.out.println(2*(maxVel - minVel));

        }
    }

    public static double pythagoras(double[] a , double[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0],2) + Math.pow(a[1] - b[1],2));
    }
}
