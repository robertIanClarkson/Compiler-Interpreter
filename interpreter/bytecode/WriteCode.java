package interpreter.bytecode;

import interpreter.VirtualMachine;

public class WriteCode extends ByteCode {
    private String[] tokens;

    public WriteCode() {
    }

    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
    }

    public void print(VirtualMachine vm) {
        System.out.printf("%s\n",
                tokens[0]);
    }
}
