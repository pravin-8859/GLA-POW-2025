package problem1;

import java.util.Scanner;

public class MinRotatedArrayBinary {
    public static int findMin(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low];
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