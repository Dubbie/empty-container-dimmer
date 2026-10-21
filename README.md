# Item Clarity

A RuneLite accessibility plugin for making similar-looking items easier to distinguish.

## Status

The plugin currently improves item clarity in the inventory:

- Dims empty jugs and buckets, with a setting to turn dimming on or off and adjust its strength.
- Marks compost buckets with tier indicators: one marker for compost, two for supercompost, and three for ultracompost. Tier markers can be turned on or off.

## Planned Features

- Extend item treatments to other containers.
- Add more labels or symbols for stacked and look-alike items.

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

`ItemClarityPluginTest` is not an automated test. It is the entry point used by Gradle's `run` task to boot the development client with this plugin pre-loaded.

## License

[BSD 2-Clause](LICENSE)
