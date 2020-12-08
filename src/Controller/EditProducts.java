package Controller;

import Model.Obj;
import Model.Product;
import Model.ShoppingList;
import Model.UnitOfMeasure;
import View.IOHelper;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EditProducts {
  public static void editProducts(ShoppingList shoppingList) {
    Product product = ChooseProduct.chooseProduct(shoppingList, p -> p.getName());
    editOneProduct(product);
  }

  public static void editOneProduct(Product product) {
    Menu menu = new Menu("Edit the Values");
    MenuChoice mcEditName = menu.addMenuChoice("");
    MenuChoice mcEditQuantity = menu.addMenuChoice("");
    MenuChoice mcEditUOM = menu.addMenuChoice("");
    MenuChoice mcEditPrice = menu.addMenuChoice("");
    // TODO 06 - Controller.EditProducts.editOneProduct: handle quantity, uom, and price(FINISHED)
    //John Meskill || email: jpm6210@psu.edu || Github : johnh2352

    MenuDisplay menuDisplay = new MenuDisplay(menu);
    while (true) {
      mcEditName.setText("Name: " + Obj.coalesce(product.getName(), "<not set>"));
      mcEditQuantity.setText("Quantity: " + product.getQuantity());
      mcEditUOM.setText("UOM: " + product.getUom() );
      mcEditPrice.setText("Price: " + product.getPrice());

      MenuChoice menuChoice = menuDisplay.displayAndChoose();
      if (menuChoice == menu.getMenuChoiceQuit()) {
        return;
      }

      if (menuChoice == mcEditName) {
        product.setName(IOHelper.readNonBlankStringFromKeyboard("Name"));
      }
      if (menuChoice == mcEditQuantity) {
        product.setQuantity(IOHelper.userInputDouble("Quantity"));
      }
      if (menuChoice == mcEditUOM) {

        List<String> uomChoices = new ArrayList<String>();
        for (UnitOfMeasure uom : UnitOfMeasure.values()) {
          uomChoices.add(uom.toString());
        }

        String chosenUomString = IOHelper.readValidInputFromList("UOM", uomChoices, false);
        UnitOfMeasure chosenUom = UnitOfMeasure.valueOf(chosenUomString);
        product.setUom(chosenUom);
        }
      if (menuChoice == mcEditPrice) {
        product.setPrice(IOHelper.userInputDouble("Price"));
      }
    }
  }
}
