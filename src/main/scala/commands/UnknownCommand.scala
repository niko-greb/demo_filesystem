package main.scala.commands

import main.scala.filesystem.State

class UnknownCommand extends Command{
  
    override def apply(state: State): State = 
        state.setMessage("Command not found!")
}
