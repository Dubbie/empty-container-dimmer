package com.itemclarity;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("itemclarity")
public interface ItemClarityConfig extends Config {
    @Range(min = 0, max = 100)
    @ConfigItem(
            keyName = "dimStrength",
            name = "Dimming Strength (%)",
            description = "0 leaves items unchanged, 100 makes them black",
            position = 0
    )
    default int dimStrength() {
        return 50;
    }
}
