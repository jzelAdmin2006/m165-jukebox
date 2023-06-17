package tech.bison.trainee.server.webservice.adapter.model;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SongDto {
  private final UUID id;
  private final String name;
  private final String interpreter;
  private final String album;
  private final String genre;
  private final ZonedDateTime release;

  private SongDto(UUID id, String name, String interpreter, String album, String genre, ZonedDateTime release) {
    this.id = id;
    this.name = name;
    this.interpreter = interpreter;
    this.album = album;
    this.genre = genre;
    this.release = release;
  }

  @JsonCreator
  public static SongDto of(@JsonProperty(required = false) UUID id, @JsonProperty(required = true) String name,
                           @JsonProperty(required = true) String interpreter,
                           @JsonProperty(required = false) String album, @JsonProperty(required = false) String genre,
                           @JsonProperty(required = false) ZonedDateTime release) {
    return new SongDto(id, name, interpreter, album, genre, release);
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

  public ZonedDateTime getRelease() {
    return release;
  }
}
