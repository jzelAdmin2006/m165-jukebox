package tech.bison.trainee.server.persistence.domain.song;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongPersistence extends MongoRepository<SongEntity, Integer> {

}
