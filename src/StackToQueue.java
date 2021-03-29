import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class StackToQueue {

    Stack<Integer> firstStack;
    Stack<Integer> secondStack;

    public StackToQueue(){
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    public void push(int node){
        firstStack.push(node);
    }

    public int pop(){
        if (secondStack.empty()){
            while (!firstStack.empty()){
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }

}
