package dev.odod.simpletogglesprint;

import dev.odod.simpletogglesprint.commands.SimpleToggleSprintCommands;
import dev.odod.simpletogglesprint.settings.Settings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = SimpleToggleSprint.MODID, version = SimpleToggleSprint.VERSION)
public class SimpleToggleSprint {
    public static final String MODID = "simpletogglesprint";
    public static final String VERSION = "1.0.1";

    private KeyBinding toggleSprint;
    private Minecraft mc;
    private static boolean toggled = true;
    private Settings settings = new Settings();

    @EventHandler
    public void init(FMLInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new SimpleToggleSprintCommands(this));


        toggleSprint = new KeyBinding("Toggle Sprint", 29, "key.categories.movement");
        ClientRegistry.registerKeyBinding(toggleSprint);
        settings.cfgLoad();

        mc = Minecraft.getMinecraft();
    }


    public Settings getSettings() {
        return settings;
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e) {
        if (toggleSprint.isPressed()) {
            if (toggled) {
                mc.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Togglesprint disabled."));
            } else {
                mc.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE + "Togglesprint enabled."));
            }

            toggled = !toggled;

        }

        if (toggled) {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
        } else {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
        }
    }
}