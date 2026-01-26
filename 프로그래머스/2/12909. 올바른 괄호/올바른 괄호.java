import java.util.*;
class Solution {
    Boolean solution(String s) {
    Stack<Character> stack = new Stack<>();
    
    for(char c : s.toCharArray()) {
      if(c == '(')
        stack.push(c);
      else {
        if(!stack.isEmpty()) {
          stack.pop();
        }
        else
          return false;
      }
    }
    if(stack.isEmpty())
      return true;
    return false;
  }
}