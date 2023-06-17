package tech.bison.trainee.server.webservice.adapter.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.bison.trainee.server.business.domain.song.Song;
import tech.bison.trainee.server.business.service.SongService;
import tech.bison.trainee.server.webservice.adapter.model.SongDto;
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

  @PostMapping()
  public ResponseEntity<SongDto> addNewSong(@RequestBody SongDto dto) {
    Song song = mapper.fromDto(dto);
    return ResponseEntity.ok(mapper.toDto(songService.save(song)));
  }
}
