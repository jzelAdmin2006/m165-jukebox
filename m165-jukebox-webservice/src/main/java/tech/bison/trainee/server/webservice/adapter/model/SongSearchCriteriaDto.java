package tech.bison.trainee.server.webservice.adapter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SongSearchCriteriaDto extends SongDto {

  private SongSearchCriteriaDto(String name, String interpreter, String album, String genre) {
    super(null, name, interpreter, album, genre, null);
  }

  @JsonCreator
  public static SongSearchCriteriaDto of(@JsonProperty(value = "name", required = false) String name,
      @JsonProperty(value = "interpreter", required = false) String interpreter,
      @JsonProperty(value = "album", required = false) String album,
      @JsonProperty(value = "genre", required = false) String genre) {
    return new SongSearchCriteriaDto(name, interpreter, album, genre);
  }
}
