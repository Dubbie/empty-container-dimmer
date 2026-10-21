# Empty Container Dimmer

Dims supported empty containers to make them easier to distinguish from filled ones.

## Features

- Dims empty containers, currently empty jugs and buckets.
- Lets you enable dimming independently for jugs and buckets and adjust its strength.

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
