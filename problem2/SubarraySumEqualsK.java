package Week1.problem2;

import java.util.*;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            if (sumMap.containsKey(prefixSum - k)) {
                count += sumMap.get(prefixSum - k);
            }
            sumMap.put(prefixSum, sumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of days (n): ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter calories burned each day:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter target calorie burn (k): ");
        int k = scanner.nextInt();

        int result = subarraySum(nums, k);
        System.out.println("Total number of continuous subarrays with sum " + k + " = " + result);

        scanner.close();
    }
}