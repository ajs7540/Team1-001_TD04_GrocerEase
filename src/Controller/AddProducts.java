package Controller;

import Model.Product;
import Model.ShoppingList;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AddProducts {
  // TODO 08 - AddProducts: Make a debug log entry for each item added (See GrocerEase.log sample in assignment)
  // Rickey Patel | email: rpp5069@psu.edu | Github : rpp5069

  private static final Logger logger = LogManager.getRootLogger();

  public static void addProducts(ShoppingList shoppingList) {
    // TODO 05 - Write Controller.AddProducts.addProducts (Hint: this can be done in 6 lines)
    //John Meskill || email: jpm6210@psu.edu || Github : johnh2352
    while (true) {
      Product product = ChooseProduct.chooseProduct(shoppingList, p -> p.getName());
      logger.log(Level.DEBUG, "Added item " + product.getName() + "to list" + shoppingList.getName());
      if (product == null) {
        break;
      }

      EditProducts.editOneProduct(product);
      shoppingList.addProduct(product);
      //THIS METHOD IS INCOMPLETE

      /*
       * Repeatedly have the user add new products until they're done
       */

    }
  }
}
