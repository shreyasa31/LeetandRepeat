class Solution {
    public int maxArea(int[] height) {
        // i want width, height, area and max area
        int max=Integer.MIN_VALUE;
        int i=0;int j=height.length-1;
        while(i<j){
            int width=j-i;
            int h=Math.min(height[i],height[j]);
            int area=h*width;
            max=Math.max(max,area);

            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return  max;
    }
}