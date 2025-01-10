class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       for( int i=0 ; i< nums.length ; i++){
        if(nums[i] % 2 == 0){
            nums[i] = 0;
        }else{
            nums[i]=1;
        }
       }

       int count=0;
       for(int start =0 ; start< nums.length ;start++){
        int sum =0;
        for(int end = start ;end < nums.length ; end++){
            sum += nums[end];
            if(sum == k){
                count ++;
            } 
        }
       }
       return count; 




    }
}

//Time limit exceeded