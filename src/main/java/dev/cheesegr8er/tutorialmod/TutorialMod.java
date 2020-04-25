package dev.cheesegr8er.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.cheesegr8er.block.BlockCheese;
import dev.cheesegr8er.item.ItemCheese;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod
{	
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "tutorialmod";
    
    public TutorialMod() {
    	
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    @ObjectHolder(TutorialMod.MOD_ID)
    public static class RegistryEvents {
    	public static final ItemCheese CHEESE = null;
    	public static final BlockCheese CHEESE_BLOCK = null;
    	
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
            
            blockRegistryEvent.getRegistry().register(new BlockCheese().setRegistryName(TutorialMod.MOD_ID, "cheese_block"));
        }
        
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            // register a new item here
            LOGGER.info("HELLO from Register Item");
            
            itemRegistryEvent.getRegistry().register(new ItemCheese().setRegistryName(TutorialMod.MOD_ID, "cheese"));
            itemRegistryEvent.getRegistry().register(new BlockItem(CHEESE_BLOCK, new Properties()).setRegistryName(TutorialMod.MOD_ID, "cheese_block"));
        }
    }
}
