import gui.Cache;
import gui.panel.Panel;
import gui.GuiConfig;
import org.ice1000.jimgui.JImGui;
import org.ice1000.jimgui.util.JniLoader;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        JniLoader.load();
        try (JImGui imGui = new JImGui()) {
            Cache cache = GuiConfig.load(imGui);
            while (!imGui.windowShouldClose()) {
                //initialization stuff for each frame.
                imGui.initNewFrame();
                GuiConfig.render(imGui, cache);

                //gui stuff
                String path = "/home/piuslee/IdeaProjects/Tir/src/main/java/demo/Demo1.java";
                cache.setUrl("https://6d47-35-236-214-24.ngrok.io/");
                Panel.render(imGui, cache, path);

                //end
                imGui.render();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
