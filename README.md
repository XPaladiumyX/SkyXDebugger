[![Discord](https://badgen.net/badge/icon/discord?icon=discord&label)](https://discord.gg/pTErYjTh5h)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-red.svg)](https://bitbucket.org/lbesson/ansi-colors)
[![Open Source? Yes!](https://badgen.net/badge/Open%20Source%20%3F/Yes%21/blue?icon=github)](https://github.com/Naereen/badges/)
[![Website](https://img.shields.io/website-up-down-green-red/http/shields.io.svg)](https://skyxnetwork.net)  

# SkyXDebugger

SkyXDebugger is a lightweight Bukkit/Spigot plugin for Paper 1.21+ servers that helps detect when an anvil output disappears or is cancelled by another plugin. It is especially useful for debugging custom items or conflicting plugins affecting anvils.

## Features

- Detects when an item combination in an anvil is cancelled or removed.
- Logs the player, the items involved, and a partial stack trace to help identify the conflicting plugin.
- Completely inactive when disabled to ensure zero performance impact.
- Simple enable/disable via command.

## Commands

- `/skyxdebugger enable` – Activate the debugger.  
- `/skyxdebugger disable` – Deactivate the debugger.  

## Permissions

- `skyxdebugger.use` – Allows usage of the `/skyxdebugger` command (default: OP).

## Usage

1. Place the `SkyXDebugger.jar` in your server's `plugins` folder.
2. Start your server.
3. Use `/skyxdebugger enable` to start debugging anvil interactions.
4. Observe your console for logs when the output disappears.
5. Use `/skyxdebugger disable` to stop the debugger.

## Compatibility

- Paper 1.21+
- Spigot 1.21+
- Designed to work alongside large plugin setups without affecting server performance.

## License

This project is licensed under the MIT License.

