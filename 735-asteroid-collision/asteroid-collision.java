class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       
    Stack<Integer> stack=new Stack<>();
    stack.push(asteroids[0]);
    for(int i=1;i<asteroids.length;i++){
        boolean isDestroyed=false;
        while(!stack.isEmpty() && (stack.peek()>0 && asteroids[i]<0))
        {

        
        if(Math.abs(asteroids[i])<Math.abs(stack.peek())){
            isDestroyed=true;
            break;
        }else if(Math.abs(asteroids[i])>Math.abs(stack.peek())){

            stack.pop();
        
        }else if(Math.abs(stack.peek())==Math.abs(asteroids[i])) {
            isDestroyed=true;
            stack.pop();
            break;
        }
       
    }
    if(!isDestroyed)
    stack.push(asteroids[i]);
    }

    int i=0;
    int[] res=new int[stack.size()];
        for(int s:stack){
        res[i]=s;
        i++;
    }

    return res;








    }
}