class Solution {
    public int hammingWeight(int n) {
        //brian karnighan's algo: to remove 1 bit use n & (n-1) 
        // we can also divide its quotient and store rem in string and thne check for one but not optimal O(logN)
        int count=0;
        while(n!=0){
           n=n &(n-1);
           count++;
        }
        return count; //O(k) number of 1 bits 
    }
}