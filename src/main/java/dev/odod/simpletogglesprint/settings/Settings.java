package dev.odod.simpletogglesprint.settings;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class Settings {

    private File cfgFile = new File(Minecraft.getMinecraft().mcDataDir, "config/simpleToggleSprint.cfg");
    private boolean toggleSprintEnabled = true;
    private String enablemsg = "Togglesprint enabled.";
    private String enablecolor = "BLUE";
    private String disablemsg = "Togglesprint disabled.";
    private String disablecolor = "RED";


    public boolean isEnabled() {
        return toggleSprintEnabled;
    }

    public void toggleSprintGlobalToggle() {
        toggleSprintEnabled = !toggleSprintEnabled;
    }



    public void cfgSave() {
        Configuration cfg = new Configuration(cfgFile);
        cfgUpdate(cfg, false);
        cfg.save();
    }

    public void cfgLoad() {
        Configuration cfg = new Configuration(cfgFile);
        cfg.load();
        cfgUpdate(cfg, true);
    }

    private void cfgUpdate(Configuration config, boolean load) {
        Property t = config.get("Global", "Global Toggle", true);
        Property emsg = config.get("Enable", "Message when Enabled", "Togglesprint enabled.");
        Property ecolor = config.get("Enable", "Color when Enabled", "BLUE");
        Property dmsg = config.get("Disable", "Message when Disabled", "Togglesprint disabled.");
        Property dcolor = config.get("Disable", "Color when Disabled", "RED");

        if(load) {
            toggleSprintEnabled = t.getBoolean();
            enablemsg = emsg.getDefault();
            enablecolor = ecolor.getDefault();
            disablemsg = dmsg.getDefault();
            disablecolor = dcolor.getDefault();
        } else {
            t.set(toggleSprintEnabled);
            emsg.set(enablemsg);
            ecolor.set(enablecolor);
            dmsg.set(disablemsg);
            dcolor.set(disablecolor);
        }
    }
}
