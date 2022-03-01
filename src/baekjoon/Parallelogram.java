package baekjoon;

import javax.swing.*;
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

        if((A[0]-B[0])*(A[1]-C[1])==(A[1]-B[1])*(A[0]-C[0])) {
            System.out.println(-1.0);
        } else {

            double AB = pythagoras(A,B);
            double AC = pythagoras(A,C);
            double BC = pythagoras(B,C);

            double maxVel = AB + AC + BC - Math.min(AB, Math.min(BC,AC));
            double minVel = AB + AC + BC - Math.max(AB, Math.max(BC,AC));
            System.out.println(2*maxVel - 2*minVel);

        }
    }

    public static double pythagoras(double[] a , double[] b) {
        return Math.sqrt(Math.pow(distance(a[0], b[0]),2) + Math.pow(distance(a[1], b[1]),2));
    }

    public static double distance(double a , double b) {
        double high = Math.max(a ,b);
        double low = Math.min(a,b);

        if ( high > 0 && low > 0 ) {
            return high - low;
        } else if ( high <= 0 && low <= 0) {
            return (high + low) * -1;
        } else {
            return high + (low * -1);
        }
    }
}
