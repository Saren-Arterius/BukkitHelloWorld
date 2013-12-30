BukkitHelloWorld
================
* **Name** - BukkitHelloWorld or Fuck
* **Purpose** - Nothing.

# Commands
* **/fuck (player) (power) (times)** - Fuck a (player) for (times) times using power of (power).
* **/fuckreload** - Reloads the plugin.

# config.yml

limit:

    fuckPower: 10 # The maximum fuck power of a player.
    fuckTimes: 10 # The maximum fuck times of a player.
message:

    # Your localizations
# permissions

    fuck.*:
        description: Gives access to all BukkitHelloWorld commands.
        children:
            fuck.qualifiedToFuck: true
            fuck.allowsSelfFucking: true
            fuck.allowsLimitsOverriding: true
            fuck.reload: true
    fuck.qualifiedToFuck:
        description: Allows you to fuck somebody.
        default: op
    fuck.allowsSelfFucking:
        description: Allows you to fuck yourself.
        default: op
    fuck.allowsLimitsOverriding:
        description: Allows you to override the limits.
        default: op
    fuck.reload:
        description: Allows you to reload your penis.
        default: op
