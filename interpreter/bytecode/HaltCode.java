package interpreter.bytecode;

import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {
    private String[] tokens;

    public HaltCode() {
    }

    public void execute(VirtualMachine vm) {
        vm.setIsRunning(false);
        vm.empty();
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
    }

    public void print(VirtualMachine vm) {
        System.out.printf("%s\n",
                tokens[0]);
    }
}
