package com.wisely.highlight_spring4.structures.stack;

/**
 * Created by gaowenfeng on 2017/7/24.
 */
public class ParentMatcher {
    private String inputString,outputString;

    private boolean match(char c,char d){
        switch (c){
            case '(' : return (d==')');
            case '[' : return (d==']');
            case '{' : return (d=='}');
            default:return false;
        }
    }

    public void parentMatch(){
        Stack<Character> parentStack = new LindedStack<Character>();

        int n = inputString.length();

        int i=0;

        char c,d;

        while (i<n){
            d = inputString.charAt(i);  //第i个字符

            if(d == '(' || d == '{' || d == '['){  //压入三种左括号
                parentStack.push(new Character(d));
            }else if(d == ')' || d == '}' || d == ']'){ //匹配三种右括号
                if(parentStack.empty()){
                    setOutputString("【括号匹配】，右括号数量多于左括号");
                    return;
                }else{
                    c = parentStack.pop().charValue();

                    if(!match(c,d)){
                        setOutputString("【括号匹配】，"+c+"和"+d+"不匹配");
                        return;
                    }  //end if
                }  // end else
            }  // end else if
            ++ i ;
        } //end while;

        if(parentStack.empty())
            setOutputString("【括号匹配】，括号匹配完全成功");
        else
            setOutputString("【括号匹配】，左括号数量多于左括号");
    }  //end parentMatch


    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getOutputString() {
        return outputString;
    }

    public void setOutputString(String outputString) {
        this.outputString = outputString;
    }
}
