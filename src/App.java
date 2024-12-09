import java.util.Queue;
import Controllers.MenuController;
import java.util.LinkedList;
import Materia.Stack.Stack;
import Materia.Stack.StackGeneric;
import Views.ConsoleView;

public class App {
    public static void main(String[] args) throws Exception {
        runContactManager();
    }

    public static void runStack() {
        Stack stack = new Stack();  

        stack.push(5);
        stack.push(7);
        stack.push(10);
        stack.push(20);

        System.out.println("Top -> " + stack.peek());
        System.out.println("Pop -> " + stack.pop());
        System.out.println("Top -> " + stack.peek());
        System.out.println("Pop -> " + stack.pop());
        System.out.println("Top -> " + stack.peek());
    }

    public static void runContactManager(){
        MenuController menucontroller = new MenuController();
        menucontroller.showMenu();
    }
    
  
}
