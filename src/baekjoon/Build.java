package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Build {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Body> personList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            personList.add(new Body(sc.nextInt(), sc.nextInt()));
        }

        for ( int i = 0; i < personList.size(); i++) {
            for ( int j = 0; j < personList.size(); j++){
                if ( i == j ) {
                    continue;
                }
                if(personList.get(i).compareTo(personList.get(j))){
                    personList.get(i).rankUp();
                }
            }
            sb.append(personList.get(i).getRank() + " ") ;
        }
        System.out.println(sb);
    }
}


class Body {
    private int weight;
    private int height;
    private int rank;

    Body(int weight, int height) {
        this.weight = weight;
        this.height = height;
        this.rank = 1;
    }

    public void rankUp() {
        this.rank++;
    }

    public String getRank() {
        return Integer.toString(rank);
    }

    public boolean compareTo(Body o) {
        if (this.weight < o.weight && this.height < o.height) {
            return true;
        } else {
            return false;
        }
    }
}
