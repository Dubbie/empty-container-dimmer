package com.itemclarity;

import net.runelite.api.gameval.ItemID;

import java.util.Map;

final class ClarityItems {
    private static final Map<Integer, ItemKind> ITEMS = Map.of(
            ItemID.JUG_EMPTY, ItemKind.EMPTY_CONTAINER,
            ItemID.BUCKET_EMPTY, ItemKind.EMPTY_CONTAINER,
            ItemID.BUCKET_COMPOST, ItemKind.TIER_ONE,
            ItemID.BUCKET_SUPERCOMPOST, ItemKind.TIER_TWO,
            ItemID.BUCKET_ULTRACOMPOST, ItemKind.TIER_THREE
    );

    static ItemKind getKind(int itemId) {
        return ITEMS.get(itemId);
    }

    static int[] getEmptyContainerIds()
    {
        return ITEMS.entrySet().stream()
                .filter(entry -> entry.getValue() == ItemKind.EMPTY_CONTAINER)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
