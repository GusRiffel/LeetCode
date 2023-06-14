package com.GusRiffel.recursion;

import java.util.ArrayList;
import java.util.List;

public class Collatz {
    public static void main(String[] args) {
        System.out.println(useCollatz(3));
        System.out.println(collatz(3));
    }

    public static int collatz(int n) {
        if (n == 1) {
            return 0;
        }
        else if ( (n % 2) == 0) {
            return 1 + collatz(n / 2);
        }
        else {
            return 1 + collatz(3 * n + 1);
        }
    }
    public static List<Integer> useCollatz(int n) {
        List<Integer> stepsList = new ArrayList<>();
        recursion(stepsList, n);
        return stepsList;
    }

    public static void recursion(List<Integer> list, int n) {
        list.add(n);
        if (n == 1) {
            return;
        }

        if (n % 2 == 0) {
            recursion(list, n / 2);
        } else {
            recursion(list, 3 * n + 1);
        }
    }
}
