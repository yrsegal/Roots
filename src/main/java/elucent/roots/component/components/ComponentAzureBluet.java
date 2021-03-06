package elucent.roots.component.components;

import java.util.ArrayList;
import java.util.Random;

import elucent.roots.PlayerManager;
import elucent.roots.Util;
import elucent.roots.component.ComponentBase;
import elucent.roots.component.ComponentEffect;
import elucent.roots.component.EnumCastType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class ComponentAzureBluet extends ComponentBase{
	Random random = new Random();
	public ComponentAzureBluet(){
		super("azurebluet","Shatter",Blocks.RED_FLOWER,6);	
	}
	
	public void destroyBlockSafe(World world, BlockPos pos, int potency){
		if (world.getBlockState(pos).getBlock().getHarvestLevel(world.getBlockState(pos)) <= 2+potency && world.getBlockState(pos).getBlock().getBlockHardness(world.getBlockState(pos), world, pos) != -1){
			world.destroyBlock(pos, true);
		}
	}
	
	public void attemptAdd(World world, BlockPos pos, ArrayList<BlockPos> positions){
		if (!world.isAirBlock(pos)){
			positions.add(pos);
		}
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){	
			if (caster instanceof EntityPlayer && !world.isRemote){
				BlockPos pos = Util.getRayTrace(world,(EntityPlayer)caster,4+2*(int)size);
				ArrayList<BlockPos> positions = new ArrayList<BlockPos>();
				positions.add(pos);
				int maxPositions = 3+((int)size-3)*3;
				while (positions.size() < maxPositions){
					int s = positions.size();
					for (int j = 0; j < s; j ++){
						if (random.nextFloat() > 0.5){
							positions.add(positions.get(j).north());
						}
						if (random.nextFloat() > 0.5){
							positions.add(positions.get(j).south());
						}
						if (random.nextFloat() > 0.5){
							positions.add(positions.get(j).east());
						}
						if (random.nextFloat() > 0.5){
							positions.add(positions.get(j).west());
						}
						if (random.nextFloat() > 0.5){
							positions.add(positions.get(j).up());
						}
						if (random.nextFloat() > 0.5){
							positions.add(positions.get(j).down());
						}
						if (positions.size() > maxPositions){
							break;
						}
					}
				}
				for (int i = 0; i < positions.size(); i ++){
					destroyBlockSafe(world,positions.get(i),(int)potency);
				}
			}
		}
	}
}
