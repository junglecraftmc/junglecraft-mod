package de.junglecraft.mod.mixin;

import de.junglecraft.mod.Junglecraft;
import net.minecraft.util.Util;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Fügt die Junglecraft-Buttons unten im Hauptmenü hinzu. */
@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void junglecraft$addButtons(CallbackInfo ci) {
        int w = 98;
        int gap = 4;
        int total = w * 3 + gap * 2;
        int x = this.width / 2 - total / 2;
        int y = this.height - 38;

        this.addRenderableWidget(Button.builder(Component.literal("§a▶ Server beitreten"), b -> junglecraft$joinServer())
                .bounds(x, y, w, 20).build());
        this.addRenderableWidget(Button.builder(Component.literal("Webseite"), b -> Util.getPlatform().openUri(Junglecraft.WEBSITE))
                .bounds(x + w + gap, y, w, 20).build());
        this.addRenderableWidget(Button.builder(Component.literal("Discord"), b -> Util.getPlatform().openUri(Junglecraft.DISCORD))
                .bounds(x + (w + gap) * 2, y, w, 20).build());
    }

    private void junglecraft$joinServer() {
        ServerData data = new ServerData("Junglecraft", Junglecraft.SERVER_IP, ServerData.Type.OTHER);
        ConnectScreen.startConnecting(this, this.minecraft, ServerAddress.parseString(Junglecraft.SERVER_IP), data, false, null);
    }
}
