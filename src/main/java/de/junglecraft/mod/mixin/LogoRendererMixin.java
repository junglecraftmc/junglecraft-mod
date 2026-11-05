package de.junglecraft.mod.mixin;

import de.junglecraft.mod.Junglecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.LogoRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Zeichnet das Junglecraft-Logo statt des Minecraft-Logos. */
@Mixin(LogoRenderer.class)
public class LogoRendererMixin {
    @Inject(method = "renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IFI)V", at = @At("HEAD"), cancellable = true)
    private void junglecraft$renderLogo(GuiGraphics guiGraphics, int screenWidth, float alpha, int y, CallbackInfo ci) {
        Junglecraft.drawLogo(guiGraphics, screenWidth, alpha, y);
        ci.cancel();
    }
}
