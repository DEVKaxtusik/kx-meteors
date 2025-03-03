package pl.kaxtusik.meteor.command;

import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;

@Command(name = "meteor")
@Permission("kx.meteor.admin")
public class MeteorCommand {

    @Execute
    void executeMeteor() {

    }

}
