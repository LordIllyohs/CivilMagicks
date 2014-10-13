/**
 * Copyright (c) 2014, Anthony Anderson(Lord Illyohs)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package us.illyohs.civilmagicks.client.render.tile;

import org.lwjgl.opengl.GL11;

import us.illyohs.civilmagicks.client.model.ModelAccumulator;
import us.illyohs.civilmagicks.common.lib.LibInfo;
import us.illyohs.civilmagicks.common.tile.TileAccumulator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderAccumulator extends TileEntitySpecialRenderer {

    private ModelAccumulator model;

    public RenderAccumulator() {
        model = new ModelAccumulator();

    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(LibInfo.MOD_ID, "textures/models/keeper.png");

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick) {
        TileAccumulator ta = (TileAccumulator) tileentity;

        GL11.glPushMatrix();

        GL11.glTranslated((float) x + 0.5, (float) y + 1.5, (float) z + 0.5);
        GL11.glScalef(1F, -1F, -1F);
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        model.render(.0625F);
        GL11.glScalef(1F, -1F, -1F);
        GL11.glBlendFunc(0, 1);
        GL11.glClearColor(0.7f, 0.7f, 0.7f, 1.0f);

        GL11.glPopMatrix();
    }

}
