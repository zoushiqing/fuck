package com.fuck;

import com.fuck.binarytree.BinaryTree;

import org.junit.Test;

import java.util.Stack;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        String str = "1-2+3*(7-5)";
        //数字栈
        Stack<Integer> number = new Stack<>();
        //符号栈
        Stack<Character> op = new Stack<>();
        System.out.println(expressionToResult(str, number, op));
    }
    
    public static int expressionToResult(String str, Stack<Integer> number, Stack<Character> op) {
        //将str 转换成char[]
        char[] chars = str.toCharArray();
        //遍历char数组
        for (char x : chars) {
            if (x == '+' || x == '-' || x == '*' || x == '/') {
                int opLevel = 0;
                int thisOpLevel = optionLevel(x);
                //取此时符号栈顶元素的优先值和此时的入栈的符号比较
                if (!op.isEmpty()) {
                    //栈顶符号优先级
                    opLevel = optionLevel(op.peek());
                    //若此时将入栈的符号优先级小于栈顶符号优先级 则计算
                    if (thisOpLevel <= opLevel) {
                        int n1 = number.pop();
                        int n2 = number.pop();
                        int result = calResult(op.pop(), n2, n1);
                        number.push(result);
                        op.push(x);
                    }
                } else {
                    op.push(x);
                }
            } else if (x == '(') {
                op.push(x);
            } else if (x == ')') {
                //出现右括号
                while (true) {
                    char opStack = op.pop();
                    if (opStack == '(') {
                        break;
                    } else {
                        //不是左括号 就把()之间的数据运算
                        int n1 = number.pop();
                        int n2 = number.pop();
                        //将结果 放回数字栈中
                        number.push(calResult(opStack, n2, n1));
                    }
                }
            } else if (Character.isDigit(x)) {
                number.push(Integer.parseInt(String.valueOf(x)));
            }
        }
        while (true) {
            if (op.isEmpty()) {
                break;
            } else {
                int n1 = number.pop();
                int n2 = number.pop();
                number.push(calResult(op.pop(), n2, n1));
            }
        }
        return number.pop();
    }
    
    //计算两个值的数值
    private static int calResult(char pop, int x, int y) {
        switch (pop) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
        }
        return 0;
    }
    
    //判断符号优先级
    private static int optionLevel(char x) {
        switch (x) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
    
    @Test
    public void testMyHasMap() {
        MyMap map = new MyHashMap();
        for (int i = 0; i < 20; i++) {
            map.put("a"+i, i);
        }
        System.out.println("size:" + map.size());
        System.out.println("isEmpty:" + map.isEmpty());
        System.out.println(map.get("a1"));
    }
    @Test
    public void testTreeNode(){
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.crateBinaryTree();
//        int height = binaryTree.getHeight();
//        System.out.println("height = " + height);
        binaryTree.nonMidOrder(binaryTree.root);
    }
    
}