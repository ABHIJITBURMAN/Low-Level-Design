import inventory.Inventory;
import inventory.Item;
import vending.Money;
import vending.VendingMechine;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addItem(new Item("Chips", "A12epX", 120), 9);
        inv.addItem(new Item("Soda", "p34rYz", 75), 1);

        VendingMechine vm  = new VendingMechine(inv);


        // --- Scenario 1: Exact amount, no change
        System.out.println("\n--- Scenario 1: Exact amount ---");
        vm.insertMoney(new Money("INR", 120));
        vm.selectItem("A12epX", 1);
        vm.dispenseItem();          // item out
        vm.returnChange();      // no-op in Idle


        System.out.println("\n--- Scenario 2: Extra amount ---");
        vm.insertMoney(new Money("INR", 300));
        vm.selectItem("A12epX", 1);
        vm.dispenseItem();          // item out
        vm.returnChange();

        System.out.println("\n--- Scenario 3: Invalid item select ---");
        vm.insertMoney(new Money("INR", 300));
        vm.selectItem("raR65Xt", 1);
        vm.dispenseItem();          // item out
        vm.returnChange();

        System.out.println("\n--- Scenario 4: Insufficient balance ---");
        vm.selectItem("A12epX", 5);
        vm.dispenseItem();          // item out
        vm.returnChange();

    }
}