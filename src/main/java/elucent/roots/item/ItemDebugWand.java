package elucent.roots.item;

import elucent.roots.Roots;
import elucent.roots.Util;
import elucent.roots.entity.EntityGreaterSprite;
import elucent.roots.entity.EntitySprite;
import elucent.roots.entity.EntitySpriteling;
import elucent.roots.render.ClientTickHandler;
import elucent.roots.render.glow.GlowingOverlayHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.awt.*;

public class ItemDebugWand extends Item implements IGlowOverlayable {
	public ItemDebugWand(){
		super();
		setUnlocalizedName("debugWand");
		addPropertyOverride(new ResourceLocation(Roots.MODID, "overlay"), GlowingOverlayHelper.OVERLAY_OVERRIDE);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if (!world.isRemote){
			EntityGreaterSprite spriteling = new EntityGreaterSprite(world);
			spriteling.setPosition(pos.getX()+0.5,pos.getY()+1.5,pos.getZ()+0.5);
			spriteling.onInitialSpawn(world.getDifficultyForLocation(pos), null);
			world.spawnEntityInWorld(spriteling);
		}
		return EnumActionResult.SUCCESS;
	}

	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}

	@SideOnly(Side.CLIENT)
	public static class ColorHandler implements IItemColor {
		@Override
		public int getColorFromItemstack(@Nonnull ItemStack stack, int tintIndex) {
			float time = ClientTickHandler.total;
			return tintIndex == 0 ? 0xFFFFFF : Color.HSBtoRGB(time * 0.005F, 1.0F, 1.0F);
		}
	}
}
