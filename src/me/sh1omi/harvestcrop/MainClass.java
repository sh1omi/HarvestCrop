package me.sh1omi.harvestcrop;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;



public class MainClass extends JavaPlugin implements Listener{
	
	public static MainClass plugin;
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info("[ " + pdfFile.getName() + " ] Version: " +  pdfFile.getVersion() + " Has been disabled");
		
	}
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		getServer().getPluginManager().registerEvents(this, this);
		this.logger.info("[ " + pdfFile.getName() + " ] Version: " +  pdfFile.getVersion() + " Has been enabled");
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
	if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
		if(event.getClickedBlock().getType() == Material.CROPS && event.getClickedBlock().getData() == 7)
		{
			event.getClickedBlock().breakNaturally();
			event.getClickedBlock().setType(Material.CROPS);
			event.getClickedBlock().setData((byte)0);
		}
		else if(event.getClickedBlock().getType() == Material.CARROT && event.getClickedBlock().getData() == 7)
		{
			event.getClickedBlock().breakNaturally();
			event.getClickedBlock().setType(Material.CARROT);
			event.getClickedBlock().setData((byte)0);
		}
		else if(event.getClickedBlock().getType() == Material.POTATO && event.getClickedBlock().getData() == 7)
		{
			event.getClickedBlock().breakNaturally();
			event.getClickedBlock().setType(Material.POTATO);
			event.getClickedBlock().setData((byte)0);
		}
		else if(event.getClickedBlock().getType() == Material.COCOA && event.getClickedBlock().getData() > 7)
		{
			int data = event.getClickedBlock().getData()-8;
			event.getClickedBlock().breakNaturally();
			event.getClickedBlock().setType(Material.COCOA);
			event.getClickedBlock().setData((byte)data);
		}
		else if(event.getClickedBlock().getType() == Material.NETHER_WARTS && event.getClickedBlock().getData() == 3)
		{
			event.getClickedBlock().breakNaturally();
			event.getClickedBlock().setType(Material.NETHER_WARTS);
			event.getClickedBlock().setData((byte)0);
		}	
	}
	
	public static String replaceColors(String string){
		
		return string.replaceAll("(?i)&([a-k0-9])", "\u00A7$1");
		}
	
}
