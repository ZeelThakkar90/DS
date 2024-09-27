class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
        this.next = null;
    }
    StackNode(int data,StackNode next)  {
        this.data = data;
        this.next = next;
    }
}

class Stack_LL {
    StackNode top;
    int size;

    Stack_LL() {
        this.top = null;
        this.size = 0;
    }

    public void stackPush(int x) {
        StackNode element = new StackNode(x);
        element.next = top;
        top = element;
        System.out.println("Element pushed");
        size++;
    }

    public int stackPop() {
        if (top == null)
            return -1;
        int topData = top.data;
        top = top.next;
        return topData;
    }

    public int stackSize() {
        return size;
    }

    public boolean stackIsEmpty() {
        return top == null;
    }

    public void printStack() {
        System.out.println("Stack elements:  ");
        StackNode current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class StackUsingLL {
    public static void main(String args[]) {
        Stack_LL s = new Stack_LL();
        s.stackPush(10);
        s.stackPush(20);
        s.stackPush(30);
        System.out.println("========================================");
        s.printStack();
        System.out.println("========================================");
        System.out.println("Element popped " + s.stackPop());
        System.out.println("Stack size: " + s.stackSize());
        System.out.println("Stack is empty or not: " + s.stackIsEmpty());
    }
}