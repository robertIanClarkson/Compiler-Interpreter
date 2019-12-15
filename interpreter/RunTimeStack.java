package interpreter;

import java.util.Vector;

public class RunTimeStack {

    private final Vector<Integer> framePointers;
    private final Vector<Integer> runStack;

    public RunTimeStack() {
        runStack = new Vector<>();
        framePointers = new Vector<>();
        framePointers.add(0);
    }

    public void dump() {
        try {
            System.out.print("[");
            if (runStack.size() > 0) {
                System.out.print(runStack.elementAt(0));
                for (int i = 1; i < runStack.size(); i++) {
                    if (framePointers.contains(i)) {
                        System.out.print("]");
                        System.out.print(" [");
                    } else {
                        System.out.print(",");
                    }
                    System.out.print(runStack.elementAt(i));
                }
            }
            System.out.print("]");
            System.out.print("\n");
        } catch (Exception e) {
            System.out.println("***Dump Failed***");
            System.exit(1);
        }
    }

    public int peek() {
        try {
            return runStack.lastElement();
        } catch (Exception e) {
            System.out.println("***Peek Failed***");
            System.exit(1);
            return 0;
        }
    }

    public int pop() {
        try {
            if(runStack.size() <= framePointers.lastElement() ){
                throw new Exception("***PopOutOfFrame***");
            }
            return runStack.remove(runStack.size() - 1);
        } catch (Exception e) {
            System.out.println("***Pop Failed***");
            System.exit(1);
            return 0;
        }
    }

    public int push(int item) {
        try {
            runStack.add(item);
            return item;
        } catch (Exception e) {
            System.out.println("***Push Failed***");
            System.exit(1);
            return item;
        }
    }

    public void newFrameAt(int offset) {
        try {
            framePointers.add(runStack.size() - offset);
        } catch (Exception e) {
            System.out.println("***NewFrame Failed***");
            System.exit(1);
        }
    }

    public void popFrame() {
        try {
            int returnValue = pop();
            int frameStart = framePointers.remove(framePointers.size() - 1);
            for (int i = runStack.size() - 1; i >= frameStart; i--) {
                runStack.removeElementAt(i);
            }
            push(returnValue);
        } catch (Exception e) {
            System.out.println("***PopFrame Failed***");
            System.exit(1);
        }
    }

    public void store(int offset) {
        try {
            int popToStore = pop();
            runStack.setElementAt(popToStore, offset);
        } catch (Exception e) {
            System.out.println("***Store Failed***");
            System.exit(1);
        }
    }

    public void load(int offset) {
        try {
            int peekToPush = runStack.elementAt(framePointers.lastElement() + offset);
            push(peekToPush);
        } catch (Exception e) {
            System.out.println("***Load Failed***");
            System.exit(1);
        }
    }

    public int[] getArgs() {
        try {
            int[] args = new int[runStack.size() - framePointers.lastElement()];
            int j = 0;
            for (int i = runStack.elementAt(framePointers.lastElement()); i < runStack.size(); i++) {
                args[j] = runStack.elementAt(i);
                j++;
            }
            return args;
        } catch (Exception e) {
            System.out.println("***GetArgs Failed***");
            System.exit(1);
            return null;
        }
    }

    public void empty() {
        try {
            while(!runStack.isEmpty()) {
                System.out.println("***Emptying stack***: " + pop());
            }
        } catch (Exception e) {
            System.out.println("***Empty Failed***");
            System.exit(1);
        }
    }
}