public class Solution1 {
    public boolean hasAlternatingBits(int n) {
        int m = n;
        boolean first = true;
        int bit = 0;    
        while (m != 0) {    
            if (first == true) {
                bit = m & 1;    
                first = false;
            } else {
                if ((m & 1) == bit) {
                    return false;
                }
                bit = m & 1;
            }

            m = m>>1;   
        }

        return true;
    }
}
