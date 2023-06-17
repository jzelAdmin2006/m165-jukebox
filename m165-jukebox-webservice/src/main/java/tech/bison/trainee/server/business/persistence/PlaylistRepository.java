package tech.bison.trainee.server.business.persistence;

import java.util.List;
import java.util.UUID;

import tech.bison.trainee.server.business.domain.playlist.Playlist;

public interface PlaylistRepository {
  List<Playlist> findAll();

  Playlist findById(UUID id);

  Playlist save(Playlist playlist);
}
