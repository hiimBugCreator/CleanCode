import java.util.List;
import java.util.Stack;

public class PostfixToInfix {
	
//		This method will calculate the value of the postfix expression
		static int evaluatePostfix(String exp) {
			Stack<Integer> stack = new Stack<>(); 
	        for(int i = 0; i < exp.length(); i++) 
	        { 
	            char c = exp.charAt(i); 
	              
	            if(c == ' ') 
	            continue; 
	            else if(Character.isDigit(c)) 
	            { 
	                int n = 0; 
	                while(Character.isDigit(c)) { 
	                    n = n*10 + (int)(c-'0'); 
	                    i++; 
	                    c = exp.charAt(i); 
	                } 
	                i--; 
	                stack.push(n); 
	            } 
	            else
	            {  
	            	int val1; 
	                int val2;
	                switch(c) { 
	                	
	                    case '+': 
	                	val1 = stack.pop(); 
	                    val2 = stack.pop();
	                    stack.push(val2+val1); 
	                    break; 
	                      
	                    case '-': 
	                    val1 = stack.pop(); 
	                    val2 = stack.pop();
	                    stack.push(val2- val1); 
	                    break; 
	                      
	                    case '/': 
	                    val1 = stack.pop(); 
	                    val2 = stack.pop();
	                    stack.push(val2/val1); 
	                    break; 
	                    
	                    case '%': 
	                    val1 = stack.pop(); 
	                    val2 = stack.pop();
	                    stack.push(val2/val1); 
	                    break; 
	                    
	                    case '*': 
	                	val1 = stack.pop(); 
	                    val2 = stack.pop();
	                    stack.push(val2*val1); 
	                    break; 
	                    
	                    case '^': 
	                	val1 = stack.pop(); 
	                    val2 = stack.pop();
	                    int s=1;
	                    for(int z=1;z<=val1;z++) {
	                    	s=s*val2;
	                    }
		                stack.push(s); 
		                break; 
		                
	                    case '!': 
	                    val1 = stack.pop(); 
	                    int s1=1;
	                    for(int z=1;z<=val1;z++) {
	                    	s1=s1*z;
	                    }
		                stack.push(s1); 
		                break; 
	              } 
	            } 
	        } 
	        return stack.pop();     
	    }
//		This method will replace variables with values
		static String replaceValue(String exp,List<String> variable,List<String> value) {
			for(int i=0;i<variable.size();i++) { 
				int j=0;
				while(j<exp.length()) { 
					String c = exp.charAt(j)+"";
					if(c.equals(variable.get(i))){
						exp=exp.substring(0,j)+value.get(i)+exp.substring(j+1, exp.length());
					}
					j++;
				}
			}
			return exp;
		}
}
