package tech.bison.trainee.server.persistence.domain.song;

import java.util.UUID;
import java.util.stream.Stream;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongPersistence extends MongoRepository<SongEntity, UUID> {

  @Query("{'$and' : [{'name': {$regex : ?0, $options: 'i'}}, {'interpreter': {$regex : ?1, $options: 'i'}}, {'album': {$regex : ?2, $options: 'i'}}, {'genre': {$regex : ?3, $options: 'i'}}]}")
  Stream<SongEntity> findByCriteria(String name, String interpreter, String album, String genre);
}
