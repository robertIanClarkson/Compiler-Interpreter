package interpreter;

import java.util.HashMap;

public class CodeTable {

    private static final HashMap<String, String> bytecodes = new HashMap<>();

    public static void init() {
        bytecodes.put("HALT", "HaltCode");
        bytecodes.put("POP", "PopCode");
        bytecodes.put("FALSEBRANCH", "FalseBranchCode");
        bytecodes.put("GOTO", "GoToCode");
        bytecodes.put("STORE", "StoreCode");
        bytecodes.put("LOAD", "LoadCode");
        bytecodes.put("LIT", "LitCode");
        bytecodes.put("ARGS", "ArgsCode");
        bytecodes.put("CALL", "CallCode");
        bytecodes.put("RETURN", "ReturnCode");
        bytecodes.put("BOP", "BopCode");
        bytecodes.put("READ", "ReadCode");
        bytecodes.put("WRITE", "WriteCode");
        bytecodes.put("LABEL", "LabelCode");
        bytecodes.put("DUMP", "DumpCode");
    }

    public static String get(String code) {
        return bytecodes.get(code);
    }
}
