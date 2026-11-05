package de.junglecraft.mod.mixin;

import de.junglecraft.mod.Junglecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Ersetzt das Panorama im Hauptmenü durch das Junglecraft-Bild. */
@Mixin(Screen.class)
public abstract class ScreenMixin {
    @Shadow public int width;
    @Shadow public int height;

    @Inject(method = "renderPanorama", at = @At("HEAD"), cancellable = true)
    private void junglecraft$renderBackground(GuiGraphics guiGraphics, float partialTick, CallbackInfo ci) {
        if ((Object) this instanceof TitleScreen) {
            Junglecraft.drawBackground(guiGraphics, this.width, this.height);
            ci.cancel();
        }
    }
}
