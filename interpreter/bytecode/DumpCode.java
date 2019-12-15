package interpreter.bytecode;

import interpreter.VirtualMachine;


public class DumpCode extends ByteCode {
    private String[] tokens;
    private String state;

    public DumpCode() {
    }

    public void execute(VirtualMachine vm) {
        if (state.equals("ON")) {
            vm.setDump(true);
        } else {
            vm.setDump(false);
        }
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
        state = tokens[1];
    }

    public void print(VirtualMachine vm) {
        System.out.printf("%s %s\n",
                tokens[0],
                tokens[1]);
    }
}
