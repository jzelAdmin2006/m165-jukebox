package tech.bison.trainee.server.business.domain.playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import tech.bison.trainee.server.business.domain.song.Song;

public class Playlist {

  private final UUID id;
  private String title;
  private final List<Song> songs = new ArrayList<>();

  public Playlist(UUID id, String title, List<Song> songs) {
    this.id = id;
    this.setTitle(title);
    this.songs.addAll(songs);
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Song> getSongs() {
    return songs;
  }
}
