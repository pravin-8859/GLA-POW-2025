package Week1.problem2;
import java.util.HashMap;
import java.util.Map;

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
        int[] nums1 = {1, 2, 3};
        int k1 = 3;
        System.out.println("Example 1 Output: " + subarraySum(nums1, k1));

        int[] nums2 = {1, 1, 1};
        int k2 = 2;
        System.out.println("Example 2 Output: " + subarraySum(nums2, k2));
    }
}