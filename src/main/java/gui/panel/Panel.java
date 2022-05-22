package gui.panel;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import gui.Cache;
import gui.JImGuiExtra;
import io.jrest.HttpMethod;
import io.jrest.JRest;
import io.jrest.RequestEntity;
import io.jrest.ResponseEntity;
import org.ice1000.jimgui.JImDrawList;
import org.ice1000.jimgui.JImGui;
import org.ice1000.jimgui.JImVec4;
import parse.ClassReader;
import parse.components.ClassF;
import parse.components.Function;
import parse.components.Parameter;

import java.io.IOException;

public class Panel {
    private static ClassF c;

    public Panel(ClassF panel) {
        this.c = panel;
    }

    //change to non static after
    public static void render(JImGui imGui, Cache cache, String path) throws IOException {
        c = ClassReader.parse(path);
        if(imGui.button("Generate Comments")){
            for(Function f : c.getFunctions()) {
                String code = f.getComment();

                System.out.println(code);
//                JsonObject body = new JsonObject();
//                body.addProperty("code", code);
//                RequestEntity<JsonObject> request = new RequestEntity<>(HttpMethod.POST, body);
//
//                request.exchangeAsync(cache.getUrl(), String.class, (response)->{
//                    f.setComment(response.getBody());
//                });

            }
        }

        if(imGui.begin("Panel")){
            //define colors
            JImVec4 pink = JImVec4.fromHSV(306/360.0f, 1.0f, 0.804f);
            JImVec4 yellow = JImVec4.fromHSV(49/360.0f, 0.463f, 0.804f);
            JImVec4 blue = JImVec4.fromHSV(215/360.0f, 0.742f, 0.898f);
            JImVec4 orange = JImVec4.fromHSV(30/360.0f, 0.492f, 0.78f);
            JImVec4 grey = JImVec4.fromHSV(113/360.0f, 0.061f, 0.514f);
            JImVec4 white = JImVec4.fromHSV(276/360.0f, 0.02f, 0.98f);

            //init drawlist
            JImDrawList dl = imGui.findWindowDrawList();
            float cx = JImGui.getWindowPosX();
            float cy = JImGui.getWindowPosY();
            float w = JImGui.getWindowWidth();
            float h = JImGui.getWindowHeight();

            //start draw
            JImGui.popFont();
            imGui.pushFont(cache.getFont36());
            assert dl != null;
            float offset = 30;
            dl.addText(offset + cx, 40 + cy, pink.toU32(), "class");
            dl.addText(offset + 95 + cx, 40 + cy, yellow.toU32(), c.getClassName());
            JImGuiExtra.lineBreak(imGui, 87);
            cx = JImGui.getWindowPosX();
            cy = JImGui.getWindowPosY();

            int a = 0;
            for(Function f : c.getFunctions()){
                if(imGui.beginChild(a)){

                    float yc = 100*a;
                    //function sect
                    JImGui.popFont();
                    imGui.pushFont(cache.getFont24());
                    offset += 3;
                    dl.addText(offset + cx, 100 + cy + yc, pink.toU32(), f.getFunctionModifiers());
                    dl.addText(offset + 208 + cx, 100 + cy + yc, blue.toU32(), f.getFunctionName());

                    //params of above
                    JImGui.popFont();
                    imGui.pushFont(cache.getFont18());
                    offset += 15;
                    dl.addText(offset + cx, 130 + cy + yc, grey.toU32(), "params: ");

                    StringBuilder buffer = new StringBuilder("(");
                    for(Parameter p : f.getParameters()){
                        buffer.append(p.getType()).append(" ").append(p.getName()).append(", ");
                    }
                    buffer = new StringBuilder(buffer.substring(0, buffer.length() - 2));
                    buffer.append(")");

                    dl.addText(offset + 90 + cx, 130 + cy + yc, white.toU32(), buffer.toString());

                    //comments
                    dl.addText(offset + cx, 155 + cy + yc, grey.toU32(), "comments: ");
                    dl.addText(cache.getFont18(), 18f, cx + offset + 90, 155f + cy + yc, white.toU32(), f.getComment(), w - 180);

                    offset -= 18;
                    JImGui.endChild();
                }
                a++;
            }

            //end child
            JImGui.end();
        }
    }
}
