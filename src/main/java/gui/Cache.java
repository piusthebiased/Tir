package gui;

import org.ice1000.jimgui.JImDrawList;
import org.ice1000.jimgui.JImFont;


public class Cache {
    //display font
    private JImFont font12;
    private JImFont font18;
    private JImFont font24;
    private JImFont font30;
    private JImFont font36;
    private JImFont font42;

    private JImFont hacky14;

    private JImFont defaultFont;
    private JImDrawList drawList;
    private int windowPresets;
    private String url;

    public JImFont getHacky14() {
        return hacky14;
    }

    public void setHacky14(JImFont hacky14) {
        this.hacky14 = hacky14;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Cache(){

    }

    // * font vars
    public void setFont12(JImFont font12) {
        this.font12 = font12;
    }

    public void setFont18(JImFont font18) {
        this.font18 = font18;
    }

    public void setFont24(JImFont font24) {
        this.font24 = font24;
    }

    public void setFont30(JImFont font30) {
        this.font30 = font30;
    }

    public void setFont36(JImFont font36) {
        this.font36 = font36;
    }

    public void setFont42(JImFont font42) {
        this.font42 = font42;
    }

    public void setHacky16(JImFont hacky14) {
        this.hacky14 = hacky14;
    }

    public void setDefaultFont(JImFont defaultFont){
        this.defaultFont = defaultFont;
    }

    public void setWindowPresets(int windowPresets) {
        this.windowPresets = windowPresets;
    }

    public void setDrawList(JImDrawList drawList) {
        this.drawList = drawList;
    }

    public JImFont getFont12() {
        return font12;
    }

    public JImFont getFont18() {
        return font18;
    }

    public JImFont getFont24() {
        return font24;
    }

    public JImFont getFont30() {
        return font30;
    }

    public JImFont getFont36() {
        return font36;
    }

    public JImFont getFont42() {
        return font42;
    }

    public JImFont getHacky16() {
        return hacky14;
    }

    public JImFont getDefaultFont() {
        return defaultFont;
    }

    public int getWindowPresets() {
        return windowPresets;
    }

    public JImDrawList getDrawList() {
        return drawList;
    }
}
