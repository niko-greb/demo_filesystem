package main.scala.commands

import main.scala.filesystem.State
import main.scala.files.Directory
import main.scala.files.DirEntry

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
        def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
            if (path.isEmpty) currentDirectory.addEntry(newEntry)
            else {
                val oldEntry = currentDirectory.findEntry(path.head).asDirectory
                currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
            }
        }

        val wd = state.wd

        // 1. all the directories in the fullpath
        val allDirsInPath = wd.getAllFoldersInPath

        // 2. create new directoru entry in wd
        val newDir = Directory.empty(wd.path, name)

        // 3. update the whole directory structure starting from the root
        val newRoot = updateStructure(state.root, allDirsInPath, newDir)

        // 4. find new wd INSTANCE gice wd's full path, in the NEW directory structure
        val newWd = newRoot.findDescendant(allDirsInPath)

        State(newRoot, newWd)
    }
}
