package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.Scanner;


public class ReadCode extends ByteCode {
    private String[] tokens;
    private final Scanner scanner;

    public ReadCode() {
        scanner = new Scanner(System.in);
    }

    public void execute(VirtualMachine vm) {
        int userNumber = scanner.nextInt();
        vm.push(userNumber);
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
    }

    public void print(VirtualMachine vm) {
        System.out.printf("%s\n",
                tokens[0]);
    }
}
