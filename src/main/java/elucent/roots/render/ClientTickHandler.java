/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 *
 * Psi is Open Source and distributed under the
 * Psi License: http://psi.vazkii.us/license.php
 *
 * File Created @ [11/01/2016, 17:51:36 (GMT)]
 */
package elucent.roots.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

public class ClientTickHandler {

    public static int ticksInGame = 0;
    public static float partialTicks = 0;
    public static float delta = 0;
    public static float total = 0;

    private void calcDelta() {
        float oldTotal = total;
        total = ticksInGame + partialTicks;
        delta = total - oldTotal;
    }

    @SubscribeEvent
    public void renderTick(RenderTickEvent event) {
        if(event.phase == Phase.START)
            partialTicks = event.renderTickTime;
    }

    @SubscribeEvent
    public void clientTickEnd(ClientTickEvent event) {
        if(event.phase == Phase.END) {
            Minecraft mc = Minecraft.getMinecraft();
            GuiScreen gui = mc.currentScreen;
            if(gui == null || !gui.doesGuiPauseGame()) {
                ticksInGame++;
                partialTicks = 0;
            }

            calcDelta();
        }
    }

}
