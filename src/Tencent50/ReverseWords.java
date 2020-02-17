package Tencent50;

import java.util.Stack;

public class ReverseWords {
    public String reverseWords(String s) {
        Stack<Character> tmp = new Stack<>();
        char[] str = s.concat(" ").toCharArray();
        int flag = 0;

        for (int index = 0; index < str.length; index++){
          if (str[index] == ' '){
              int wordLength = tmp.size();
              for (int j = 0; j < wordLength;j++){
                 str[flag + j] = tmp.pop();
              }
              flag = index + 1;
          } else {
              tmp.push(str[index]);
          }
        }
        String res = String.valueOf(str);
        return  res.substring(0,res.length()-1);
    }
}
