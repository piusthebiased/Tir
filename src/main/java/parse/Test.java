package parse;

import parse.components.ClassF;
import parse.components.Function;
import parse.components.Parameter;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        ClassF cf = ClassReader.parse("/home/piuslee/IdeaProjects/Tir/src/main/java/demo/Demo1.java");
        ArrayList<Function> functions = cf.getFunctions();
        for (Function f : functions) {
            System.out.print(f.getFunctionModifiers() + f.getFunctionName() + " ");
            ArrayList<Parameter> parameters = f.getParameters();
            for(Parameter p : parameters) {
                System.out.print(p.getName() + " " + p.getType() + " | ");
            }
            System.out.println();
        }
    }
}
