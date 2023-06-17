package tech.bison.trainee.server.business.persistence;

import java.util.List;

import tech.bison.trainee.server.business.domain.playlist.Playlist;

public interface PlaylistRepository {
  List<Playlist> findAll();

  Playlist findById(int id);

  Playlist save(Playlist playlist);
}
