package interpreter;

import interpreter.bytecode.*;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Program {
    private final List<ByteCode> byteCodes;
    private final HashMap<String, Integer> labels;

    Program() {
        byteCodes = new LinkedList<>();
        labels = new HashMap<>();
    }

    public void addCode(ByteCode byteCode) {
        byteCodes.add(byteCode);
    }

    public ByteCode getCode(int programCounter) {
        return byteCodes.get(programCounter);
    }

    public void resolveAddresses() {
        int counter = 0;
        for (ByteCode code : byteCodes) {
            if (code instanceof interpreter.bytecode.LabelCode) {
                labels.put(((LabelCode) code).getLabel(), counter);
            }
            counter++;
        }
        for (ByteCode code : byteCodes) {
            if (code instanceof interpreter.bytecode.GoToCode) {
                ((GoToCode) code).setAddress(labels.get(((GoToCode) code).getLabel()));
            } else if (code instanceof interpreter.bytecode.FalseBranchCode) {
                ((FalseBranchCode) code).setAddress(labels.get(((FalseBranchCode) code).getLabel()));
            } else if (code instanceof interpreter.bytecode.CallCode) {
                ((CallCode) code).setAddress(labels.get(((CallCode) code).getLabel()));
            }
        }
    }
}
