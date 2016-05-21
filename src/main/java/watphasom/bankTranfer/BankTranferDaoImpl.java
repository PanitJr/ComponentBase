package watphasom.bankTranfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import watphasom.repository.BankTranferRepository;

/**
 * Created by panit on 5/19/2016.
 */
@Repository
public class BankTranferDaoImpl implements BankTranferDao {
    @Autowired
    BankTranferRepository bankTranferRepository;
    @Override
    public BankTranfer create(BankTranfer bankTranfer) {
        return bankTranferRepository.save(bankTranfer);
    }

    @Override
    public BankTranfer update(BankTranfer bankTranfer) {
        return bankTranferRepository.save(bankTranfer);
    }

    @Override
    public BankTranfer getOne(String id) {
        return bankTranferRepository.findOne(id);
    }
}
