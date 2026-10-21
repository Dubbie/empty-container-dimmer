package com.itemclarity;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
	name = "Item Clarity",
    description = "Make similar-looking items easier to distinguish",
    tags = {"accessibility", "inventory", "colorblind"}
)
public class ItemClarityPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ItemClarityConfig config;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private ItemClarityOverlay overlay;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Item Clarity started!");

        overlay.prepareImages(ItemID.JUG_EMPTY, ItemID.BUCKET_EMPTY);
        overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("Item Clarity stopped!");

        overlayManager.remove(overlay);
	}

	@Provides
    ItemClarityConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ItemClarityConfig.class);
	}
}
