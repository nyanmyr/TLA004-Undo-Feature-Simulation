package stackundo;

import java.util.*;

public class StackUndo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<String> actions = new Stack<>();

        OUTER:
        while (true) {
            // prompts the user to input an action
            System.out.print("(type 'undo' to undo, 'exit'/'went out' to stop) \n");
            System.out.print("Enter an action: ");
            String typed = scanner.nextLine();
            
            // depending on user input, an action will be done
            switch (typed) {
                // if undo is typed then the previous action will be undone (saved in the stack)
                case "undo" -> {
                    if (actions.isEmpty()) {
                        System.out.println("Error: There are no actions to undo.");
                    } else {
                        System.out.printf("You undid (%s) \n", actions.pop());
                    }
                }
                // if exit or went out is typed then the program exits
                case "exit", "went out" -> {
                    System.out.println("You went out. Program exited.");
                    break OUTER;
                }
                // else the action will be saved in the stack 
                default -> System.out.printf("You saved (%s) \n", actions.push(typed));
            }
            System.out.println();
        }

    }
    
}
