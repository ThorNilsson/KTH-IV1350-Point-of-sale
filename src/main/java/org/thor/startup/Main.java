package org.thor.startup;

import org.thor.controller.Controller;
import org.thor.integration.*;
import org.thor.model.InventoryCatalog;
import org.thor.view.View;

/**
 * Hello world!
 */
public class Main {

    public static void main(String[] args) {

        Register register = new Register();

        ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();

        ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();

        Printer printer = new Printer();

        InventoryCatalog inventoryCatalog = new InventoryCatalog();

        DiscountCatalog discountCatalog = new DiscountCatalog();


        System.out.println("Program Startup");

        Controller controller = new Controller(register, externalAccountingSystem, externalInventorySystem,
                printer, inventoryCatalog, discountCatalog);
        View view = new View(controller);

        view.view();
    }
}
