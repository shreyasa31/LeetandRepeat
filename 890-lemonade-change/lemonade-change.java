class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0, tens=0;

        for(int num:bills){
            if(num==5){
                five++;
            }else if(num==10){
                if(five==0) return false;
                five--;
                tens++;
            }
            else{
                if(five >0 && tens>0){
                   
                    tens--;
                    five--;
                }else if(five>=3){
                   five-=3;
                }else{
                   return false;
                }
            }
            
        }
        return true;
    }
}