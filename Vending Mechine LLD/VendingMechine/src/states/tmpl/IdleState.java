package states.tmpl;

import states.State;
import vending.Money;
import vending.VendingMechine;

public class IdleState implements State {
    @Override
    public void insertMoney(VendingMechine vm, Money money){
        vm.addBalance(money.cents());
        vm.setState(vm.getHasMoneyState());
        vm.log(money.cents()+" money has been successfully added...");
        vm.log("Moving to hasMoney state....");
    }

    @Override
    public void selectItem(VendingMechine vm, String code, Integer quantity) {
        vm.log("Currently in IdelState...");
    }


    @Override
    public void dispense(VendingMechine vm){
        vm.log("Currently in IdelState...");
    }

    @Override
    public void returnMoney(VendingMechine vm){
        vm.log("Currently in IdelState...");
    }
}
