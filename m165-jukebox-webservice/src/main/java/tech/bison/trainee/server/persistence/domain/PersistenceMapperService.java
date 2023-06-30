package tech.bison.trainee.server.persistence.domain;

import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import tech.bison.trainee.server.business.domain.playlist.Playlist;
import tech.bison.trainee.server.business.domain.song.Song;
import tech.bison.trainee.server.persistence.domain.playlist.PlaylistEntity;
import tech.bison.trainee.server.persistence.domain.song.SongEntity;

@Service
public class PersistenceMapperService {

  public SongEntity toEntity(Song song) {
    return new SongEntity(song.getId(), song.getName(), song.getInterpreter(), song.getAlbum(), song.getGenre(),
        Date.from(song.getRelease().toInstant()));
  }

  public Song fromEntity(SongEntity song) {
    return Song.of(Optional.of(song.getId()),
        song.getName(),
        song.getInterpreter(),
        song.getAlbum(),
        song.getGenre(),
        song.getRelease().toInstant().atZone(ZoneId.systemDefault()));
  }

  public List<SongEntity> toSongEntities(List<Song> songs) {
    if (songs == null) {
      return Collections.emptyList();
    }
    return songs.stream().map(this::toEntity).collect(Collectors.toList());
  }

  public List<Song> fromSongEntities(List<SongEntity> songs) {
    if (songs == null) {
      return Collections.emptyList();
    }
    return songs.stream().map(this::fromEntity).collect(Collectors.toList());
  }

  public PlaylistEntity toEntity(Playlist playlist) {
    return new PlaylistEntity(playlist.getId(), playlist.getTitle(), toSongEntities(playlist.getSongs()));
  }

  public Playlist fromEntity(PlaylistEntity playlist) {
    return Playlist.of(Optional.of(playlist.getId()), playlist.getTitle(), fromSongEntities(playlist.getSongs()));
  }

  public List<PlaylistEntity> toPlaylistEntities(List<Playlist> playlists) {
    if (playlists == null) {
      return Collections.emptyList();
    }
    return playlists.stream().map(this::toEntity).collect(Collectors.toList());
  }

  public List<Playlist> fromPlaylistEntities(List<PlaylistEntity> playlists) {
    if (playlists == null) {
      return Collections.emptyList();
    }
    return playlists.stream().map(this::fromEntity).collect(Collectors.toList());
  }
}
