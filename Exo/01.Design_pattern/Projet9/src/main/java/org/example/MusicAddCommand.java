package org.example;

public class MusicAddCommand implements Command {
    private Playlist playlist;
    private Music music;

    public MusicAddCommand(Playlist playlist, Music music) {
        this.playlist = playlist;
        this.music = music;
    }

    @Override
    public void execute() {
        playlist.addMusic(music);
    }
}