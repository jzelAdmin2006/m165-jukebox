package tech.bison.trainee.server.business.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bison.trainee.server.business.domain.playlist.Playlist;
import tech.bison.trainee.server.business.persistence.PlaylistRepository;

@Service
public class PlaylistService {

  private final PlaylistRepository playlistRepository;

  @Autowired
  public PlaylistService(PlaylistRepository playlistRepository) {
    this.playlistRepository = playlistRepository;
  }

  public List<Playlist> findAll() {
    return playlistRepository.findAll();
  }

  public Playlist save(Playlist playlist) {
    return playlistRepository.save(playlist);
  }

  public Playlist findById(UUID id) {
    return playlistRepository.findById(id);
  }
}