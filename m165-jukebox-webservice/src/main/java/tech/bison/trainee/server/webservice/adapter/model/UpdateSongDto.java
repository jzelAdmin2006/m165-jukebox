package tech.bison.trainee.server.webservice.adapter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import java.util.UUID;

public class UpdateSongDto extends SongDto {

  private UpdateSongDto(UUID id, String name, String interpreter, String album, String genre, ZonedDateTime release) {
    super(id, name, interpreter, album, genre, release);
  }

  @JsonCreator
  public static UpdateSongDto of(@JsonProperty(value = "id", required = false) UUID id,
                           @JsonProperty(value = "name", required = false) String name,
                           @JsonProperty(value = "interpreter", required = false) String interpreter,
                           @JsonProperty(value = "album", required = false) String album,
                           @JsonProperty(value = "genre", required = false) String genre,
                           @JsonProperty(value = "release", required = false) ZonedDateTime release) {
    return new UpdateSongDto(id, name, interpreter, album, genre, release);
  }
}
