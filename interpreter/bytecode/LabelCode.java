package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LabelCode extends ByteCode {
    private String[] tokens;
    private String label;

    public LabelCode() {
    }

    public void execute(VirtualMachine vm) {
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
        label = tokens[1];
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
