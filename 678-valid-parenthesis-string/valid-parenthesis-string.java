class Solution {
    public boolean checkValidString(String s) {
        //only thing matters here is openstack check that empty or not 
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> asterStack = new Stack<>();

        for (int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            if (c == '(') {
                openStack.push(i);
            }

            if (c == '*') {
                asterStack.push(i);
            }

            if(c==')'){
                if(!openStack.isEmpty()){
                  openStack.pop();
                }else if(!asterStack.isEmpty()){
                    asterStack.pop();
                }else{
                    return false;
                }
                
               
            }

        }
        while(!openStack.isEmpty() && ! asterStack.isEmpty() ){
            if(openStack.pop()>asterStack.pop()){
                return false;
            }
        }
        return openStack.isEmpty();
    }
}