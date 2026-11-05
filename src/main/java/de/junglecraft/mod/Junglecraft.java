package de.junglecraft.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;

public final class Junglecraft {
    public static final String MOD_ID = "junglecraft";

    public static final String SERVER_IP = "jungle-craft.de";
    public static final String WEBSITE = "https://jungle-craft.de";
    public static final String DISCORD = "https://discord.gg/rzThEaCnp";

    private static final Identifier BACKGROUND = id("textures/gui/background.png");
    private static final Identifier PANDA = id("textures/gui/panda.png");
    private static final int BG_W = 1920;
    private static final int BG_H = 1080;

    private Junglecraft() {}

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    /** Hintergrundbild bildschirmfüllend (wie "cover" in CSS). */
    public static void drawBackground(GuiGraphics g, int width, int height) {
        float scale = Math.max(width / (float) BG_W, height / (float) BG_H);
        int dw = Math.round(BG_W * scale);
        int dh = Math.round(BG_H * scale);
        int x = (width - dw) / 2;
        int y = (height - dh) / 2;
        g.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, x, y, 0f, 0f, dw, dh, dw, dh);
    }

    /** Panda-Logo + großer "JUNGLECRAFT"-Schriftzug statt Minecraft-Logo. */
    public static void drawLogo(GuiGraphics g, int screenWidth, float alpha, int y) {
        var font = Minecraft.getInstance().font;
        String title = "JUNGLECRAFT";
        int scale = 3;
        int iconSize = 44;
        int gap = 6;
        int textW = font.width(title) * scale;
        int totalW = iconSize + gap + textW;
        int x = screenWidth / 2 - totalW / 2;

        g.blit(RenderPipelines.GUI_TEXTURED, PANDA, x, y, 0f, 0f, iconSize, iconSize, iconSize, iconSize,
                ARGB.white(alpha));

        int a = Math.max(4, Math.round(alpha * 255));
        int textY = y + (iconSize - font.lineHeight * scale) / 2 + 2;
        g.pose().pushMatrix();
        g.pose().translate(x + iconSize + gap, textY);
        g.pose().scale(scale, scale);
        g.drawString(font, title, 0, 0, ARGB.color(a, 0x5FD94A), true);
        g.pose().popMatrix();
    }
}
