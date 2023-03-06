## Demo filesystem which use OOP Scala

### Usage

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.

For more information on the sbt-dotty plugin, see the
[scala3-example-project](https://github.com/scala/scala3-example-project/blob/main/README.md).

### Commands allowed

    * No command — returns empty promt
    * Command missing — "Command not found"
    * Incomplete command — "{name}: incomplete command!"
    * mkdir — work in progress
    ** Directory is alredy exists — "Entry {name} already exists!"
    ** mkdir -p something/somethingElse is not allowed for now — "{name} must not contains separator!"
    ** Some illegal signs — "{name}: illegal entry name!"
