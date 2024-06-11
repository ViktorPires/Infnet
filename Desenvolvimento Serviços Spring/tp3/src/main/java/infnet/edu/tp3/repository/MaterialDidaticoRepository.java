package infnet.edu.tp3.repository;

import infnet.edu.tp3.model.MaterialDidatico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico, String> {
}
