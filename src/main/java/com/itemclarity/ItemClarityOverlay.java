package com.itemclarity;

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

public class ItemClarityOverlay extends WidgetItemOverlay {

    private final ItemManager itemManager;

    private final ItemClarityConfig config;

    private final Map<Integer, BufferedImage> dimMasks = new HashMap<>();

    @Inject
    ItemClarityOverlay(ItemManager itemManager, ItemClarityConfig config) {
        this.itemManager = itemManager;
        this.config = config;
        showOnInventory();
    }

    @Override
    public void renderItemOverlay(Graphics2D graphics2D, int itemId, WidgetItem widgetItem) {
        BufferedImage dimMask = dimMasks.get(itemId);

        if (dimMask == null) {
            return;
        }

        Rectangle screenRectangle = widgetItem.getCanvasBounds();

        Graphics2D gfx = (Graphics2D) graphics2D.create();

        try {
            float dimStrength = config.dimStrength();

            gfx.setComposite(AlphaComposite.SrcOver.derive(dimStrength / 100f));
            gfx.drawImage(
                    dimMask,
                    screenRectangle.x,
                    screenRectangle.y,
                    null
            );
        } finally {
            gfx.dispose();
        }
    }

    void prepareImages(int... itemIds) {
        for (int itemId : itemIds) {
            AsyncBufferedImage itemSprite = itemManager.getImage(itemId);
            itemSprite.onLoaded(() -> dimMasks.put(itemId, ImageUtil.fillImage(itemSprite, Color.BLACK)));
        }
    }
}
