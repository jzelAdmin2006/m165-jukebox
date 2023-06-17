package tech.bison.trainee.server.persistence.domain.playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import tech.bison.trainee.server.persistence.domain.song.SongEntity;

@Document(collection = "playlists")
public class PlaylistEntity {

  @Id
  private final UUID id;
  private String title;
  private final List<SongEntity> songs = new ArrayList<>();

  public PlaylistEntity(UUID id, String title, List<SongEntity> songs) {
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

  public List<SongEntity> getSongs() {
    return songs;
  }
}
