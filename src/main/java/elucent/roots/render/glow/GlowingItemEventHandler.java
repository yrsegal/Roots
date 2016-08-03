package elucent.roots.render.glow;

import com.google.common.base.Objects;
import elucent.roots.item.IGlowOverlayable;
import elucent.roots.reflection.RootsClientMethodHandles;
import elucent.roots.render.ShaderHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GlowingItemEventHandler {
    private static final GlowingItemEventHandler INSTANCE = new GlowingItemEventHandler();

    public static void init() {
        MinecraftForge.EVENT_BUS.register(INSTANCE);
    }

    @SubscribeEvent(receiveCanceled = true)
    public void onRenderHand(RenderHandEvent e) {
        Minecraft mc = Minecraft.getMinecraft();
        Entity entity = mc.getRenderViewEntity();
        boolean flag = entity instanceof EntityLivingBase && ((EntityLivingBase) entity).isPlayerSleeping();

        EntityRenderer render = mc.entityRenderer;

        ItemStack stackMain = RootsClientMethodHandles.getStackMainHand(render.itemRenderer);
        ItemStack stackOff = RootsClientMethodHandles.getStackOffHand(render.itemRenderer);
        if ((stackMain == null || !(stackMain.getItem() instanceof IGlowOverlayable)) &&
                (stackOff == null || !(stackOff.getItem() instanceof IGlowOverlayable)))
            return;

        if (mc.playerController != null && mc.gameSettings.thirdPersonView == 0 && !flag && !mc.gameSettings.hideGUI && !mc.playerController.isSpectator()) {
            GlStateManager.pushMatrix();
            render.enableLightmap();
            render(e.getPartialTicks(), false, !e.isCanceled());
            render.disableLightmap();
            GlStateManager.popMatrix();

            render(e.getPartialTicks(), true, false);
        }

        e.setCanceled(true);
    }

    private void render(float partialTicks, boolean overlay, boolean renderNonOverlays) {
        ItemRenderer render = Minecraft.getMinecraft().getItemRenderer();

        AbstractClientPlayer abstractclientplayer = Minecraft.getMinecraft().thePlayer;
        float f = abstractclientplayer.getSwingProgress(partialTicks);
        EnumHand enumhand = Objects.firstNonNull(abstractclientplayer.swingingHand, EnumHand.MAIN_HAND);
        float f1 = abstractclientplayer.prevRotationPitch + (abstractclientplayer.rotationPitch - abstractclientplayer.prevRotationPitch) * partialTicks;
        float f2 = abstractclientplayer.prevRotationYaw + (abstractclientplayer.rotationYaw - abstractclientplayer.prevRotationYaw) * partialTicks;
        boolean flag = true;
        boolean flag1 = true;

        if (abstractclientplayer.isHandActive()) {
            ItemStack itemstack = abstractclientplayer.getActiveItemStack();

            if (itemstack != null && itemstack.getItem() == Items.BOW) {
                EnumHand enumhand1 = abstractclientplayer.getActiveHand();
                flag = enumhand1 == EnumHand.MAIN_HAND;
                flag1 = !flag;
            }
        }

        rotateAroundXAndY(f1, f2);
        setLightmap();
        rotateArm(partialTicks);
        GlStateManager.enableRescaleNormal();

        float prevProgMain = RootsClientMethodHandles.getPrevEquipMainHand(render);
        float prevProgOff = RootsClientMethodHandles.getPrevEquipOffHand(render);
        float progMain = RootsClientMethodHandles.getEquipMainHand(render);
        float progOff = RootsClientMethodHandles.getEquipOffHand(render);
        ItemStack stackMain = RootsClientMethodHandles.getStackMainHand(render);
        ItemStack stackOff = RootsClientMethodHandles.getStackOffHand(render);

        if (flag && stackMain != null && (stackMain.getItem() instanceof IGlowOverlayable || !overlay && renderNonOverlays)) {
            if (!overlay || !(stackMain.getItem() instanceof IGlowOverlayable) || ((IGlowOverlayable) stackMain.getItem()).useOverlay(stackMain)) {
                if (overlay && stackMain.getItem() instanceof IGlowOverlayable) {
                    IGlowOverlayable item = (IGlowOverlayable) stackMain.getItem();
                    if (item.useShader(stackMain))
                        ShaderHandler.useShader(ShaderHandler.rawColor);
                    if (item.disableLighting(stackMain))
                        GlStateManager.disableLighting();
                }

                float f3 = enumhand == EnumHand.MAIN_HAND ? f : 0.0F;
                float f5 = 1.0F - (prevProgMain + (progMain - prevProgMain) * partialTicks);
                render.renderItemInFirstPerson(abstractclientplayer, partialTicks, f1, EnumHand.MAIN_HAND, f3, overlay ? GlowingOverlayHelper.overlayStack(stackMain) : stackMain, f5);

                if (overlay && stackMain.getItem() instanceof IGlowOverlayable) {
                    IGlowOverlayable item = (IGlowOverlayable) stackMain.getItem();
                    if (item.useShader(stackMain))
                        ShaderHandler.releaseShader();
                    if (item.disableLighting(stackMain))
                        GlStateManager.enableLighting();
                }
            }
        }

        if (flag1 && stackOff != null && (stackOff.getItem() instanceof IGlowOverlayable || !overlay && renderNonOverlays)) {
            if (!overlay || !(stackOff.getItem() instanceof IGlowOverlayable) || ((IGlowOverlayable) stackOff.getItem()).useOverlay(stackOff)) {
                if (overlay && stackOff.getItem() instanceof IGlowOverlayable) {
                    IGlowOverlayable item = (IGlowOverlayable) stackOff.getItem();
                    if (item.useShader(stackOff))
                        ShaderHandler.useShader(ShaderHandler.rawColor);
                    if (item.disableLighting(stackOff))
                        GlStateManager.disableLighting();
                }

                float f4 = enumhand == EnumHand.OFF_HAND ? f : 0.0F;
                float f6 = 1.0F - (prevProgOff + (progOff - prevProgOff) * partialTicks);
                render.renderItemInFirstPerson(abstractclientplayer, partialTicks, f1, EnumHand.OFF_HAND, f4, overlay ? GlowingOverlayHelper.overlayStack(stackOff) : stackOff, f6);

                if (overlay && stackOff.getItem() instanceof IGlowOverlayable) {
                    IGlowOverlayable item = (IGlowOverlayable) stackOff.getItem();
                    if (item.useShader(stackOff))
                        ShaderHandler.releaseShader();
                    if (item.disableLighting(stackOff))
                        GlStateManager.enableLighting();
                }
            }
        }

        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
    }

    private void rotateAroundXAndY(float angle, float angleY) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(angle, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(angleY, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }

    private void setLightmap() {
        AbstractClientPlayer abstractclientplayer = Minecraft.getMinecraft().thePlayer;
        int i = Minecraft.getMinecraft().theWorld.getCombinedLight(new BlockPos(abstractclientplayer.posX, abstractclientplayer.posY + (double) abstractclientplayer.getEyeHeight(), abstractclientplayer.posZ), 0);
        float f = (float) (i & 65535);
        float f1 = (float) (i >> 16);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, f, f1);
    }

    private void rotateArm(float partTicks) {
        EntityPlayerSP entityplayersp = Minecraft.getMinecraft().thePlayer;
        float f = entityplayersp.prevRenderArmPitch + (entityplayersp.renderArmPitch - entityplayersp.prevRenderArmPitch) * partTicks;
        float f1 = entityplayersp.prevRenderArmYaw + (entityplayersp.renderArmYaw - entityplayersp.prevRenderArmYaw) * partTicks;
        GlStateManager.rotate((entityplayersp.rotationPitch - f) * 0.1F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate((entityplayersp.rotationYaw - f1) * 0.1F, 0.0F, 1.0F, 0.0F);
    }
}
