package states.tmpl;

import states.State;
import vending.Money;
import vending.VendingMechine;

public class ReturnMoneyState implements State {
    @Override
    public void insertMoney(VendingMechine vm, Money money){
        vm.log("Currently in ReturnMoneyState...");
    }

    @Override
    public void selectItem(VendingMechine vm, String code, Integer quantity) {
        vm.log("Currently in ReturnMoneyState...");
    }


    @Override
    public void dispense(VendingMechine vm){
        vm.log("Currently in ReturnMoneyState...");
    }

    @Override
    public void returnMoney(VendingMechine vm){
        Integer currentBalance = vm.getCurrentBalance();
        vm.log("Returning the excess money... "+ currentBalance);
        vm.resetBalance();
        vm.setState(vm.getIdealState());
        vm.log("Moving to idleState....");
    }
}
