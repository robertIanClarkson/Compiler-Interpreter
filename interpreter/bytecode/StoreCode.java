package interpreter.bytecode;

import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {
    private String[] tokens;
    private int offset;

    public StoreCode() {

    }

    public void execute(VirtualMachine vm) {
        vm.store(offset);
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
        offset = Integer.parseInt(tokens[1]);
        String variableName = tokens[2];
    }

    public void print(VirtualMachine vm) {
        String indent25 = "                         ";
        String output = String.format("%s %s %s", tokens[0], tokens[1], tokens[2]);
        output += indent25.substring(0, indent25.length() - output.length());
        output += tokens[2] + " = " + vm.peek();
        System.out.println(output);
    }
}
