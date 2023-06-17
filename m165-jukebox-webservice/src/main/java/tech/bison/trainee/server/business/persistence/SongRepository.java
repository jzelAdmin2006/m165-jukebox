package tech.bison.trainee.server.business.persistence;

import java.util.List;

import tech.bison.trainee.server.business.domain.song.Song;

public interface SongRepository {
  List<Song> findAll();

  Song findById(int id);

  Song save(Song song);
}
