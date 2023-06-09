package tech.bison.trainee.server.webservice.adapter.rest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.bison.trainee.server.business.domain.song.Song;
import tech.bison.trainee.server.business.service.SongService;
import tech.bison.trainee.server.webservice.adapter.model.SongDto;
import tech.bison.trainee.server.webservice.adapter.model.SongSearchCriteriaDto;
import tech.bison.trainee.server.webservice.adapter.model.UpdateSongDto;
import tech.bison.trainee.server.webservice.domain.WebMapperService;

@RestController
@RequestMapping(path = "/songs")
public class SongController {

  private final WebMapperService mapper = new WebMapperService();
  private final SongService songService;

  @Autowired
  public SongController(SongService songService) {
    this.songService = songService;
  }

  @GetMapping()
  public ResponseEntity<List<SongDto>> getSongs() {
    List<SongDto> songs = songService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    return ResponseEntity.ok(songs);
  }

  @GetMapping("/search")
  public ResponseEntity<List<SongDto>> searchSongs(@RequestBody SongSearchCriteriaDto criteria) {
    List<SongDto> songs = songService.findByCriteria(mapper.fromDto(criteria))
        .stream()
        .map(mapper::toDto)
        .collect(Collectors.toList());
    return ResponseEntity.ok(songs);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<SongDto> getSong(@PathVariable UUID id) {
    Optional<Song> existingSong = Optional.ofNullable(songService.findById(id));
    if (existingSong.isPresent()) {
      return ResponseEntity.ok(mapper.toDto(existingSong.get()));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping()
  public ResponseEntity<SongDto> addNewSong(@RequestBody SongDto dto) {
    Song song = mapper.fromDto(dto);
    return ResponseEntity.ok(mapper.toDto(songService.save(song)));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<SongDto> updateSong(@RequestBody UpdateSongDto dto, @PathVariable UUID id) {
    Optional<Song> existingSong = Optional.ofNullable(songService.findById(id));
    if (existingSong.isPresent()) {
      Song mergedSong = mapper.merge(existingSong.get(), dto);
      Song updatedSong = songService.save(mergedSong);
      return ResponseEntity.ok(mapper.toDto(updatedSong));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<SongDto> deleteSong(@PathVariable UUID id) {
    Optional<Song> existingSong = Optional.ofNullable(songService.findById(id));
    if (existingSong.isPresent()) {
      return ResponseEntity.ok(mapper.toDto(songService.delete(existingSong.get())));
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
