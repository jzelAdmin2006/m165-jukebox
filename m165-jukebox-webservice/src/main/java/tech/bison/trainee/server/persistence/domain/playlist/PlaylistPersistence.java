package tech.bison.trainee.server.persistence.domain.playlist;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistPersistence extends MongoRepository<PlaylistEntity, Integer> {

}
