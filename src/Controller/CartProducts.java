package Controller;

import Model.Product;
import Model.ShoppingList;
import View.ProductDisplay;

public class CartProducts {
  public static void cartProducts(ShoppingList shoppingList) {
    ProductDisplay productDisplay = product -> (product.getInCart() ? "+" : "-") + product.getName();

    System.out.println();
    System.out.println("+ means it's in the cart");
    System.out.println("- means it's NOT in the cart");
    while (true) {
      Product product = ChooseProduct.chooseProduct(shoppingList, productDisplay);
      if (product == null) {
        break;
      }
      product.setInCart(true); //puts product in cart when user selects a product in list
      //(Amal Sabirov | email:ajs7540@psu.edu | github: ajs7540)
      // TODO 04 - Add the missing line in Controller.CartProducts.cartProducts
    }


  }
}
