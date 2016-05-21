package watphasom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import watphasom.transportation.TransportationType;

/**
 * Created by panit on 5/19/2016.
 */
public interface TransportationTypeRepository extends MongoRepository<TransportationType,String> {
    TransportationType findByName(String name);
}
