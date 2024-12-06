package org.example;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        Music music1 = new Music("Musique 1");
        Music music2 = new Music("Musique 2");
        Music music3 = new Music("Musique 3");

        Command addMusic1 = new MusicAddCommand(playlist, music1);
        Command addMusic2 = new MusicAddCommand(playlist, music2);
        Command addMusic3 = new MusicAddCommand(playlist, music3);
        Command deleteMusic1 = new MusicDeleteCommand(playlist, music1);
        Command deleteMusic2 = new MusicDeleteCommand(playlist, music2);
        Command deleteMusic3 = new MusicDeleteCommand(playlist, music3);
        Command getAllMusic = new MusicGetAllCommand(playlist);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.executeCommand(addMusic1);
        remoteControl.executeCommand(addMusic2);

        remoteControl.executeCommand(getAllMusic);

        remoteControl.executeCommand(deleteMusic1);

        remoteControl.executeCommand(getAllMusic);

        remoteControl.executeCommand(deleteMusic1);

        remoteControl.executeCommand(addMusic3);

        remoteControl.executeCommand(getAllMusic);
    }

}