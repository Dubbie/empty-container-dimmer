package com.itemclarity;

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
        ItemKind kind = ClarityItems.getKind(itemId);

        if (kind == null) {
            return;
        }

        Rectangle screenRectangle = widgetItem.getCanvasBounds();
        Graphics2D gfx = (Graphics2D) graphics2D.create();

        try {
            switch (kind) {
                case EMPTY_CONTAINER:
                    renderDim(gfx, itemId, screenRectangle);
                    break;
                case TIER_ONE:
                    renderTier(gfx, screenRectangle, 1);
                    break;
                case TIER_TWO:
                    renderTier(gfx, screenRectangle, 2);
                    break;
                case TIER_THREE:
                    renderTier(gfx, screenRectangle, 3);
                    break;
            }
        } finally {
            gfx.dispose();
        }
    }

    private void renderTier(Graphics2D gfx, Rectangle bounds, int tier) {
        int diameter = 6;
        int gap = 2;
        int padding = 2;

        int totalWidth = tier * diameter + (tier - 1) * gap;
        int startX = bounds.x + bounds.width - padding - totalWidth;
        int y = bounds.y + bounds.height - padding - diameter;

        gfx.setComposite(AlphaComposite.SrcOver);

        for (int i = 0; i < tier; i++) {
            int x = startX + i * (diameter + gap);

            gfx.setColor(Color.BLACK);
            gfx.fillOval(x, y, diameter, diameter);

            gfx.setColor(Color.WHITE);
            gfx.fillOval(x + 1, y + 1, diameter - 2, diameter - 2);
        }
    }

    private void renderDim(Graphics2D gfx, int itemId, Rectangle bounds) {
        BufferedImage dimMask = dimMasks.get(itemId);

        if (dimMask == null) {
            return;
        }

        float dimStrength = config.dimStrength();

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
            itemSprite.onLoaded(() -> dimMasks.put(itemId, ImageUtil.fillImage(itemSprite, Color.BLACK)));
        }
    }
}
