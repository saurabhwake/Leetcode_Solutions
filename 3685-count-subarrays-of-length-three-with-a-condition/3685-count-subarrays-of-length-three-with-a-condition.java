class Solution {
    public int countSubarrays(int[] nums) {
        int n=0;
        for(int i=0;i<nums.length-2;i++){
        if((nums[i]+nums[i+2]) == (double)nums[i+1]/2){
            n+=1;
        }
        }
         return n;
        }
    }
