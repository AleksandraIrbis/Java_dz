package sem4dz;

public class task3 {
    private int[] stack;
    private int top;

    public task3(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean empty() {
        return top == -1;
    }

    public void push(int item) {
        if (top == stack.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        top++;
        stack[top] = item;
    }

    public int peek() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public int pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int item = stack[top];
        top--;
        return item;
    }

    public static void main(String[] args) {
        task3 stack = new task3(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());

        while (!stack.empty()) {
            System.out.println("Pop: " + stack.pop());
        }
    }
}
