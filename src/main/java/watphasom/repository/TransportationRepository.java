package watphasom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import watphasom.transportation.Transportation;

/**
 * Created by panit on 5/19/2016.
 */
public interface TransportationRepository extends MongoRepository<Transportation,String> {
}
