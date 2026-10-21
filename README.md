# Item Clarity

A RuneLite accessibility plugin for making similar-looking items easier to distinguish.

## Status

Early development. In the inventory, the plugin dims empty jugs and buckets using the configurable dimming strength. It also marks compost buckets with tier indicators: one marker for compost, two for supercompost, and three for ultracompost.

## Planned Features

- Configurable visual treatments applied to items in the inventory and other containers
- Additional labels and symbols to differentiate stacked or look-alike items

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

BSD 2-Clause
