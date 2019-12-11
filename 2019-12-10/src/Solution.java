import java.util.ArrayList;
import java.util.List;

public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        List<int[]> down = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int[] pair = new int[2];
                    pair[0] = nums[i];
                    pair[1] = nums[j];
                    down.add(pair);
                }
            }
        }

        boolean aSame = true;
        boolean bSame = true;
        int lastA = -1;
        int lastB = -1;
        for (int[] a : down) {
            if (lastA == -1) {
                lastA = a[0];
                lastB = a[1];
            } else {
                if (lastA != a[0]) {
                    aSame = false;
                }
                if (lastB != a[1]) {
                    bSame = false;
                }

                if (!aSame && !bSame) {
                    return false;
                }
            }
        }

        return true;
    }
}
