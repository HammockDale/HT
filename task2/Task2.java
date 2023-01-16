//package task2;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    static double x0, y0, radius;

    static void ft_eror(String s) {
        System.err.println(s);
        System.exit(1);
    }

    static void readFile_1(String path) {
        File file = new File(path);
        try (Scanner scan = new Scanner(new FileReader(file))) {
            if (!scan.hasNextDouble()) {
                ft_eror("Wrong argument 1");
            }
            x0 = scan.nextDouble();
            if (!scan.hasNextDouble()) {
                ft_eror("Wrong argument 2");
            }
            y0 = scan.nextDouble();
            if (!scan.hasNextDouble()) {
                ft_eror("Wrong argument");
            }
            radius = Math.abs(scan.nextDouble());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void  ft_print(double x1, double y1, int count) {
        double hypotenuse = Math.sqrt(x1 * x1 + y1 * y1);
        if (Math.abs(hypotenuse - radius) < 0.01 * Math.max(hypotenuse, radius)) {
            System.out.println(count + " - точка лежит на окружности");
        } else if (hypotenuse < radius) {
            System.out.println(count + " - точка внутри");
        } else {
            System.out.println(count +" - точка снаружи");
        }
    }

    static void readFile_2(String path) {
        double x1, y1;
        int count = 0;

        File file = new File(path);
        try (Scanner scan = new Scanner(new FileReader(file))) {
            while (true) {
                if (!scan.hasNextDouble()) {
                    return;
                }
                x1 = scan.nextDouble() - x0;
                if (!scan.hasNextDouble()) {
                    ft_eror("Wrong argument 2");
                }
                y1 = scan.nextDouble() - y0;

                ft_print(x1, y1, count);
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            ft_eror("Wrong number of arguments");
        }
        readFile_1(args[0]);
        readFile_2(args[1]);
    }
}