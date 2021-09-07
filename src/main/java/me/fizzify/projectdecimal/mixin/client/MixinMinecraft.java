package me.fizzify.projectdecimal.mixin.client;

import me.fizzify.projectdecimal.Client;
import me.fizzify.projectdecimal.event.tick.EventTick;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin ( Minecraft.class )
public class MixinMinecraft {

    @ModifyArg(method = { "createDisplay" }, at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V", remap = false))
    private String setDisplayTitle(final String title)
    {
        return "Loading Project 1.8.9... " + (Client.Constants.BETA ? "BETA 1.0" : "");
    }

    @Inject(method = "startGame", at = @At("RETURN"))
    public void onStart(CallbackInfo ci) {
        Client.INSTANCE.onStart();
    }

    @Inject(method = {"shutdownMinecraftApplet"}, at = {@At("HEAD")})
    private void onShutdown(final CallbackInfo ci)
    {
        Client.INSTANCE.onShutdown();
    }

    @Inject(method = "runTick", at = @At("HEAD"))
    public void onTick(CallbackInfo ci) {
        new EventTick().call();
    }

}
