
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        HashSet<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int longestSub = 1;

        for (int num : numSet) {
            // Start counting only from the first number
            if (numSet.contains(num - 1))
                continue;

            int currentNum = num;
            int currentLength = 1;

            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentLength++;
            }

            longestSub = Math.max(longestSub, currentLength);
        }

        return longestSub;
    }
}
