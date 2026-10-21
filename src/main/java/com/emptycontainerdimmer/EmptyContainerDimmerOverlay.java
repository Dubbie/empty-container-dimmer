package com.emptycontainerdimmer;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

@Slf4j
public class EmptyContainerDimmerOverlay extends WidgetItemOverlay {

    private final ItemManager itemManager;

    private final EmptyContainerDimmerConfig config;

    private final Map<Integer, BooleanSupplier> dimSettings;

    private final Map<Integer, BufferedImage> dimMasks = new HashMap<>();

    @Inject
    EmptyContainerDimmerOverlay(ItemManager itemManager, EmptyContainerDimmerConfig config) {
        this.itemManager = itemManager;
        this.config = config;
        dimSettings = Map.ofEntries(Map.entry(ItemID.JUG_EMPTY, config::dimEmptyJugs), Map.entry(ItemID.BUCKET_EMPTY, config::dimEmptyBuckets), Map.entry(ItemID.VIAL_EMPTY, config::dimEmptyVials), Map.entry(ItemID.BOWL_EMPTY, config::dimEmptyBowls), Map.entry(ItemID.POT_EMPTY, config::dimEmptyPots), Map.entry(ItemID.BEER_GLASS, config::dimEmptyBeerGlasses), Map.entry(ItemID.CUP_EMPTY, config::dimEmptyCups), Map.entry(ItemID.PLANTPOT_EMPTY, config::dimEmptyPlantPots), Map.entry(ItemID.WATERING_CAN_0, config::dimEmptyWateringCans), Map.entry(ItemID.FISHBOWL_EMPTY, config::dimEmptyFishbowls), Map.entry(ItemID.BASKET_EMPTY, config::dimEmptyBaskets), Map.entry(ItemID.SACK_EMPTY, config::dimEmptySacks));
        showOnInventory();
    }

    @Override
    public void renderItemOverlay(Graphics2D graphics2D, int itemId, WidgetItem widgetItem) {
        BooleanSupplier enabled = dimSettings.get(itemId);

        if (enabled == null || !enabled.getAsBoolean()) {
            return;
        }

        Rectangle screenRectangle = widgetItem.getCanvasBounds();
        Graphics2D gfx = (Graphics2D) graphics2D.create();

        try {
            renderDim(gfx, itemId, screenRectangle);
        } finally {
            gfx.dispose();
        }
    }

    private void renderDim(Graphics2D gfx, int itemId, Rectangle bounds) {
        BufferedImage dimMask = dimMasks.get(itemId);

        if (dimMask == null) {
            return;
        }

        int dimStrength = Math.max(0, Math.min(100, config.dimStrength()));

        gfx.setComposite(AlphaComposite.SrcOver.derive(dimStrength / 100f));
        gfx.drawImage(dimMask, bounds.x, bounds.y, null);
    }

    void prepareImages() {
        for (int itemId : dimSettings.keySet()) {
            AsyncBufferedImage itemSprite = itemManager.getImage(itemId);

            if (itemSprite == null) {
                log.debug("Missing image, item ID: {}", itemId);
                continue;
            }

            itemSprite.onLoaded(() -> dimMasks.put(itemId, ImageUtil.fillImage(itemSprite, Color.BLACK)));
        }
    }
}
