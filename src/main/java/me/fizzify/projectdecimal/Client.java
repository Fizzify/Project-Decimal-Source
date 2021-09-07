package me.fizzify.projectdecimal;

import me.fizzify.projectdecimal.event.EventManager;
import me.fizzify.projectdecimal.event.EventTarget;
import me.fizzify.projectdecimal.event.tick.EventTick;
import me.fizzify.projectdecimal.imixin.client.settings.IMixinGameSettings;
import me.fizzify.projectdecimal.module.AbstractModule;
import me.fizzify.projectdecimal.module.HUDConfigScreen;
import me.fizzify.projectdecimal.module.ModuleController;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public class Client {

    public static final Client INSTANCE;
    public String name = "Project Decimal | 1.8.9 " + (Constants.BETA ? "BETA 1.0" : "");
    public Minecraft mc = Minecraft.getMinecraft();

    public EventManager eventManager;
    public ModuleController moduleController;

    public void onStart() {
        eventManager = new EventManager();
        moduleController = new ModuleController();
        Display.setTitle(name);
        eventManager.register(this);
    }

    public void onShutdown() {
        System.out.println("Shutting down Project Decimal!");
        eventManager.unregister(this);
    }

    @EventTarget
    public void onTick(EventTick e) {
        IMixinGameSettings gs = (IMixinGameSettings) mc.gameSettings;
        if (mc.currentScreen == null && gs.getEditorScreenKey().isPressed()) {
            mc.displayGuiScreen(new HUDConfigScreen());
        }
    }

    static {
        INSTANCE = new Client();
    }

    public interface Constants {
        boolean BETA = true;
    }

}
