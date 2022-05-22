package parse.components;

import java.util.ArrayList;

public class Function {
    private ArrayList<Parameter> parameters = new ArrayList<>();
    private String functionName;
    private String functionModifiers;
    private String comment = "";
    private int[] linenum;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int[] getLinenum() {
        return linenum;
    }

    public void setLinenum(int[] linenum) {
        this.linenum = linenum;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void addParameter(Parameter p){
        parameters.add(p);
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionModifiers() {
        return functionModifiers;
    }

    public void setFunctionModifiers(String functionModifiers) {
        this.functionModifiers = functionModifiers;
    }
}
