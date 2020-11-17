package Controller;

import Model.ShoppingList;
import Model.ShoppingListMaintenance;
import View.IOHelper;

public class ImportExport {
  private static final String baseFolder = "ImportExport";

  public static final void exportList(ShoppingList shoppingList) {
    // TODO 10 - Write Controller.ImportExport
    // Aaron Coccagna Github: newpolygons
    String listName = shoppingList.getName();
    String fullPath = IOHelper.readNonBlankStringFromKeyboard("File name (will write to 'ImportExport' folder in project): ");
    ShoppingListMaintenance.exportList(shoppingList, fullPath);
  }

  public static final ShoppingList importList() {
    String fileName = IOHelper.readNonBlankStringFromKeyboard("File Name (will read from 'ImportExport' folder in project)");
    ShoppingList imported = ShoppingListMaintenance.importList(baseFolder + "/" + fileName);
    return imported;
  }
}
