package elucent.roots;

import elucent.roots.block.*;
import elucent.roots.entity.EntityAccelerator;
import elucent.roots.entity.EntityNetherInfection;
import elucent.roots.entity.EntitySprite;
import elucent.roots.entity.EntitySpriteling;
import elucent.roots.entity.EntityTileAccelerator;
import elucent.roots.entity.RenderSprite;
import elucent.roots.entity.RenderSpriteling;
import elucent.roots.item.*;
import elucent.roots.model.ModelHolder;
import elucent.roots.model.entity.ModelSpriteling;
import elucent.roots.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RegistryManager {
	public static Item debugWand, runicFocus, rootyStew, healingPoultice, mutagen, growthSalve, runedTablet, druidArmorHead, druidArmorChest, druidArmorLegs, druidArmorBoots, druidRobesHead, druidRobesChest, druidRobesLegs, druidRobesBoots, livingPickaxe, livingSword, livingHoe, livingAxe, livingShovel, dustPetal, pestle, staff, oldRoot, crystalStaff, verdantSprig, infernalStem, dragonsEye,druidKnife,oakTreeBark,spruceTreeBark,birchTreeBark,jungleTreeBark,acaciaTreeBark,darkOakTreeBark,nightshade,blackCurrant,redCurrant,whiteCurrant,elderBerry, engravedSword,itemCharmRestoration,itemCharmEvocation,itemCharmConjuration ,itemCharmIllusion, itemOtherworlLeaf,itemOtherworldsubstance;
	public static Item manaResearchIcon;
	public static Block flareOrchid, radiantDaisy, standingStoneGrower, standingStoneHealer, standingStoneIgniter, standingStoneEntangler, standingStoneAccelerator, standingStoneAesthetic, standingStoneRepulsor, standingStoneVacuum, midnightBloom, mortar, imbuer, altar, druidChalice, standingStoneT1, standingStoneT2, brazier,bridge;
	
	public static Achievement achieveDust, achieveTablet, achieveSpellRose, achieveSpellGrowth, achieveSpellInsanity, achieveMaxModifiers, achieveLotsDamage, achieveTimeStop, achieveAltar, achieveStandingStone, achieveWildwood, achieveShadow, achieveSpellElements, achieveVampire;
	
	public static ToolMaterial engravedMaterial = EnumHelper.addToolMaterial("engraved", 2, 1050, 5F, 8.0F, 5);
	public static ToolMaterial livingMaterial = EnumHelper.addToolMaterial("livingMaterial", 2, 192, 6.0f, 2.0f, 18);
	public static ArmorMaterial druidRobesMaterial = EnumHelper.addArmorMaterial("druidRobes", "roots:druidRobes", 10, new int[]{1,5,6,2}, 20, null, 0);
	public static ArmorMaterial druidArmorMaterial = EnumHelper.addArmorMaterial("druidArmor", "roots:druidArmor", 15, new int[]{2,5,7,3}, 10, null, 1.0f);
	
	public static void init(){
		/**
		 * REGISTERING ITEMS
		 */
		GameRegistry.registerItem(druidKnife = new ItemDruidKnife(), "druidKnife");
		GameRegistry.registerItem(dustPetal = new DustPetal(), "dustPetal");
		GameRegistry.registerItem(debugWand = new ItemDebugWand(), "debugWand");
		GameRegistry.registerItem(pestle = new ItemPestle(), "pestle");
		GameRegistry.registerItem(staff = new ItemStaff(), "staff");
		GameRegistry.registerItem(crystalStaff = new ItemCrystalStaff(), "crystalStaff");
		GameRegistry.registerItem(oldRoot = new RootsItemFood("oldRoot",1,0.1F,false), "oldRoot");
		GameRegistry.registerItem(verdantSprig = new ItemMaterial("verdantSprig"), "verdantSprig");
		GameRegistry.registerItem(infernalStem = new ItemMaterial("infernalStem"), "infernalStem");
		GameRegistry.registerItem(dragonsEye = new ItemDragonsEye("dragonsEye", 2, 0.1F, false), "dragonsEye");
		GameRegistry.registerItem(oakTreeBark = new ItemTreeBark("oakTreeBark"),"oakTreeBark");
		GameRegistry.registerItem(spruceTreeBark = new ItemTreeBark("spruceTreeBark"),"spruceTreeBark");
		GameRegistry.registerItem(birchTreeBark = new ItemTreeBark("birchTreeBark"),"birchTreeBark");
		GameRegistry.registerItem(jungleTreeBark = new ItemTreeBark("jungleTreeBark"),"jungleTreeBark");
		GameRegistry.registerItem(acaciaTreeBark = new ItemTreeBark("acaciaTreeBark"),"acaciaTreeBark");
		GameRegistry.registerItem(darkOakTreeBark = new ItemTreeBark("darkOakTreeBark"),"darkOakTreeBark");
		GameRegistry.registerItem(livingPickaxe = new ItemLivingPickaxe(),"livingPickaxe");
		GameRegistry.registerItem(livingAxe = new ItemLivingAxe(),"livingAxe");
		GameRegistry.registerItem(livingSword = new ItemLivingSword(),"livingSword");
		GameRegistry.registerItem(livingHoe = new ItemLivingHoe(),"livingHoe");
		GameRegistry.registerItem(livingShovel = new ItemLivingShovel(),"livingShovel");
		GameRegistry.registerItem(druidRobesHead = new ItemDruidRobes(2, EntityEquipmentSlot.HEAD),"druidRobesHead");
		GameRegistry.registerItem(druidRobesChest = new ItemDruidRobes(6, EntityEquipmentSlot.CHEST),"druidRobesChest");
		GameRegistry.registerItem(druidRobesLegs = new ItemDruidRobes(5, EntityEquipmentSlot.LEGS),"druidRobesLegs");
		GameRegistry.registerItem(druidRobesBoots = new ItemDruidRobes(1, EntityEquipmentSlot.FEET),"druidRobesBoots");
		GameRegistry.registerItem(druidArmorHead = new ItemDruidArmor(3, EntityEquipmentSlot.HEAD),"druidArmorHead");
		GameRegistry.registerItem(druidArmorChest = new ItemDruidArmor(7, EntityEquipmentSlot.CHEST),"druidArmorChest");
		GameRegistry.registerItem(druidArmorLegs = new ItemDruidArmor(6, EntityEquipmentSlot.LEGS),"druidArmorLegs");
		GameRegistry.registerItem(druidArmorBoots = new ItemDruidArmor(2, EntityEquipmentSlot.FEET),"druidArmorBoots");
		GameRegistry.registerItem(runedTablet = new ItemRunedTablet(),"runedTablet");
		GameRegistry.registerItem(growthSalve = new ItemGrowthSalve(),"growthSalve");
		GameRegistry.registerItem(mutagen = new ItemMutagen(),"mutagen");
		GameRegistry.registerItem(nightshade = new RootsItemFood("nightshade", 2, 0.1F, false).setPotionEffect(new PotionEffect(Potion.getPotionById(19), 320), 1F), "nightshade");
		GameRegistry.registerItem(blackCurrant = new RootsItemFood("blackcurrant", 4, 0.4F, false), "blackcurrant");
		GameRegistry.registerItem(redCurrant = new RootsItemFood("redcurrant", 4, 0.4F, false), "redcurrant");
		GameRegistry.registerItem(whiteCurrant = new RootsItemFood("whitecurrant", 4, 0.4F, false), "whitecurrant");
		GameRegistry.registerItem(elderBerry = new RootsItemFood("elderberry", 2, 0.1F, false), "elderberry");
		GameRegistry.registerItem(healingPoultice = new RootsItemFood("healingPoultice", 0, 0F, false).setAlwaysEdible().setMaxStackSize(8), "healingPoultice"); 
		GameRegistry.registerItem(rootyStew = new ItemRootyStew(), "rootyStew"); 
		GameRegistry.registerItem(runicFocus = new ItemRunicFocus(), "runicFocus"); 
		GameRegistry.registerItem(engravedSword = new ItemEngravedSword(engravedMaterial), "engravedSword");
		GameRegistry.registerItem(manaResearchIcon = new ItemResearchIcon("manaResearchIcon"), "manaResearchIcon");
		GameRegistry.registerItem(itemCharmRestoration = new ItemCharm("charmRestoration"),"charmRestoration");
		GameRegistry.registerItem(itemCharmEvocation = new ItemCharm("charmEvocation"),"charmEvocation");
		GameRegistry.registerItem(itemCharmConjuration = new ItemCharm("charmConjuration"),"charmConjuration");
		GameRegistry.registerItem(itemCharmIllusion = new ItemCharm("charmIllusion"),"charmIllusion");
		GameRegistry.registerItem(itemOtherworlLeaf = new ItemOtherworld("otherworldLeaf"),"otherworldLeaf");
		GameRegistry.registerItem(itemOtherworldsubstance = new ItemOtherworld("otherworldSubstance"),"otherworldSubstance");

		/**
		 * REGISTERING BLOCKS
		 */
		GameRegistry.registerBlock(mortar = new BlockMortar(), "mortar");
		GameRegistry.registerBlock(altar = new BlockAltar(), "altar");
		GameRegistry.registerBlock(brazier = new BlockBrazier(), "brazier");
		GameRegistry.registerBlock(imbuer = new BlockImbuer(), "imbuer");
		//GameRegistry.registerBlock(druidChalice = new BlockDruidChalice(),"druidChalice");
		GameRegistry.registerBlock(standingStoneT1 = new BlockStandingStoneT1(),"standingStoneT1");
		GameRegistry.registerBlock(standingStoneT2 = new BlockStandingStoneT2(),"standingStoneT2");
		GameRegistry.registerBlock(standingStoneVacuum = new BlockStandingStoneVacuum(),"standingStoneVacuum");
		GameRegistry.registerBlock(standingStoneRepulsor = new BlockStandingStoneRepulsor(),"standingStoneRepulsor");
		GameRegistry.registerBlock(standingStoneAccelerator = new BlockStandingStoneAccelerator(),"standingStoneAccelerator");
		GameRegistry.registerBlock(standingStoneAesthetic = new BlockAestheticStandingStone(),"standingStoneAesthetic");
		GameRegistry.registerBlock(standingStoneEntangler = new BlockStandingStoneEntangler(),"standingStoneEntangler");
		GameRegistry.registerBlock(standingStoneIgniter = new BlockStandingStoneIgniter(),"standingStoneIgniter");
		GameRegistry.registerBlock(standingStoneGrower = new BlockStandingStoneGrower(),"standingStoneGrower");
		GameRegistry.registerBlock(standingStoneHealer = new BlockStandingStoneHealer(),"standingStoneHealer");
		GameRegistry.registerBlock(midnightBloom = new BlockMidnightBloom(),"midnightBloom");
		GameRegistry.registerBlock(flareOrchid = new BlockFlareOrchid(),"flareOrchid");
		GameRegistry.registerBlock(radiantDaisy = new BlockRadiantDaisy(),"radiantDaisy");
		GameRegistry.registerBlock(bridge = new BlockBridge(),"bridgeBlock");
		
		/**
		 * REGISTERING TILE ENTITIES
		 */
		GameRegistry.registerTileEntity(TileEntityMortar.class, "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityImbuer.class, "TileEntityImbuer");
		GameRegistry.registerTileEntity(TileEntityAltar.class, "TileEntityAltar");
		GameRegistry.registerTileEntity(TileEntityDruidChalice.class,"TileEntityDruidChalice");
		GameRegistry.registerTileEntity(TileEntityBrazier.class,"TileEntityBrazier");
		GameRegistry.registerTileEntity(TileEntityStandingStoneVacuum.class,"TileEntityStandingStoneVacuum");
		GameRegistry.registerTileEntity(TileEntityStandingStoneRepulsor.class,"TileEntityStandingStoneRepulsor");
		GameRegistry.registerTileEntity(TileEntityStandingStoneAccelerator.class,"TileEntityStandingStoneAccelerator");
		GameRegistry.registerTileEntity(TileEntityAestheticStandingStone.class,"TileEntityAestheticStandingStone");
		GameRegistry.registerTileEntity(TileEntityStandingStoneEntangler.class,"TileEntityStandingStoneEntangler");
		GameRegistry.registerTileEntity(TileEntityStandingStoneGrower.class,"TileEntityStandingStoneGrower");
		GameRegistry.registerTileEntity(TileEntityStandingStoneIgniter.class,"TileEntityStandingStoneIgniter");
		GameRegistry.registerTileEntity(TileEntityStandingStoneHealer.class,"TileEntityStandingStoneHealer");
		GameRegistry.registerTileEntity(TileEnityBridge.class,"TileEntityBridge");
	
		GameRegistry.registerFuelHandler(new FuelManager());
	}
	
	public static void registerEntities(){
		EntityRegistry.registerModEntity(EntityTileAccelerator.class, "tileAccelerator", 0, Roots.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityAccelerator.class, "entityAccelerator", 1, Roots.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntitySpriteling.class, "spriteling", 2, Roots.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntitySprite.class, "sprite", 3, Roots.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityNetherInfection.class, "entityInfection", 4, Roots.instance, 64, 3, true);
	}
	
	public static void registerRecipes(){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.pestle,1),true,new Object[]{"X  "," XX", " XX", 'X', new ItemStack(Blocks.STONE,1,3)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.pestle,1),true,new Object[]{"  X","XX ", "XX ", 'X', new ItemStack(Blocks.STONE,1,3)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.mortar,1),true,new Object[]{"X X","X X", " X ", 'X', "stone"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.imbuer,1),true,new Object[]{"X X", "LSL", 'X', "stickWood", 'L', "logWood", 'S', new ItemStack(Blocks.STONEBRICK,1,3)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.standingStoneT1,1), true, new Object[]{"SBS","BLB","SBS",'S',"stone",'B',new ItemStack(Blocks.STONEBRICK,1),'L',"blockLapis"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.standingStoneT2,1), true, new Object[]{"SNS","NDN","SNS",'S',"stone",'N',"ingotBrickNether",'D',"gemDiamond"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.brazier,1), true, new Object[]{"ISI","ICI","I I",'I',"ingotIron",'S',"string",'C',Items.CAULDRON,'X',"stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.altar,1), true, new Object[]{"BFB","SGS"," C ",'S',"stone",'F',new ItemStack(Blocks.RED_FLOWER,1,0),'B',RegistryManager.verdantSprig,'G',"blockGold",'C',new ItemStack(Blocks.STONEBRICK,1,3)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.druidKnife,1), true, new Object[]{" VV","VPV","SV ",'S',"stickWood",'V',"treeSapling",'P',"plankWood"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(RegistryManager.growthSalve,4), new Object[]{new ItemStack(Items.WHEAT_SEEDS,1),new ItemStack(Blocks.TALLGRASS,1,1),"dustRedstone", new ItemStack(RegistryManager.pestle,1)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(RegistryManager.mutagen,1), new Object[]{new ItemStack(RegistryManager.growthSalve), new ItemStack(RegistryManager.growthSalve), new ItemStack(RegistryManager.growthSalve), new ItemStack(RegistryManager.growthSalve), new ItemStack(Items.NETHER_STAR,1), new ItemStack(Items.NETHER_WART,1), new ItemStack(RegistryManager.pestle,1)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.runedTablet,1), true, new Object[]{" R ","SBS"," S ",'S',Items.WHEAT_SEEDS,'B',"stone",'R',RegistryManager.oldRoot}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(RegistryManager.rootyStew,1), new Object[]{new ItemStack(Items.WHEAT,1), new ItemStack(Items.BOWL,1), new ItemStack(RegistryManager.oldRoot,1)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(RegistryManager.healingPoultice,2), new Object[]{new ItemStack(Items.DYE,1,1), new ItemStack(Items.PAPER,1), new ItemStack(RegistryManager.pestle,1), new ItemStack(RegistryManager.verdantSprig,1)}));
		GameRegistry.addSmelting(RegistryManager.dragonsEye, new ItemStack(Items.ENDER_PEARL), 1F);
	}
	
	public static void registerAchievements(){
		achieveTablet = new Achievement("achievement.tablet","tablet",-2,-1,RegistryManager.runedTablet,null);
		achieveTablet.registerStat();
		achieveDust = new Achievement("achievement.dust","dust",0,0,RegistryManager.dustPetal,achieveTablet);
		achieveDust.registerStat();
		achieveSpellRose = new Achievement("achievement.spellRose","spellRose",0,3,new ItemStack(Blocks.DOUBLE_PLANT,1,4),achieveDust);
		achieveSpellRose.registerStat();
		achieveSpellGrowth = new Achievement("achievement.spellGrowth","spellGrowth",-2,3,new ItemStack(Blocks.DOUBLE_PLANT,1,1),achieveDust);
		achieveSpellGrowth.registerStat();
		achieveSpellInsanity = new Achievement("achievement.spellInsanity","spellInsanity",2,3,new ItemStack(Blocks.RED_FLOWER,1,0),achieveDust);
		achieveSpellInsanity.registerStat();
		achieveMaxModifiers = new Achievement("achievement.maxModifiers","maxModifiers",-4,2,new ItemStack(Items.GLOWSTONE_DUST,1),achieveDust);
		achieveMaxModifiers.registerStat();
		achieveLotsDamage = new Achievement("achievement.lotsDamage","lotsDamage",-6,2,new ItemStack(Items.BLAZE_POWDER,1),achieveMaxModifiers).setSpecial();
		achieveLotsDamage.registerStat();
		achieveTimeStop = new Achievement("achievement.timeStop","timeStop",-5,4,new ItemStack(RegistryManager.midnightBloom,1),achieveMaxModifiers).setSpecial();
		achieveTimeStop.registerStat();
		achieveAltar = new Achievement("achievement.altar","altar",0,-2,new ItemStack(RegistryManager.altar,1),achieveTablet);
		achieveAltar.registerStat();
		achieveSpellElements = new Achievement("achievement.spellElements","spellElements",-2,-4,new ItemStack(RegistryManager.crystalStaff,1),achieveAltar).setSpecial();
		achieveSpellElements.registerStat();
		achieveStandingStone = new Achievement("achievement.standingStone","standingStone",2,-4,new ItemStack(RegistryManager.standingStoneT2,1),achieveAltar);
		achieveStandingStone.registerStat();
		achieveWildwood = new Achievement("achievement.wildwood","wildwood",4,-6,new ItemStack(RegistryManager.druidArmorHead,1),achieveStandingStone);
		achieveWildwood.registerStat();
		achieveShadow = new Achievement("achievement.shadow","shadow",4,-2,new ItemStack(RegistryManager.runicFocus,1),achieveStandingStone);
		achieveShadow.registerStat();
		achieveVampire = new Achievement("achievement.vampire","vampire",6,-4,new ItemStack(Items.GHAST_TEAR,1),achieveStandingStone).setSpecial();
		achieveVampire.registerStat();
		
		AchievementPage.registerAchievementPage(new AchievementPage("Roots", 
				achieveTablet, 
				achieveDust, 
				achieveSpellRose, 
				achieveSpellGrowth, 
				achieveSpellInsanity, 
				achieveMaxModifiers, 
				achieveLotsDamage, 
				achieveTimeStop, 
				achieveAltar, 
				achieveSpellElements, 
				achieveStandingStone, 
				achieveWildwood, 
				achieveShadow, 
				achieveVampire
				));
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemRenderers(){
		/**
		 * REGISTERING TILE ENTITY RENDERERS
		 */
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMortar.class, new TileEntityMortarRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new TileEntityAltarRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityImbuer.class, new TileEntityImbuerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBrazier.class, new TileEntityBrazierRenderer());
		
		/**
		 * REGISTERING ITEM MODELS
		 */
		((ItemDruidKnife)druidKnife).initModel();
		((DustPetal)dustPetal).initModel();
		((ItemDebugWand)debugWand).initModel();
		((ItemPestle)pestle).initModel();
		((ItemStaff)staff).initModel();
		((ItemCrystalStaff)crystalStaff).initModel();
		((RootsItemFood)oldRoot).initModel();
		((ItemMaterial)verdantSprig).initModel();
		((ItemMaterial)infernalStem).initModel();
		((ItemDragonsEye)dragonsEye).initModel();
		((ItemTreeBark)oakTreeBark).initModel();
		((ItemTreeBark)spruceTreeBark).initModel();
		((ItemTreeBark)birchTreeBark).initModel();
		((ItemTreeBark)jungleTreeBark).initModel();
		((ItemTreeBark)acaciaTreeBark).initModel();
		((ItemTreeBark)darkOakTreeBark).initModel();
		((ItemLivingPickaxe)livingPickaxe).initModel();
		((ItemLivingAxe)livingAxe).initModel();
		((ItemLivingSword)livingSword).initModel();
		((ItemLivingHoe)livingHoe).initModel();
		((ItemLivingShovel)livingShovel).initModel();
		((ItemDruidRobes)druidRobesHead).initModel();
		((ItemDruidRobes)druidRobesChest).initModel();
		((ItemDruidRobes)druidRobesLegs).initModel();
		((ItemDruidRobes)druidRobesBoots).initModel();
		((ItemDruidArmor)druidArmorHead).initModel();
		((ItemDruidArmor)druidArmorChest).initModel();
		((ItemDruidArmor)druidArmorLegs).initModel();
		((ItemDruidArmor)druidArmorBoots).initModel();
		((ItemRunedTablet)runedTablet).initModel();
		((ItemGrowthSalve)growthSalve).initModel();
		((ItemMutagen)mutagen).initModel();
		((RootsItemFood)nightshade).initModel();
		((RootsItemFood)blackCurrant).initModel();
		((RootsItemFood)redCurrant).initModel();
		((RootsItemFood)whiteCurrant).initModel();
		((RootsItemFood)elderBerry).initModel();
		((RootsItemFood)healingPoultice).initModel();
		((ItemRootyStew)rootyStew).initModel();
		((ItemRunicFocus)runicFocus).initModel();
		((ItemEngravedSword)engravedSword).initModel();
		((ItemResearchIcon)manaResearchIcon).initModel();

		/**Charms**/
		((ItemCharm)itemCharmRestoration).initModel();
		((ItemCharm)itemCharmConjuration).initModel();
		((ItemCharm)itemCharmEvocation).initModel();
		((ItemCharm)itemCharmIllusion).initModel();
		
		//((BlockDruidChalice)druidChalice).initModel();
		((BlockMortar)mortar).initModel();
		((BlockAltar)altar).initModel();
		((BlockBrazier)brazier).initModel();
		((BlockImbuer)imbuer).initModel();
		((BlockStandingStoneT1)standingStoneT1).initModel();
		((BlockStandingStoneT2)standingStoneT2).initModel();
		((BlockStandingStoneVacuum)standingStoneVacuum).initModel();
		((BlockStandingStoneRepulsor)standingStoneRepulsor).initModel();
		((BlockStandingStoneAccelerator)standingStoneAccelerator).initModel();
		((BlockAestheticStandingStone)standingStoneAesthetic).initModel();
		((BlockStandingStoneEntangler)standingStoneEntangler).initModel();
		((BlockStandingStoneGrower)standingStoneGrower).initModel();
		((BlockStandingStoneIgniter)standingStoneIgniter).initModel();
		((BlockStandingStoneHealer)standingStoneHealer).initModel();
		((BlockMidnightBloom)midnightBloom).initModel();
		((BlockFlareOrchid)flareOrchid).initModel();
		((BlockRadiantDaisy)radiantDaisy).initModel();
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerColorHandlers(){
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemDebugWand.ColorHandler(), debugWand);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemStaff.ColorHandler(), staff);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemCrystalStaff.ColorHandler(), crystalStaff);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerEntityRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySpriteling.class, new RenderSpriteling(Minecraft.getMinecraft().getRenderManager(),ModelHolder.entityModels.get("spriteling"),0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySprite.class, new RenderSprite(Minecraft.getMinecraft().getRenderManager(),ModelHolder.entityModels.get("sprite"),0.5f));
	}
}
