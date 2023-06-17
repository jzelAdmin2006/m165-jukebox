package tech.bison.trainee.server.persistence.domain.song;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongPersistence extends MongoRepository<SongEntity, UUID> {

}
