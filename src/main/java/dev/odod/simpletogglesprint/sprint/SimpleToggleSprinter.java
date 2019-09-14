package dev.odod.simpletogglesprint.sprint;

import dev.odod.simpletogglesprint.SimpleToggleSprint;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class SimpleToggleSprinter {

    private Minecraft mc = Minecraft.getMinecraft();
    private SimpleToggleSprint mod;
    private static boolean toggled = true;
    public KeyBinding toggleSprint = new KeyBinding("Toggle Sprint", 29, "key.categories.movement");

    public SimpleToggleSprinter(SimpleToggleSprint mod) {
        this.mod = mod;
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
