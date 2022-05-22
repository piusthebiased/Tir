package parse.components;

import java.util.ArrayList;

public class ClassF extends Component {
    private String className;
    private ArrayList<Function> functions = new ArrayList<>();
    private boolean isStatic;

    public String getClassName() {
        return className;
    }

    public ArrayList<Function> getFunctions() {
        return functions;
    }

    public void addFunction(Function f){
        functions.add(f);
    }

    public void setFunctions(ArrayList<Function> functions) {
        this.functions = functions;
    }

    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
