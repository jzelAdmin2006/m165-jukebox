package tech.bison.trainee.server.business.persistence;

import java.util.List;
import java.util.UUID;

import tech.bison.trainee.server.business.domain.song.Song;

public interface SongRepository {
  List<Song> findAll();

  Song findById(UUID id);

  Song save(Song song);
}
