class Solution {
    public int longestMountain(int[] arr) {
        
    if(arr.length < 3) return 0;
    int res = 0;
    int i =0;
    boolean peak =false;
    boolean valley = false;
    while(i < arr.length -1){
        if(arr[i]<arr[i+1]){
            int start =i;
            while(i<arr.length-1 && arr[i] < arr[i+1]){
                i++;
                peak =true;
            }
             while(i<arr.length-1 && arr[i] > arr[i+1]){
                i++;
                valley =true;
            }
            if( peak == true && valley ==true){
                res =Math.max(res ,i-start+1);

            }
            peak =false;
            valley=false;

        }else{
            i++;
        }
        
    }
    return res;

}}
