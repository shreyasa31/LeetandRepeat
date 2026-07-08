class Solution {
    public int maxArea(int[] height) {
        int i=0;int j=height.length-1;int max=Integer.MIN_VALUE;
        while(i<j){
            int width=j-i;
            int h=Math.min(height[i], height[j]);
            max=Math.max(max, width*h);

            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}