package me.fizzify.projectdecimal.module;

import me.fizzify.projectdecimal.Client;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class HUDConfigScreen extends GuiScreen
{

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();

        for (AbstractModule m : ModuleController.modules)
        {
            if (m.isEnabled())
            {
                m.renderDummy(mouseX, mouseY);
            }
       }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);
    }
}
