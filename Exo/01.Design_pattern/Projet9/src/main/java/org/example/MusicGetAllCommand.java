package org.example;

public class MusicGetAllCommand implements Command {
    private Playlist playlist;

    public MusicGetAllCommand(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public void execute() {
        playlist.getAllMusic();
    }
}
