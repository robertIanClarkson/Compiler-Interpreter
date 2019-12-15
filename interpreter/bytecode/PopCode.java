package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    private String[] tokens;
    private int levels;

    public PopCode() {

    }

    public void execute(VirtualMachine vm) {
        for (int i = 0; i < levels; i++) {
            vm.pop();
        }
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
        levels = Integer.parseInt(tokens[1]);
    }

    public void print(VirtualMachine vm) {
        System.out.printf("%s %s\n",
                tokens[0],
                tokens[1]);
    }
}
