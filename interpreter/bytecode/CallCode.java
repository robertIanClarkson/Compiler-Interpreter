package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallCode extends ByteCode {
    private String[] tokens;
    private String label;
    private int address;

    public CallCode() {
    }

    public void execute(VirtualMachine vm) {
        vm.setPC(address - 1);
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
        int[] args = vm.getArgs();
        String indent25 = "                         ";
        StringBuilder output = new StringBuilder(String.format("%s %s", tokens[0], tokens[1]));
        output.append(indent25, 0, indent25.length() - output.length());
        output.append(getBaseID()).append("(").append(args[0]);
        for (int i = 1; i < args.length; i++) {
            output.append(",").append(args[i]);
        }
        output.append(")");
        System.out.println(output);
    }

    private String getBaseID() {
        return tokens[1].split("<")[0];
    }
}
