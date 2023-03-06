package main.scala.filesystem

import main.scala.files.Directory
import main.scala.commands.Command
import java.util.Scanner

object Filesystem extends App {
    
    val root = Directory.ROOT
    val scanner = new Scanner(System.in)
    var state = State(root, root)


    while(true) {
        state.show
        val input = scanner.nextLine()
        state = Command.from(input).apply(state)
    }
       
}
