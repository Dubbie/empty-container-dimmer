package com.emptycontainerdimmer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("empty-container-dimmer")
public interface EmptyContainerDimmerConfig extends Config {
    @Range(max = 100)
    @ConfigItem(
            keyName = "dimStrength",
            name = "Dimming Strength (%)",
            description = "0 leaves items unchanged, 100 makes them black",
            position = 0
    )
    default int dimStrength() {
        return 50;
    }

    @ConfigItem(
            keyName = "dimEmptyJugs",
            name = "Dim empty jugs",
            description = "Dim empty jugs in your inventory",
            position = 1
    )
    default boolean dimEmptyJugs()
    {
        return true;
    }

    @ConfigItem(
            keyName = "dimEmptyBuckets",
            name = "Dim empty buckets",
            description = "Dim empty buckets in your inventory",
            position = 2
    )
    default boolean dimEmptyBuckets()
    {
        return true;
    }
}
