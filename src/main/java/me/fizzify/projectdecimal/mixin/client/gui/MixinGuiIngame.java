package me.fizzify.projectdecimal.mixin.client.gui;

import me.fizzify.projectdecimal.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin( GuiIngame.class )
public abstract class MixinGuiIngame extends Gui {

    @Inject(method = "renderGameOverlay", at = @At("RETURN"))
    private void runTick (CallbackInfo info)
    {
        Client.INSTANCE.moduleController.renderModules();
    }

}
