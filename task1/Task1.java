package task1;

import java.util.Scanner;

public class Task1 {

    static void ft_eror(String s) {
        System.err.println(s);
        System.exit(1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 0, m = 0;
        if (scan.hasNextInt()){
            n = scan.nextInt();
        } else {
            ft_eror("Invalid value");
        }
        if (scan.hasNextInt()){
            m = scan.nextInt();
        } else {
            ft_eror("Invalid value");
        }
        if (n <= 0 || m <= 0) {
            ft_eror("Invalid value, n = " + n + ", m = " + m);
        }
        int cnt = 0;
        int rec = 0;
        do {
            System.out.print(rec + 1);
            rec = (rec + m - 1) % n;
            if (cnt++ > n) {
                ft_eror("Invalid algorithm");
            }
        }
        while (rec != 0 && n != 1);
        System.out.println();
    }
}