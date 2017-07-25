package com.wisely.highlight_spring4.structures.stack;

import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by gaowenfeng on 2017/7/25.
 */
public class PostFixInterpreter {
    private String postfixString,outputString;

    private boolean isOperator(char c){
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    private boolean isSpace(char c){
        return (c == ' ');
    }

    public String getPostfixString() {
        return postfixString;
    }

    public void setPostfixString(String postfixString) {
        this.postfixString = postfixString;
    }

    public String getOutputString() {
        return outputString;
    }

    public void setOutputString(String outputString) {
        this.outputString = outputString;
    }

    public void interpretPostfix(){
        Stack<Double> evalStack = new ArrayStack<>();
        double leftOperand,rightOperand;
        char c;
        StringTokenizer parser = new StringTokenizer(postfixString,"+-*/^ ",true);

        while (parser.hasMoreTokens()){  //postfixString中还有更多的token
            String token = parser.nextToken();  //得到下一个token
            c  = token.charAt(0);   //token的第一个字符
            if((token.length()==1)&&isOperator(c)){  //如果token是一个操作符
                rightOperand = evalStack.pop().doubleValue();
                leftOperand = evalStack.pop().doubleValue();

                switch (c){
                    case '+':evalStack.push(new Double(leftOperand+rightOperand));
                        break;
                    case '-':evalStack.push(new Double(leftOperand-rightOperand));
                        break;
                    case '*':evalStack.push(new Double(leftOperand*rightOperand));
                        break;
                    case '/':evalStack.push(new Double(leftOperand/rightOperand));
                        break;
                    case '^':evalStack.push(new Double(Math.exp(Math.log(leftOperand+rightOperand))));
                        break;
                    default:
                        break;
                }
            }else if((token.length()==1)&&isSpace(c)){  //否则如果是空格则忽略它

            }else{  //否则讲token的数值型值压入堆栈
                evalStack.push(Double.valueOf(token));
            }
        }

        System.out.println("结果的值为："+evalStack.pop());

    }

    public static void main(String[] args) {
        PostFixInterpreter postFixInterpreter = new PostFixInterpreter();
        postFixInterpreter.setPostfixString("1.3 7.5 + 1.1 / 12 10 - *");
        postFixInterpreter.interpretPostfix();
    }
}
