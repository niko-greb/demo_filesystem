## Demo filesystem with OOP Scala

### Usage

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.

For more information on the sbt-dotty plugin, see the
[scala3-example-project](https://github.com/scala/scala3-example-project/blob/main/README.md).

### Commands allowed

    - No command — returns empty promt
    - Command missing — "Command not found"
    - Incomplete command — "{name}: incomplete command!"
    - mkdir — complete. Some updates is going on like mkdir a/b/c/b/d
        - Directory is alredy exists — "Entry {name} already exists!"
        - mkdir -p something/somethingElse is not allowed for now — "{name} must not contains separator!"
        - Some illegal signs — "{name}: illegal entry name!"
    - ls — complete
        - is going to update with type of content
        for now only ls has only Directory
