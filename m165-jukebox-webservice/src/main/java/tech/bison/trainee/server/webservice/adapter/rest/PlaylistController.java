package tech.bison.trainee.server.webservice.adapter.rest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.bison.trainee.server.business.domain.playlist.Playlist;
import tech.bison.trainee.server.business.domain.song.Song;
import tech.bison.trainee.server.business.service.PlaylistService;
import tech.bison.trainee.server.business.service.SongService;
import tech.bison.trainee.server.webservice.adapter.model.PlaylistDto;
import tech.bison.trainee.server.webservice.domain.WebMapperService;

@RestController
@RequestMapping(path = "/playlists")
public class PlaylistController {

  private final WebMapperService mapper = new WebMapperService();
  private final PlaylistService playlistService;
  private final SongService songService;

  @Autowired
  public PlaylistController(PlaylistService playlistService, SongService songService) {
    this.playlistService = playlistService;
    this.songService = songService;
  }

  @GetMapping()
  public ResponseEntity<List<PlaylistDto>> getPlaylists() {
    List<PlaylistDto> playlists = playlistService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    return ResponseEntity.ok(playlists);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<PlaylistDto> getPlaylist(@PathVariable UUID id) {
    Optional<Playlist> existingPlaylist = Optional.ofNullable(playlistService.findById(id));
    if (existingPlaylist.isPresent()) {
      return ResponseEntity.ok(mapper.toDto(existingPlaylist.get()));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping()
  public ResponseEntity<PlaylistDto> addNewPlaylist(@RequestBody PlaylistDto dto) {
    Playlist playlist = mapper.fromDto(dto);
    return ResponseEntity.ok(mapper.toDto(playlistService.save(playlist)));
  }

  @PutMapping(path = "/{id}/{songId}")
  public ResponseEntity<PlaylistDto> addSongToPlaylist(@PathVariable UUID id, @PathVariable UUID songId) {
    Optional<Playlist> existingPlaylist = Optional.ofNullable(playlistService.findById(id));
    Optional<Song> existingSong = Optional.ofNullable(songService.findById(songId));
    if (existingPlaylist.isPresent() && existingSong.isPresent()) {
      Playlist playlist = existingPlaylist.get();
      playlist.getSongs().add(existingSong.get());
      return ResponseEntity.ok(mapper.toDto(playlistService.save(playlist)));
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
