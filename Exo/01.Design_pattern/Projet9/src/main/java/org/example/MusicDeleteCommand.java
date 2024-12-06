package org.example;

public class MusicDeleteCommand implements Command {
    private Playlist playlist;
    private Music music;

    public MusicDeleteCommand(Playlist playlist, Music music) {
        this.playlist = playlist;
        this.music = music;
    }

    @Override
    public void execute() {
        playlist.removeMusic(music);
    }
}