package states.tmpl;

import inventory.Inventory;
import states.State;
import vending.DispensiveItem;
import vending.Money;
import vending.VendingMechine;

public class DispensingState implements State {
    @Override
    public void insertMoney(VendingMechine vm, Money money){
        vm.log("Currently in DispensingState...");

    }

    @Override
    public void selectItem(VendingMechine vm, String code, Integer quantity) {
        vm.log("Currently in DispensingState...");
    }


    @Override
    public void dispense(VendingMechine vm){
        Inventory inventory = vm.getInventory();
        DispensiveItem pendingItem = vm.getPendingItem();
        if(pendingItem == null){
            vm.log("No item do dispense");
            return ;
        }
        inventory.dispenseItem(pendingItem.item(),pendingItem.quantity());
        Integer currentBalance = vm.getCurrentBalance();
        vm.clearPendingItem();
        vm.log("item dispense successful: "+ pendingItem.item());
        if(currentBalance > 0){
            vm.setState(vm.getReturnMoneyState());
            vm.log(currentBalance+" this extra money needs to be returned...");
            vm.log("Moving returnMoney states....");
        }
        else{
            vm.setState(vm.getIdealState());
            vm.log("Moving to ideal State....");
        }
    }

    @Override
    public void returnMoney(VendingMechine vm){
        vm.log("Currently in DispensingState...");
    }
}
