package gui;

import org.ice1000.jimgui.JImDrawList;
import org.ice1000.jimgui.JImGui;
import org.ice1000.jimgui.JImVec4;

public class JImGuiExtra {
    public static void lineBreak(JImGui imGui, float posy){
        JImDrawList dl = imGui.findWindowDrawList();
        float cx = JImGui.getWindowPosX();
        float cy = JImGui.getWindowPosY();
        float w = JImGui.getWindowWidth();
        float h = JImGui.getWindowHeight();
        JImVec4 white = JImVec4.fromHSV(276/360.0f, 0.02f, 0.98f);

        dl.addLine(cx + 20, cy + posy, cx + w - 20, cy + posy, white.toU32(), 2f);
    }
}
