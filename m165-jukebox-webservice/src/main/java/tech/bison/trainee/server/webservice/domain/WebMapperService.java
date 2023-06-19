package tech.bison.trainee.server.webservice.domain;

import static tech.bison.trainee.server.common.UpdateUtils.updateIfNotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tech.bison.trainee.server.business.domain.playlist.Playlist;
import tech.bison.trainee.server.business.domain.song.Song;
import tech.bison.trainee.server.common.UpdateUtils;
import tech.bison.trainee.server.webservice.adapter.model.PlaylistDto;
import tech.bison.trainee.server.webservice.adapter.model.SongDto;

@Service
public class WebMapperService {

  public SongDto toDto(Song song) {
    return SongDto
        .of(song.getId(), song.getName(), song.getInterpreter(), song.getAlbum(), song.getGenre(), song.getRelease());
  }

  public Song fromDto(SongDto song) {
    return Song.of(Optional.ofNullable(
        song.getId()), song.getName(), song.getInterpreter(), song.getAlbum(), song.getGenre(), song.getRelease());
  }

  public List<SongDto> toSongDtos(List<Song> songs) {
    if (songs == null) {
      return Collections.emptyList();
    }
    return songs.stream().map(this::toDto).collect(Collectors.toList());
  }

  public List<Song> fromSongDtos(List<SongDto> songs) {
    if (songs == null) {
      return Collections.emptyList();
    }
    return songs.stream().map(this::fromDto).collect(Collectors.toList());
  }

  public PlaylistDto toDto(Playlist playlist) {
    return new PlaylistDto(playlist.getId(), playlist.getTitle(), toSongDtos(playlist.getSongs()));
  }

  public Playlist fromDto(PlaylistDto playlist) {
    return new Playlist(playlist.getId(), playlist.getTitle(), fromSongDtos(playlist.getSongs()));
  }

  public List<PlaylistDto> toPlaylistDtos(List<Playlist> playlists) {
    if (playlists == null) {
      return Collections.emptyList();
    }
    return playlists.stream().map(this::toDto).collect(Collectors.toList());
  }

  public List<Playlist> fromPlaylistDtos(List<PlaylistDto> playlists) {
    if (playlists == null) {
      return Collections.emptyList();
    }
    return playlists.stream().map(this::fromDto).collect(Collectors.toList());
  }

  public Song merge(Song songToUpdate, SongDto dto) {
    updateIfNotNull(dto::getName, songToUpdate::setName);
    updateIfNotNull(dto::getInterpreter, songToUpdate::setInterpreter);
    updateIfNotNull(dto::getAlbum, songToUpdate::setAlbum);
    updateIfNotNull(dto::getGenre, songToUpdate::setGenre);
    updateIfNotNull(dto::getRelease, songToUpdate::setRelease);
    return songToUpdate;
  }
}
