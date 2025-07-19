package problem1;

import java.util.Scanner;

public class MinRotatedArrayLinear {
    public static int findMin(int[] arr) {
        int minElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minElement = Math.min(minElement, arr[i]);
        }
        return minElement;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMin(arr));
        sc.close();
    }
}