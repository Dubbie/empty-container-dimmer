package com.itemclarity;

import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.ImageUtil;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ItemClarityOverlay extends WidgetItemOverlay {

    private final ItemManager itemManager;

    private BufferedImage dimMask;

    @Inject
    ItemClarityOverlay(ItemManager itemManager) {
        this.itemManager = itemManager;
        showOnInventory();
    }

    @Override
    public void renderItemOverlay(Graphics2D graphics2D, int itemId, WidgetItem widgetItem) {
        // we are only interested in empty jug atm
        if (itemId != ItemID.JUG_EMPTY || dimMask == null) {
            return;
        }

        Rectangle screenRectangle = widgetItem.getCanvasBounds();

        Graphics2D gfx = (Graphics2D) graphics2D.create();

        try {
            gfx.setComposite(AlphaComposite.SrcOver.derive(0.5f));
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

    void prepareImages() {
        AsyncBufferedImage itemSprite = itemManager.getImage(ItemID.JUG_EMPTY);
        itemSprite.onLoaded(() -> {
            dimMask = ImageUtil.fillImage(itemSprite, Color.BLACK);
        });
    }
}
