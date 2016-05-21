package watphasom.bankTranfer;

/**
 * Created by panit on 5/19/2016.
 */
public interface BankTranferDao {
    BankTranfer create(BankTranfer bankTranfer);
    BankTranfer update(BankTranfer bankTranfer);
    BankTranfer getOne(String id);
}
