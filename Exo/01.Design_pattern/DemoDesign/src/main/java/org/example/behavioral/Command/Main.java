package org.example.behavioral.Command;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOffCommand = new LightOffCommand(light);
        Command lightOnCommand = new LightOnCommand(light);
        RemoteControl remoteControl = new RemoteControl(lightOffCommand, lightOnCommand);

        remoteControl.pressButton();
        remoteControl.pressButton();
    }
}
