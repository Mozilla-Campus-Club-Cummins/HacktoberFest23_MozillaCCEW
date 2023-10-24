public boolean matching(char a, char b){
        if(a == '(' && b ==')'){
            return true;
        }
        else if(a == '{' && b == '}'){
            return true;
        }
        else if(a == '[' && b== ']'){
            return true;
        }
        else{
            return false;
        }
    }
     boolean ValidParanthesis(String x){
       Deque<Character> s = new ArrayDeque<>();
       for(int i = 0; i <x.length();i++){
           char ch = x.charAt(i);
           if(ch == '(' || ch == '{' || ch == '['){
               s.push(ch);
           }
           else if(s.isEmpty() == true){
               return false;
           }
           else if(matching(s.peek(),ch) == false){
               return false;
           }
           else{
               s.pop();
           }
       }
       return (s.isEmpty() == true);
    }
