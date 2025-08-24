package states;

import vending.Money;
import vending.VendingMechine;

public interface State {
    void insertMoney(VendingMechine vm, Money money);
    void selectItem(VendingMechine vm, String code, Integer quantity);
    void dispense(VendingMechine vm);
    void returnMoney(VendingMechine vm);
}
