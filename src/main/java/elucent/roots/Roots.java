package elucent.roots;

import elucent.roots.capability.mana.IManaCapability;
import elucent.roots.command.RootsCommand;
import elucent.roots.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Roots.MODID, name = Roots.NAME, version = Roots.VERSION, useMetadata = true)
public class Roots
{
	public static final String NAME = "Roots";
    public static final String MODID = "roots";
    public static final String VERSION = "0.110";
    
    public static CreativeTabs tab = new CreativeTabs("roots") {
    	@Override
    	public String getTabLabel(){
    		return "roots";
    	}
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return RegistryManager.dustPetal;
		}
	};
    
    @SidedProxy(clientSide = "elucent.roots.proxy.ClientProxy", serverSide = "elucent.roots.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @Instance("roots")
    public static Roots instance;

    public static Logger LOGGER = LogManager.getLogger(MODID);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	ConfigManager.load(event);
    	MinecraftForge.EVENT_BUS.register(new RootsCapabilityManager());
    	MinecraftForge.EVENT_BUS.register(new EventManager());
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	proxy.postInit(event);
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event){
      event.registerServerCommand(new RootsCommand());
    }
}
