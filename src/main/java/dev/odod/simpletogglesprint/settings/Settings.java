package dev.odod.simpletogglesprint.settings;

import net.minecraft.client.Minecraft;

import java.io.File;

public class Settings {

    private File cfgFile = new File(Minecraft.getMinecraft().mcDataDir, "config/simpleToggleSprint.cfg");
    private boolean toggleSprintEnabled = true;

    public boolean isEnabled() {
        return toggleSprintEnabled;
    }
}
