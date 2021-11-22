/**
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.

 */
class MyQueue {
    Stack<Integer> stackA;
    Stack<Integer> stackB;

    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }
    
    public void push(int x) {
        while (!stackB.isEmpty()) {
            stackA.push(stackB.pop());
        }
        
        stackA.push(x);
    }
    
    public int pop() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        
        return stackB.pop();
    }
    
    public int peek() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        
        return stackB.peek();
    }
    
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */