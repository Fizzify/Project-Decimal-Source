package me.fizzify.projectdecimal.module;

import me.fizzify.projectdecimal.module.mods.FPSModule;

import java.util.ArrayList;
import java.util.List;

public class ModuleController {

    public static List<AbstractModule> modules = new ArrayList();

    public static FPSModule fpsModule = new FPSModule();

    public ModuleController() {

    }

    public void renderModules()
    {
        for(AbstractModule m : modules)
        {
            if(m.isEnabled())
            {
                m.render();
            }
        }
    }
}
