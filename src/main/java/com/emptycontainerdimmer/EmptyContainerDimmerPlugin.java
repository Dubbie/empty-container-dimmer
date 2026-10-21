package com.emptycontainerdimmer;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(name = "Empty Container Dimmer", description = "Dims supported empty containers to make them easier to distinguish from filled ones.", tags = {"accessibility", "inventory", "empty", "containers", "jugs", "buckets", "colorblind"})
public class EmptyContainerDimmerPlugin extends Plugin {
    @Inject
    private OverlayManager overlayManager;

    @Inject
    private EmptyContainerDimmerOverlay overlay;

    @Override
    protected void startUp() throws Exception {
        log.debug("Empty Container Dimmer started!");

        overlay.prepareImages();
        overlayManager.add(overlay);
    }

    @Override
    protected void shutDown() throws Exception {
        log.debug("Empty Container Dimmer stopped!");

        overlayManager.remove(overlay);
    }

    @Provides
    EmptyContainerDimmerConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(EmptyContainerDimmerConfig.class);
    }
}
