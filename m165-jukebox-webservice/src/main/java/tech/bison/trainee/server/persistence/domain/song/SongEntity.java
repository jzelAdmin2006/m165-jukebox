package tech.bison.trainee.server.persistence.domain.song;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "songs")
public class SongEntity {

  @Id
  private final UUID id;
  private final String name;
  private final String interpreter;
  private final String album;
  private final String genre;
  private final Date release;

  public SongEntity(UUID id, String name, String interpreter, String album, String genre, Date release) {
    this.id = id;
    this.name = name;
    this.interpreter = interpreter;
    this.album = album;
    this.genre = genre;
    this.release = release;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getInterpreter() {
    return interpreter;
  }

  public String getAlbum() {
    return album;
  }

  public String getGenre() {
    return genre;
  }

  public Date getRelease() {
    return release;
  }
}
