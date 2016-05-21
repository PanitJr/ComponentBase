package watphasom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import watphasom.bankTranfer.BankTranfer;

/**
 * Created by panit on 5/19/2016.
 */
public interface BankTranferRepository extends MongoRepository<BankTranfer,String> {
}
