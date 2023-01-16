//package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {

    static void ft_eror(String s) {
        System.err.println(s);
        System.exit(1);
    }

    private final static int ft_count(ArrayList<Integer> nums, int thr) {
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count = count + Math.abs(nums.get(i) - thr);
        }
        return count;
    }

    static ArrayList<Integer> readFile(String path) {
        ArrayList<Integer> nums = new ArrayList<>();
        File file = new File(path);
        try (Scanner scan = new Scanner(new FileReader(file))) {
            while (scan.hasNextInt()) {
                nums.add(scan.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return nums;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            ft_eror("Wrong number of arguments");
        }
        ArrayList<Integer> nums;
        nums = readFile(args[0]);

        int min = nums.get(0);
        int max = nums.get(0);
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }
        int count = ft_count(nums, min++);
        for (; min <= max; min++) {
            count = ft_count(nums, min) < count ? ft_count(nums, min) : count;
        }
        System.out.println(count);
    }
}
