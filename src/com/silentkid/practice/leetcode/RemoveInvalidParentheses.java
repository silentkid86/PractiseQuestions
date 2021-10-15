package com.silentkid.practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        int leftRem =0, rightRem=0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c != '(' && c != ')') continue;

            if(c == '('){
                leftRem++;
            }else{
                if(leftRem > 0){
                    leftRem--;
                }else{
                    rightRem++;
                }

            }

        }

        dfs(s,0,0,0,leftRem,rightRem, new StringBuffer(),0);

        return new ArrayList<>(valids);

    }

    Set<String> valids = new HashSet<>();

    public void dfs(String s,int index,int leftCount,int rightCount , int leftRem , int rightRem,StringBuffer sb, int removedCount){

        if(index == s.length()){
            //BASE case , at the end of the String
            if(leftRem == rightRem){
                String validExpr = sb.toString();
                valids.add(validExpr);
            }
        }else{
            //Not the END of the STRING
            char currentChar =  s.charAt(index);
            int currentLen = sb.length();

            if(currentChar != '(' && currentChar != ')'){
                //NOT a parentheses , just just include and recurse
                sb.append(currentChar);
                dfs(s,index+1,leftCount,rightCount,leftRem,rightRem,sb,removedCount);
                sb.deleteCharAt(currentLen);

            }else{
                // a parentheses , two cases here
                // REMOVE or KEEP

                //REMOVE and recurse to find out all expression
                if((currentChar == '(' && leftRem>0) || (currentChar == ')' && rightRem>0)){

                    int l = (currentChar == '(' && leftRem>0) ? leftRem - 1:leftRem;
                    int r = (currentChar == ')' && rightRem>0) ? rightRem - 1: rightRem;
                    dfs(s,index+1,leftCount,rightCount,l,r,sb,removedCount + 1);

                }


                //KEEPing
                sb.append(currentChar);
                if(currentChar == '('){
                    dfs(s,index + 1,leftCount + 1,rightCount,leftRem,rightRem,sb,removedCount);
                }else{
                    /*
                    in CLOSE parentheses:
                    only go forward when current expression has more OPEN parenthesis then CLOSE parentheses
                     */
                    if(leftCount > rightCount ){
                        dfs(s,index + 1,leftCount,rightCount+1,leftRem,rightRem,sb,removedCount);
                    }
                }
                sb.deleteCharAt(currentLen);

            }

        }

    }


    public static void main(String[] argz){
        String input = "(a)())()";
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        List<String> ss = r.removeInvalidParentheses(input);

        ss.stream().forEach(System.out::println);

    }
}
