class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
    //     for (int k = 0; k < queries.length; k++) {
    //         int l = queries[k][0];
    //         int u = queries[k][1];

    //         for (int i = l; i <= u; i++) {
    //             if (nums[i] != 0) {
    //                 nums[i]--;
    //             }
    //         }
    //     }

    //     for (int num : nums) {
    //         if (num != 0) return false;
    //     }

    //     return true;
    // }

    //Time limit exceeds in above 
    //
        int n = nums.length;
int[] diff = new int[n + 1];  // Difference array

// Build difference array based on queries
for (int[] query : queries) {
    int l = query[0];
    int u = query[1];
    diff[l]++;
    if (u + 1 < n) {
        diff[u + 1]--;
    }
}

// Build times array using prefix sums
int[] times = new int[n];
times[0] = diff[0];
for (int i = 1; i < n; i++) {
    times[i] = times[i - 1] + diff[i];
}

// Now subtract min(nums[i], times[i])
for (int i = 0; i < n; i++) {
    nums[i] -= Math.min(nums[i], times[i]);
}

// Check if all zeros
for (int i = 0; i < n; i++) {
    if (nums[i] != 0) return false;
}
return true;

    }
}
