package watphasom.transportation;

import java.util.List;

/**
 * Created by panit on 5/19/2016.
 */
public interface TransportationTypeDao {
    TransportationType findByName(String name);
    List<TransportationType> findAll();
}
