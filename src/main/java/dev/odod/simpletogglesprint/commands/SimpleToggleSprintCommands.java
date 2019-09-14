package dev.odod.simpletogglesprint.commands;

import dev.odod.simpletogglesprint.SimpleToggleSprint;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class SimpleToggleSprintCommands extends CommandBase {

    private SimpleToggleSprint mod;

    public SimpleToggleSprintCommands(SimpleToggleSprint mod) {
        this.mod = mod;
    }

    @Override
    public String getCommandName() {
        return "togglesprint";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName() + " <toggle | emsg | dmsg | ecolor | dcolor>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            sender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + getCommandUsage(sender)));
        }
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean canCommandSenderUseCommand(final ICommandSender p_71519_1_) {
        return true;
    }
}
