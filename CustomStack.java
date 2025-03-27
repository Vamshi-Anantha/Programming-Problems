import java.util.*;

class CustomStack {
    static class Stack {
        ArrayList<Integer> list;

        Stack() {
            list = new ArrayList<>();
        }

        void push(int element) {
            list.add(element);
        }

        int peek() {
            if (list.size() == 0) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

        int pop() {
            if (list.size() == 0) {
                return -1;
            }
            int element = this.peek();
            list.remove(list.size() - 1);
            return element;
        }

        int getSize() {
            return list.size();
        }

        boolean isEmpty() {
            return list.size() == 0;
        }

        // Method to print stack elements
        void printStack() {
            if (list.isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            System.out.println("Stack elements (top to bottom):");
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(list.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(20);
        s.push(6);
        s.push(5);
        s.push(2);
        s.push(4);

        // Print stack before popping
        s.printStack();

        System.out.println("\nPeek: " + s.peek());
        System.out.println("\nPopping elements:");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        // Print stack after popping
        System.out.println("\nStack after popping:");
        s.printStack();
    }
}
