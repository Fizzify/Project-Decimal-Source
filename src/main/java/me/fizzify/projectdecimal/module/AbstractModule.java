package me.fizzify.projectdecimal.module;

import me.fizzify.projectdecimal.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public abstract class AbstractModule {
    public Minecraft mc = Minecraft.getMinecraft();
    public FontRenderer fr = mc.fontRendererObj;

    public Type type;
    public String name;
    public String description;
    public boolean enabled;
    public DraggableComponent drag;

    public int x, y;

    public AbstractModule(String name, String description, Type type, int defaultX, int defaultY)
    {
        this.name = name;
        this.description = description;
        this.type = type;
        this.x = defaultX;
        this.y = defaultY;
        this.enabled = true;

        drag = new DraggableComponent(this.x, this.y, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB());
        Client.INSTANCE.moduleController.modules.add(this);
    }


    public int getWidth()
    {
        return 0;
    }

    public int getHeight()
    {
        return 0;
    }

    /*
    * Drawing part.
     */
    public void render()
    {
        // Renders what you put here.
    }

    public void renderDummy(int mouseX, int mouseY)
    {
        boolean hovered = (mouseX >= getX() && mouseX <= getX() + getWidth() && mouseY >= getY() && mouseY <= getY() + getHeight());
        drag.draw(mouseX, mouseY);
    }

    public int getX()
    {
        return drag.getxPosition();
    }

    public int getY()
    {
        return drag.getyPosition();
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public void toggle()
    {
        this.setEnabled(!this.enabled);
    }

    public boolean isEnabled()
    {
        return this.enabled;
    }

    public enum Type {
        VISUAL,
        MISC,
        WORLD,
        COSMETIC
    }
}
