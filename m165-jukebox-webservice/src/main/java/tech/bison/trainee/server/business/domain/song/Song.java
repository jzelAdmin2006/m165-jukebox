package tech.bison.trainee.server.business.domain.song;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

public class Song {
  private final UUID id;
  private String name;
  private String interpreter;
  private String album;
  private String genre;
  private ZonedDateTime release;

  private Song(UUID id, String name, String interpreter, String album, String genre, ZonedDateTime release) {
    this.id = id;
    this.name = name;
    this.interpreter = interpreter;
    this.album = album;
    this.genre = genre;
    this.release = release;
  }

  public static Song of(Optional<UUID> id, String name, String interpreter, String album, String genre,
                        ZonedDateTime release) {
    return new Song(id.orElse(UUID.randomUUID()), name, interpreter, album, genre, release);
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

  public void setName(String name) {
    this.name = name;
  }

  public void setInterpreter(String interpreter) {
    this.interpreter = interpreter;
  }

  public void setAlbum(String album) {
    this.album = album;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setRelease(ZonedDateTime release) {
    this.release = release;
  }
}
