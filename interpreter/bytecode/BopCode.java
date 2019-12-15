package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
    private String[] tokens;
    private String operator;

    public BopCode() {
    }

    public void execute(VirtualMachine vm) {
        int x = vm.pop();
        int y = vm.pop();
        switch (operator) {
            case "+":
                vm.push(x + y);
                break;
            case "-":
                vm.push(x - y);
                break;
            case "*":
                vm.push(x * y);
                break;
            case "/":
                vm.push(x / y);
                break;
            case "==":
                if (x == y) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
            case "!=":
                if (x != y) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
            case "<=":
                if (x <= y) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
            case ">=":
                if (x >= y) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
            case "<":
                if (x < y) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
            case ">":
                if (x > y) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
            case "|":
                if ((x == 1) && (y == 1)) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
            case "&":
                if ((x == 1) || (y == 1)) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
        }
    }

    public void init(String[] tokens) {
        this.tokens = tokens;
        operator = tokens[1];
    }

    public void print(VirtualMachine vm) {
        System.out.printf("%s %s\n",
                tokens[0],
                tokens[1]);
    }
}
