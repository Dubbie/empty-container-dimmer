package com.itemclarity;

import net.runelite.api.gameval.ItemID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

import javax.inject.Inject;
import java.awt.*;

public class ItemClarityOverlay extends WidgetItemOverlay {

    @Inject
    ItemClarityOverlay() {
        showOnInventory();
    }

    @Override
    public void renderItemOverlay(Graphics2D graphics2D, int itemId, WidgetItem widgetItem) {
        // we are only interested in empty jug atm
        if (itemId != ItemID.JUG_EMPTY) {
            return;
        }

        Rectangle screenRectangle = widgetItem.getCanvasBounds();

        Graphics2D gfx = (Graphics2D) graphics2D.create();

        try {
            gfx.setColor(Color.WHITE);
            gfx.draw(screenRectangle);
        } finally {
            gfx.dispose();
        }
    }
}
