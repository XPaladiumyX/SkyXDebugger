package skyxnetwork.skyXDebugger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyXDebugger extends JavaPlugin implements Listener {

    private boolean enabled = false;

    @Override
    public void onEnable() {
        getLogger().info("SkyXDebugger loaded! Use /skyxdebugger enable to start.");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("§cUsage: /skyxdebugger <enable|disable>");
            return true;
        }

        if (args[0].equalsIgnoreCase("enable")) {
            enabled = true;
            sender.sendMessage("§aSkyXDebugger is now enabled!");
        } else if (args[0].equalsIgnoreCase("disable")) {
            enabled = false;
            sender.sendMessage("§cSkyXDebugger is now disabled!");
        } else {
            sender.sendMessage("§cUsage: /skyxdebugger <enable|disable>");
        }
        return true;
    }

    @EventHandler
    public void onAnvilClick(InventoryClickEvent event) {
        if (!enabled) return; // ne fait rien si désactivé
        if (event.getInventory().getType() != InventoryType.ANVIL) return;

        ItemStack result = event.getInventory().getItem(2); // slot de sortie
        ItemStack left = event.getInventory().getItem(0);
        ItemStack right = event.getInventory().getItem(1);

        if (left == null || right == null) return;

        Bukkit.getScheduler().runTaskLater(this, () -> {
            ItemStack checkResult = event.getInventory().getItem(2);
            if (checkResult == null || checkResult.getType() == Material.AIR) {
                getLogger().info("§c[SkyXDebugger] Output disappeared for player " + event.getWhoClicked().getName());

                // On log le stacktrace pour voir quel plugin pourrait cancel
                Exception ex = new Exception();
                for (StackTraceElement ste : ex.getStackTrace()) {
                    String line = ste.toString();
                    if (line.contains("org.bukkit.plugin")) {
                        getLogger().info(" -> " + line);
                    }
                }
            }
        }, 1L); // on delay d’un tick pour laisser le serveur appliquer les changements
    }
}
