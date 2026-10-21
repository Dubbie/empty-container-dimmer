package com.emptycontainerdimmer;

import net.runelite.api.gameval.ItemID;

import java.util.Map;
import java.util.function.Predicate;

final class EmptyContainerItems {
    private static final Map<Integer, Predicate<EmptyContainerDimmerConfig>> ITEMS =
            Map.ofEntries(
                    Map.entry(ItemID.JUG_EMPTY,
                            EmptyContainerDimmerConfig::dimEmptyJugs),
                    Map.entry(ItemID.BUCKET_EMPTY,
                            EmptyContainerDimmerConfig::dimEmptyBuckets)
            );

    static boolean shouldDim(int itemId, EmptyContainerDimmerConfig config) {
        Predicate<EmptyContainerDimmerConfig> enabled = ITEMS.get(itemId);
        return enabled != null && enabled.test(config);
    }

    static int[] getEmptyContainerIds()
    {
        return ITEMS.keySet().stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
