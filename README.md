# Empty Container Dimmer

Dims supported empty containers to make them easier to distinguish from filled ones.

## Features

- Dims empty jugs, buckets, vials, bowls, pots, beer glasses, cups, plant pots, watering cans, fishbowls, baskets, and sacks.
- Provides an independent on/off setting for each supported container type and one shared dimming strength for all of them.
- Only the fixed empty item IDs are dimmed. Filled containers and partially filled watering cans are unchanged.

### Supported containers

Each of the 12 supported item types has its own enabled-by-default setting: empty jugs, buckets, ordinary vials, bowls, pots, beer glasses, cups, plant pots, fully depleted watering cans, fishbowls, baskets, and sacks. Dimming strength is shared across all types. The overlay prepares masks for every supported item when the plugin starts and reads each checkbox when rendering, so checkbox changes take effect immediately without restarting.

## Requirements

- JDK 11

## Build

```powershell
.\gradlew.bat clean build
```

## Run (development client)

```powershell
.\gradlew.bat run
```

This launches a full RuneLite client with the plugin loaded. Log in using the [Jagex Account instructions](https://github.com/runelite/runelite/wiki/Using-Jagex-Accounts).

## Development Launcher

`EmptyContainerDimmerPluginTest` is not an automated test. It is the entry point used by Gradle's `run` task to boot the development client with this plugin pre-loaded.

## License

[BSD 2-Clause](LICENSE)
