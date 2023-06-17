package tech.bison.trainee.server.business.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.bison.trainee.server.business.domain.song.Song;
import tech.bison.trainee.server.business.persistence.SongRepository;

@Service
public class SongService {
  private final SongRepository songRepository;

  @Autowired
  public SongService(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  public List<Song> findAll() {
    return songRepository.findAll();
  }

  public Song findById(UUID id) {
    return songRepository.findById(id);
  }
}
