package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    private String[] tokens;

    public ReturnCode() {

    }

    public void execute(VirtualMachine vm) {
        vm.popFrame();
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
        if (tokens.length > 1) {
            String label = tokens[1];
        }
    }

    public void print(VirtualMachine vm) {
        if (tokens.length > 1) {
            String indent25 = "                         ";
            String output = String.format("%s %s", tokens[0], tokens[1]);
            output += indent25.substring(0, indent25.length() - output.length());
            output += "exit " + getBaseID() + ": " + vm.peek();
            System.out.println(output);
        } else {
            System.out.println(tokens[0]);
        }
    }

    private String getBaseID() {
        return tokens[1].split("<")[0];
    }
}
