package parse.components;

public class Parameter {
    private String type;
    private String name;

    public Parameter(){}
    public Parameter(String type, String name){
        this.type = type;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
