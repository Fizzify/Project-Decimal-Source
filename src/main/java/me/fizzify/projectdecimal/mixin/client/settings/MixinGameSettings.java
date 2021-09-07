package me.fizzify.projectdecimal.mixin.client.settings;

import me.fizzify.projectdecimal.imixin.client.settings.IMixinGameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.apache.commons.lang3.ArrayUtils;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(GameSettings.class)
public class MixinGameSettings implements IMixinGameSettings {

    @Shadow
    public KeyBinding[] keyBindings;
    private KeyBinding keyBindModMenu = new KeyBinding("Editor Menu", Keyboard.KEY_RSHIFT, "Project Decimal");


    @Inject(method = "<init>()V", at = @At(value = "RETURN"))
    private void onInit(CallbackInfo ci) {
        addKeyBindings();
    }

    @Inject(method = "<init>(Lnet/minecraft/client/Minecraft;Ljava/io/File;)V", at = @At("RETURN"))
    private void onInit(Minecraft mcIn, File optionsFileIn, CallbackInfo ci) {
        addKeyBindings();
    }
    private void addKeyBindings() {
        this.keyBindings = ArrayUtils.add(this.keyBindings, this.keyBindModMenu);
    }

    @Override
    public KeyBinding getEditorScreenKey() {
        return this.keyBindModMenu;
    }
}
