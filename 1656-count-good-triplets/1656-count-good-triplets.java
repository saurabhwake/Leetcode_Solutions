class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n=0;
        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(Math.abs(arr[i]-arr[j])<=a && Math.abs(arr[j]-arr[k])<=b && Math.abs (arr[k]-arr[i])<=c){
                n++;
                }
            }
            // if(arr[i]-arr[i+1]<=a && arr[i+1]-arr[i+2]<=b && arr[i]-arr[i+2]<=c){
            //     n+=1;
            }
        }
        return n;
    }
}