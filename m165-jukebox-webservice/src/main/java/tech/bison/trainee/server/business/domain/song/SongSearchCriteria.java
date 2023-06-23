package tech.bison.trainee.server.business.domain.song;

public class SongSearchCriteria {

  private final String name;
  private final String interpreter;
  private final String album;
  private final String genre;

  private SongSearchCriteria(String name, String interpreter, String album, String genre) {
    this.name = name;
    this.interpreter = interpreter;
    this.album = album;
    this.genre = genre;
  }

  public static SongSearchCriteria of(String name, String interpreter, String album, String genre) {
    return new SongSearchCriteria(name, interpreter, album, genre);
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
}
