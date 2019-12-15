clean:
	find interpreter -type f -name "*.class" -delete


compile:
	javac interpreter/bytecode/*.java
	javac interpreter/Interpreter.java

run:
	java interpreter.Interpreter sample_files/fudge.x.cod

fudge:
	javac interpreter/bytecode/*.java
	javac interpreter/Interpreter.java
	java interpreter.Interpreter sample_files/fudge.x.cod

halt:
	javac interpreter/bytecode/*.java
	javac interpreter/Interpreter.java
	java interpreter.Interpreter sample_files/halt.x.cod

lit:
	javac interpreter/bytecode/*.java
	javac interpreter/Interpreter.java
	java interpreter.Interpreter sample_files/simpleLit.x.cod

res:
	javac interpreter/bytecode/*.java
	javac interpreter/Interpreter.java
	java interpreter.Interpreter sample_files/resolve.x.cod

ass:
	javac interpreter/bytecode/*.java
	javac interpreter/Interpreter.java
	java interpreter.Interpreter sample_files/assignment.cod

noDump:
	javac interpreter/bytecode/*.java
	javac interpreter/Interpreter.java
	java interpreter.Interpreter sample_files/noDump.cod

Dump:
	javac interpreter/bytecode/*.java
	javac interpreter/Interpreter.java
	java interpreter.Interpreter sample_files/assignmentALLDUMP.cod
