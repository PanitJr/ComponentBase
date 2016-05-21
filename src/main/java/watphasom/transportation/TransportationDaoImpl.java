package watphasom.transportation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import watphasom.repository.TransportationRepository;

/**
 * Created by panit on 5/19/2016.
 */
@Repository
public class TransportationDaoImpl implements TransportationDao{
    @Autowired
    TransportationRepository transportationRepository;
    @Override
    public Transportation create(Transportation transportation) {
        return transportationRepository.save(transportation);
    }

    @Override
    public Transportation update(Transportation transportation) {
        return transportationRepository.save(transportation);
    }
}
