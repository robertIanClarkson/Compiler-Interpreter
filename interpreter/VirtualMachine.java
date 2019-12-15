package interpreter;

import java.util.Vector;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

public class VirtualMachine {

    private int pc;
    private RunTimeStack runTimeStack;
    private final Vector<Integer> returnAddresses;
    private boolean isRunning;
    private final Program program;
    private boolean dump;

    public VirtualMachine(Program program) {
        this.program = program;
        returnAddresses = new Vector<>();
        dump = false;
    }

    public void executeProgram() {
        pc = 0;
        runTimeStack = new RunTimeStack();
        isRunning = true;

        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if (dump && !(code instanceof DumpCode)) {
                code.print(this);
                runTimeStack.dump();
            }
            pc++;
        }
    }

    public void setDump(boolean state) {
        dump = state;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }

    public void newFrameAt(int offset) {
        runTimeStack.newFrameAt(offset);
        returnAddresses.add(pc + 1);
    }

    public void push(int item) {
        runTimeStack.push(item);
    }

    public int peek() {
        return runTimeStack.peek();
    }

    public int pop() {
        return runTimeStack.pop();
    }

    public void store(int offset) {
        runTimeStack.store(offset);
    }

    public void load(int offset) {
        runTimeStack.load(offset);
    }

    public void popFrame() {
        runTimeStack.popFrame();
        pc = returnAddresses.remove(returnAddresses.size() - 1);
    }

    public int[] getArgs() {
        return runTimeStack.getArgs();
    }

    public void empty() {
        runTimeStack.empty();
    }
}
