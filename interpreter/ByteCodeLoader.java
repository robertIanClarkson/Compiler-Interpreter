package interpreter;

import interpreter.bytecode.*;

import java.io.*;
import java.util.List;
import java.util.LinkedList;

public class ByteCodeLoader {
    private final List<String> lines;

    public ByteCodeLoader(String byteCodeFile) throws IOException {
        lines = new LinkedList<>();
        try {
            BufferedReader source = new BufferedReader(new FileReader(byteCodeFile));
            while (true) {
                String nextLine = source.readLine();
                if (nextLine != null) {
                    lines.add(nextLine);
                } else {
                    source.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public Program loadCodes() {
        Program program = new Program();
        String[] tokens;
        for (String line : lines) {
            try {
                tokens = line.split(" ");
                String codeClass = CodeTable.get(tokens[0]);
                ByteCode code = (ByteCode) Class.forName("interpreter.bytecode." + codeClass)
                        .getDeclaredConstructor().newInstance();
                code.init(tokens);
                program.addCode(code);
            } catch (Exception e) {
                System.out.println("LoadCodes*** " + e);
            }
        }
        return program;
    }
}
