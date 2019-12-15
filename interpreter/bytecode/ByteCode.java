package interpreter.bytecode;

import interpreter.VirtualMachine;

public abstract class ByteCode {
    public abstract void execute(VirtualMachine vm);

    public abstract void init(String[] tokens);

    public abstract void print(VirtualMachine vm);
}
