package com.emptycontainerdimmer;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
public class EmptyContainerDimmerOverlay extends WidgetItemOverlay {

    private final ItemManager itemManager;

    private final EmptyContainerDimmerConfig config;

    private final Map<Integer, BufferedImage> dimMasks = new HashMap<>();

    @Inject
    EmptyContainerDimmerOverlay(ItemManager itemManager, EmptyContainerDimmerConfig config) {
        this.itemManager = itemManager;
        this.config = config;
        showOnInventory();
    }

    @Override
    public void renderItemOverlay(Graphics2D graphics2D, int itemId, WidgetItem widgetItem) {
        if (!EmptyContainerItems.shouldDim(itemId, config)) {
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
        gfx.drawImage(
                dimMask,
                bounds.x,
                bounds.y,
                null
        );
    }

    void prepareImages(int... itemIds) {
        for (int itemId : itemIds) {
            AsyncBufferedImage itemSprite = itemManager.getImage(itemId);

            if (itemSprite == null) {
                log.debug("Missing image, item ID: {}", itemId);
                continue;
            }

            itemSprite.onLoaded(() -> dimMasks.put(itemId, ImageUtil.fillImage(itemSprite, Color.BLACK)));
        }
    }
}
