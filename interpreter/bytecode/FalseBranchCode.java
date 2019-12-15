package interpreter.bytecode;

import interpreter.VirtualMachine;

public class FalseBranchCode extends ByteCode {
    private String[] tokens;
    private String label;
    private int address;

    public FalseBranchCode() {
    }

    public void execute(VirtualMachine vm) {
        int bool = vm.pop();
        if (bool == 0) {
            vm.setPC(address - 1);
        }
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
        label = tokens[1];
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    public void print(VirtualMachine vm) {
        System.out.printf("%s %s\n",
                tokens[0],
                tokens[1]);
    }
}
