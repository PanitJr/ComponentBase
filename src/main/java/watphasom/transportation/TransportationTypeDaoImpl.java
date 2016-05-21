package watphasom.transportation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import watphasom.repository.TransportationTypeRepository;

import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
@Repository
public class TransportationTypeDaoImpl implements TransportationTypeDao{
    @Autowired
    TransportationTypeRepository transportationTypeRepository;

    @Override
    public TransportationType findByName(String name) {
        return transportationTypeRepository.findByName(name);
    }

    @Override
    public List<TransportationType> findAll() {
        return transportationTypeRepository.findAll();
    }
}
