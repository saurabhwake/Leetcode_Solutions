import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int MOD = 1000000007;

    public int colorTheGrid(int m, int n) {
        Map<Integer, Integer> validCols = generateValidCols(m); // FIX: Added (m) to correctly call the method
        Map<Integer, Map<Integer, Integer>> transitionMap = buildTransformationMap(validCols); // FIX: Corrected variable name (transitionmap -> transitionMap)

        Map<Integer, Integer> prevDp = new HashMap<>();
        for (int col : validCols.keySet()) {
            prevDp.put(col, validCols.get(col)); 
        }

        for (int j = 1; j < n; j++) {
            Map<Integer, Integer> curDp = new HashMap<>();
            for (int prevCol : prevDp.keySet()) {
                for (int curCol : transitionMap.get(prevCol).keySet()) { 
                    int ways = (int) ((long) prevDp.get(prevCol) * transitionMap.get(prevCol).get(curCol) % MOD);
                    curDp.put(curCol, (curDp.getOrDefault(curCol, 0) + ways) % MOD); 
                }
            }
            prevDp = curDp;
        }

        int res = 0;
        for (int val : prevDp.values()) {
            res = (res + val) % MOD; 
        }
        return res;
    }

    private Map<Integer, Integer> generateValidCols(int m) { 
        Map<Integer, Integer> validCols = new HashMap<>();
        generateValidColumnHelper(m, 0, 0, validCols);
        return validCols; 
    }

    private void generateValidColumnHelper(int m, int row, int bitmask, Map<Integer, Integer> validCols) {
        if (row == m) {
            validCols.put(bitmask, validCols.getOrDefault(bitmask, 0) + 1);
            return;
        }

        for (int color = 1; color <= 3; color++) {
            if (row > 0 && ((bitmask >> ((row - 1) * 2)) & 3) == color) {
                continue;
            }
            generateValidColumnHelper(m, row + 1, bitmask | (color << (row * 2)), validCols); 
        }
    }

    private Map<Integer, Map<Integer, Integer>> buildTransformationMap(Map<Integer, Integer> validCols) {
        Map<Integer, Map<Integer, Integer>> transitionMap = new HashMap<>();
        for (int col1 : validCols.keySet()) {
            transitionMap.put(col1, new HashMap<>());
            for (int col2 : validCols.keySet()) {
                if (isValidTransition(col1, col2)) {
                    transitionMap.get(col1).put(col2, transitionMap.get(col1).getOrDefault(col2, 0) + validCols.get(col2));
                }
            }
        }
        return transitionMap;
    }

    private boolean isValidTransition(int col1, int col2) {
        while (col1 > 0 || col2 > 0) {
            if ((col1 & 3) == (col2 & 3)) return false;
            col1 >>= 2;
            col2 >>= 2;
        }
        return true;
    }
}