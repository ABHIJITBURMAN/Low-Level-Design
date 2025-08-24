package states.tmpl;

import inventory.Inventory;
import inventory.Item;
import states.State;
import vending.Money;
import vending.VendingMechine;

public class HasMoneyState implements State {
    @Override
    public void insertMoney(VendingMechine vm, Money money){
        vm.log("Currently in HasMoneyState...");
    }

    @Override
    public void selectItem(VendingMechine vm, String code, Integer quantity) {
        Inventory inventory = vm.getInventory();
        Item item = inventory.getItemByCode(code);
        if(item == null){
            vm.log("Select a valid item......");
            return ;
        }
        if(!inventory.checkStock(item, quantity)){
            vm.log("Please select a less quantity");
            return ;
        }
        Integer currentBalance = vm.getCurrentBalance();
        Integer totalBalance = item.price()*quantity;
        if(currentBalance < totalBalance){
            int shortfall = totalBalance - currentBalance;
            vm.log("Insufficient balance. Add " + shortfall + " INR more.");
        }
        else{
            vm.setPendingItem(item, quantity);
            vm.deductBalance(totalBalance);
            vm.setState(vm.getDispensiveState());
            vm.log("successfully deduct money and Item is ready to dispense: "
                    +item.name()+" "+item.code()+" "+quantity);
            vm.log("moving to dispense state");
        }
    }


    @Override
    public void dispense(VendingMechine vm){
        vm.log("Currently in HasMoneyState...");
    }

    @Override
    public void returnMoney(VendingMechine vm){
        vm.log("Currently in HasMoneyState...");
    }
}
