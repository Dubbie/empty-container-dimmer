package com.emptycontainerdimmer;

import net.runelite.api.gameval.ItemID;

import java.util.Set;

final class EmptyContainerItems {
    private static final Set<Integer> EMPTY_CONTAINERS = Set.of(
            ItemID.JUG_EMPTY,
            ItemID.BUCKET_EMPTY
    );

    static boolean isEmptyContainer(int itemId) {
        return EMPTY_CONTAINERS.contains(itemId);
    }

    static int[] getEmptyContainerIds() {
        return EMPTY_CONTAINERS.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
