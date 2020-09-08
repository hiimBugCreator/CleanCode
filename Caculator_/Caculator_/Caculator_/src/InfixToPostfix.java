import java.util.Stack;

public class InfixToPostfix {
	
//	This method will check the symbolcalculation notation
    static int Prec(char ch) { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/':
        case '%':	
            return 2; 
       
        case '^': 
        case '!': 
            return 3;
        } 
        return -1; 
    } 
    
//    This method will convert the infix expression to posfix expression
    static String infixToPostfix(String exp) { 
        String result = new String(""); 
        String temp="";
        Stack<Character> stack = new Stack<>(); 
        for (int i = 0; i<exp.length(); ++i) { 
            char c = exp.charAt(i); 
            if (Character.isLetter(c)) 
                result += c+" ";
            else if (Character.isDigit(c)) 
            	if (i!=exp.length()-1) {
            		if (Character.isDigit(exp.charAt(i+1)))
                		temp+=c;
                	else {
                		temp+=c;
                		result += temp+" ";
                		temp="";
                	}
            	} else {
            		temp+=c;
            		result += temp+" ";
            		temp="";
            	}
            else if (c == '(') 
                stack.push(c); 
            else if (c == ')') { 
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop()+" "; 
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression";                
                else
                    stack.pop(); 
            } else { 
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){ 
                    if(stack.peek() == '(') 
                        return "Invalid Expression"; 
                    result += stack.pop()+" "; 
             } 
                stack.push(c); 
            } 
        } 
        while (!stack.isEmpty()){ 
            if(stack.peek() == '(') 
                return "Invalid Expression"; 
            result += stack.pop()+" "; 
         } 
        return result;  
    }
} 