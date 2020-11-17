package Controller;

import Model.Obj;
import Model.Product;
import Model.ShoppingList;
import Model.UnitOfMeasure;
import View.IOHelper;
import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

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
      mcEditQuantity.setText("Quantity: " + Obj.coalesce(product.getQuantity(), "<0.0>"));
      mcEditUOM.setText("UOM: " + Obj.coalesce(product.getUom(), "<not set>"));
      mcEditPrice.setText("Price: " + Obj.coalesce(product.getPrice(), "<0.00>"));

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
        Scanner choiceInput = new Scanner(System.in);
        System.out.print("UOM (EA/GAL/LB/BAG/BOX/CARTON) : ");
        String choice = choiceInput.nextLine();
        if(choice.equals("EA")){
          product.setUom(UnitOfMeasure.EA);
        }
        else if(choice.equals("GAL")){
          product.setUom(UnitOfMeasure.GAL);
        }
        else if(choice.equals("LB")){
          product.setUom(UnitOfMeasure.LB);
        }
        else if(choice.equals("BAG")){
          product.setUom(UnitOfMeasure.BAG);
        }
        else if(choice.equals("BOX")){
          product.setUom(UnitOfMeasure.BOX);
        }
        else if(choice.equals("CARTON")){
          product.setUom(UnitOfMeasure.CARTON);
        }
        else{
          System.out.println("Enter a valid value!");
        }
      }
      if (menuChoice == mcEditPrice) {
        product.setPrice(IOHelper.userInputDouble("Price"));
      }
    }
  }
}
