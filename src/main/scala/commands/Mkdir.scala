package main.scala.commands

import main.scala.filesystem.State
import main.scala.files.Directory

class Mkdir(name: String) extends Command {
  
    override def apply(state: State): State = {
        val wd = state.wd
        if (wd.hasEntry(name)) {
            state.setMessage("Entry " + name + " already exists!")
        } else if (name.contains(Directory.SEPARATOR)) {
            // not allowed mkdir -p something/somethingElse for now
            state.setMessage(name + " must non contains separator!")
        } else if (checkIllegal(name)) {
            state.setMessage(name + ": illegal entry name!")
        } else {
            doMkdir(state, name)
        }
    }

    def checkIllegal(name: String): Boolean = {
        name.contains(".")
    }

    def doMkdir(state: State, name: String): State = {
        
    }
}
