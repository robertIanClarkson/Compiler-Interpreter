package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LitCode extends ByteCode {
    private String[] tokens;
    private int val;

    public LitCode() {
    }

    public void execute(VirtualMachine vm) {
        vm.push(val);
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
        val = Integer.parseInt(tokens[1]);
        if (tokens.length > 2) {
            String variableName = tokens[2];
        }
    }

    public void print(VirtualMachine vm) {
        if (tokens.length > 2) {
            String indent25 = "                         ";
            String output = String.format("%s %s %s", tokens[0], tokens[1], tokens[2]);
            output += indent25.substring(0, indent25.length() - output.length());
            output += "int " + tokens[2];
            System.out.println(output);
        } else {
            System.out.printf("%s %s\n",
                    tokens[0],
                    tokens[1]);
        }

    }
}
