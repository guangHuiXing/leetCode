package com.xgh;

import java.util.Stack;

/**
 * @ClassName MinStack
 * @Description
 * @Author xinggh
 * @Date 2020/5/12 14:15
 * @Version 1.0
 **/
public class MinStack {

    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-stack
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack();

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        int min = (minStack.size() == 0 ? 0 : minStack.peek());

        if (minStack.size() == 0) {
            minStack.push(x);

        } else if (x <= min) {
            minStack.push(x);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (pop == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (minStack.size() == 0) {
            return 0;
        }
        return minStack.peek();
    }


    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(0);
        obj.push(3);
        obj.push(0);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
