package gui.navigation;

import gui.panel.Panel;
import org.ice1000.jimgui.JImGui;

import java.util.ArrayList;

public class Node {
    private ArrayList<Panel> classes = new ArrayList<>();
    private ArrayList<Node> sections = new ArrayList<>();
    private String packageName;
    public Node(String packageName){
        this.packageName = packageName;
    }

    public void render(JImGui imGui){
        if(imGui.treeNode(packageName)){
            for(Node n : sections){
                n.render(imGui);
            }


        }
    }

    public void addClass(Panel p){
        classes.add(p);
    }

    public void addSection(Node n){
        sections.add(n);
    }

    public ArrayList<Panel> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Panel> classes) {
        this.classes = classes;
    }

    public ArrayList<Node> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Node> sections) {
        this.sections = sections;
    }
}
