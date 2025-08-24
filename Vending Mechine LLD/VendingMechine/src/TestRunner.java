
import inventory.Inventory;
import inventory.Item;
import states.State;
import vending.Money;
import vending.VendingMechine;

public class TestRunner {
    public static void main(String[] args) {
        testExactPayment();
        testOverPayment();
        testCancel();
    }

    static void testExactPayment() {
        Inventory inv = new Inventory();
        inv.addItem(new Item("Soda", "A1", 120), 1);
        VendingMechine vm = new VendingMechine(inv);
        State expectedState = vm.getIdealState();

        vm.insertMoney(new Money("INR", 120));
        vm.selectItem("A1", 1);
        vm.dispenseItem();

        if (vm.getCurrentBalance() == 0 && vm.getCurrentState() == expectedState) {
            System.out.println("✅ testExactPayment PASSED");
        } else {
            System.out.println("❌ testExactPayment FAILED");
        }
    }

    static void testOverPayment() {
        Inventory inv = new Inventory();
        inv.addItem(new Item("Chips", "B1", 100), 1);

        VendingMechine vm = new VendingMechine(inv);
        State expectedState = vm.getIdealState();
        vm.insertMoney(new Money("INR", 200));
        vm.selectItem("B1", 1);
        vm.dispenseItem();
        vm.returnChange();

        if (vm.getCurrentBalance() == 0 && vm.getCurrentState() == expectedState) {
            System.out.println("✅ testOverPayment PASSED");
        } else {
            System.out.println("❌ testOverPayment FAILED");
        }
    }

    static void testCancel() {
        Inventory inv = new Inventory();
        inv.addItem(new Item("C1", "Juice", 150), 1);

        VendingMechine vm = new VendingMechine(inv);
        State expectedState = vm.getHasMoneyState();
        vm.insertMoney(new Money("INR", 100));

        if (vm.getCurrentBalance() == 100 && vm.getCurrentState() == expectedState) {
            System.out.println("✅ testCancel PASSED");
        } else {
            System.out.println("❌ testCancel FAILED");
        }
    }
}
