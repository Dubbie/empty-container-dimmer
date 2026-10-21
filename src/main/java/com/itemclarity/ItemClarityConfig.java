package com.itemclarity;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("itemclarity")
public interface ItemClarityConfig extends Config {
    @ConfigItem(
            keyName = "dimEmptyContainers",
            name = "Dim empty containers",
            description = "Dims empty jugs and buckets",
            position = 0
    )
    default boolean dimEmptyContainers() {
        return true;
    }

    @Range(max = 100)
    @ConfigItem(
            keyName = "dimStrength",
            name = "Dimming Strength (%)",
            description = "0 leaves items unchanged, 100 makes them black",
            position = 1
    )
    default int dimStrength() {
        return 50;
    }

    @ConfigItem(
            keyName = "showTierMarkers",
            name = "Show tier markers",
            description = "Shows small squares based on compost levels",
            position = 2
    )
    default boolean showTierMarkers() {
        return true;
    }
}
