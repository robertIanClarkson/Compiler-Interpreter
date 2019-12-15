package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
    private String[] tokens;
    private int offset;

    public ArgsCode() {
    }

    public void execute(VirtualMachine vm) {
        vm.newFrameAt(offset);
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
        offset = Integer.parseInt(tokens[1]);
    }

    public void print(VirtualMachine vm) {
        System.out.printf("%s %s\n",
                tokens[0],
                tokens[1]);
    }
}
