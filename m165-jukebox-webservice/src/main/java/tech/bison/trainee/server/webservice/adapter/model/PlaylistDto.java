package tech.bison.trainee.server.webservice.adapter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlaylistDto {
  private final UUID id;
  private String title;
  private final List<SongDto> songs = new ArrayList<>();

  public PlaylistDto(UUID id, String title, List<SongDto> songs) {
    this.id = id;
    this.title = title;
    this.songs.addAll(songs);
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<SongDto> getSongs() {
    return songs;
  }
}
