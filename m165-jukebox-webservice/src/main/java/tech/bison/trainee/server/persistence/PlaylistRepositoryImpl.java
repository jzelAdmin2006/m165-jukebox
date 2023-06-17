package tech.bison.trainee.server.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.bison.trainee.server.business.domain.playlist.Playlist;
import tech.bison.trainee.server.business.persistence.PlaylistRepository;
import tech.bison.trainee.server.persistence.domain.PersistenceMapperService;
import tech.bison.trainee.server.persistence.domain.playlist.PlaylistPersistence;

@Service
public class PlaylistRepositoryImpl implements PlaylistRepository {

  private final PlaylistPersistence playlistPersistence;
  private final PersistenceMapperService mapperService;

  @Autowired
  public PlaylistRepositoryImpl(PlaylistPersistence playlistPersistence, PersistenceMapperService mapperService) {
    this.playlistPersistence = playlistPersistence;
    this.mapperService = mapperService;
  }

  @Override
  public List<Playlist> findAll() {
    return mapperService.fromPlaylistEntities(playlistPersistence.findAll());
  }

  @Override
  public Playlist findById(UUID id) {
    return mapperService.fromEntity(playlistPersistence.findById(id).orElse(null));
  }

  @Override
  public Playlist save(Playlist playlist) {
    return mapperService.fromEntity(playlistPersistence.save(mapperService.toEntity(playlist)));
  }
}
