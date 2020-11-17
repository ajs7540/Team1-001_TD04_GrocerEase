package Controller;

import Model.Product;
import Model.ShoppingList;
import org.apache.log4j.*;


public class DeleteProducts {
  // TODO 09 - DeleteProducts: Make a debug log entry for each item deleted (See GrocerEase.log sample in assignment)
  // Aaron Coccagna | email: azc5793@psu.edu | Github : newpolygons
  private static final Logger logger = LogManager.getRootLogger();


  public static void deleteProducts(ShoppingList shoppingList) {
    while (true) {
      Product product = ChooseProduct.chooseProduct(shoppingList, p -> p.getName());
      logger.log(Level.DEBUG, "Deleted item " + product.getName() + "from list" + shoppingList.getName());
      if (product == null) {
        break;
      }
      shoppingList.removeProduct(product);

    }
  }
}
