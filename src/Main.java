package src;

import java.util.ArrayList;
import java.util.List;


class R {
    int A2;
    int A3;

    public R(int A2, int A3) {
        this.A2 = A2;
        this.A3 = A3;
    }

    // Need to have n # of attributes
}


class S {
    int B2;
    int B3;

    public S(int B2, int B3) {
        this.B2 = B2;
        this.B3 = B3;
    }

    // Need to have n # of attributes
}
public class Main {
    public static void main(String[] args) {

        List<R> tableR = new ArrayList<>();
        List<S> tableS = new ArrayList<>();

        // Populate table R with data
        tableR.add(new R(1, 2));
        tableR.add(new R(3, 4));
        tableR.add(new R(5, 6));

        // Populate table S with data
        tableS.add(new S(1, 2));
        tableS.add(new S(3, 4));
        tableS.add(new S(7, 8));

        // Perform the join operation
        for (R r : tableR) {
            for (S s : tableS) {
                if (r.A2 == s.B2 && r.A3 == s.B3) {
                    System.out.println("A2: " + r.A2 + ", A3: " + r.A3);
                }
            }
        }



    }
}