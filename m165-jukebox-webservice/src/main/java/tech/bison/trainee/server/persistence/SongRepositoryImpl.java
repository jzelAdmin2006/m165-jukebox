package tech.bison.trainee.server.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.bison.trainee.server.business.domain.song.Song;
import tech.bison.trainee.server.business.persistence.SongRepository;
import tech.bison.trainee.server.persistence.domain.PersistenceMapperService;
import tech.bison.trainee.server.persistence.domain.song.SongPersistence;

@Service
public class SongRepositoryImpl implements SongRepository {

  private final SongPersistence songPersistence;
  private final PersistenceMapperService mapperService;

  @Autowired
  public SongRepositoryImpl(SongPersistence songPersistence, PersistenceMapperService mapperService) {
    this.songPersistence = songPersistence;
    this.mapperService = mapperService;
  }

  @Override
  public List<Song> findAll() {
    return mapperService.fromSongEntities(songPersistence.findAll());
  }

  @Override
  public Song findById(int id) {
    return mapperService.fromEntity(songPersistence.findById(id).orElse(null));
  }

  @Override
  public Song save(Song song) {
    return mapperService.fromEntity(songPersistence.save(mapperService.toEntity(song)));
  }
}
