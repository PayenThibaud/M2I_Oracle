package org.example.behavioral.Command;

public class RemoteControl {
    private Command command;
    private Command command2;
    private boolean aBoolean;

    public RemoteControl(Command command, Command command2) {
        this.command = command;
        this.command2 = command2;
    }

    public void pressButton() {
        if (command != null && command2 != null) {
            if (aBoolean) {
                command.execute();
                aBoolean = !aBoolean;
            } else {
                command2.execute();
                aBoolean = !aBoolean;
            }
        }else {
            System.out.println("Nothing to do");
        }
    }
}
