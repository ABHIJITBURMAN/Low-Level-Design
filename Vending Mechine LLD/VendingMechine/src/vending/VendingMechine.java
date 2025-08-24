package vending;

import inventory.Inventory;
import inventory.Item;
import states.State;
import states.tmpl.DispensingState;
import states.tmpl.HasMoneyState;
import states.tmpl.IdleState;
import states.tmpl.ReturnMoneyState;

public class VendingMechine {

    private final State idealState = new IdleState();
    private final State hasMoneyState = new HasMoneyState();
    private final State dispensiveState = new DispensingState();

    private final State returnMoneyState = new ReturnMoneyState();

    public VendingMechine(Inventory inventory) {
        this.inventory = inventory;
        this.currentState = idealState;
        this.currentBalance = 0;
    }

    public State getIdealState(){
        return idealState;
    }
    public State getHasMoneyState(){
        return hasMoneyState;
    }
    public State getDispensiveState(){
        return dispensiveState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public State getReturnMoneyState(){
        return returnMoneyState;
    }
    private final Inventory inventory;

    // veriables of vending meching
    private State currentState;
    private Integer currentBalance;
    private DispensiveItem pendingItem;




    public void setState(State s) { this.currentState = s; }
    public void addBalance(int c) { currentBalance += c; }
    public void deductBalance(int c) { currentBalance -= c; }
    public void resetBalance() { currentBalance = 0; }

    public Integer getCurrentBalance() { return  currentBalance;}
    public void setPendingItem(Item item, Integer quantity) {
        pendingItem = new DispensiveItem(item,quantity);
    }
    public DispensiveItem getPendingItem() { return pendingItem; }
    public void clearPendingItem() { pendingItem = null; }

    public Inventory getInventory(){
        return inventory;
    }
    public void log(String msg) { System.out.println("[VM] " + msg); }




    // public methods
    public void insertMoney(Money money){
        currentState.insertMoney(this,money);
    }

    public void selectItem(String code, Integer quantity ) {
        currentState.selectItem(this,code, quantity);
    }

    public void dispenseItem() {
        currentState.dispense(this);
    }

    public void returnChange() {
        currentState.returnMoney(this);
    }


}
