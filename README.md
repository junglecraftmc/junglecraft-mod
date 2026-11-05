# Junglecraft Mod

Client-Mod für Minecraft **1.21.11 (Fabric)**.

- Hauptmenü-Hintergrund: Golem-Statue im Sonnenuntergang
- Junglecraft-Logo (Panda + Schriftzug) statt Minecraft-Logo
- Buttons unten im Hauptmenü: **Server beitreten** (`jungle-craft.de`), **Webseite**, **Discord**

Braucht nur den Fabric Loader (keine Fabric API).

## Bauen

Jeder Push baut die Mod automatisch über GitHub Actions – die fertige `.jar` liegt unter
*Actions → letzter Build → Artifacts → junglecraft-mod*.

Lokal: `gradle build` (Java 21), Ergebnis in `build/libs/`.

## Anpassen

Server-IP, Webseite und Discord-Link stehen oben in
`src/main/java/de/junglecraft/mod/Junglecraft.java`.
Bilder: `src/main/resources/assets/junglecraft/textures/gui/`.
