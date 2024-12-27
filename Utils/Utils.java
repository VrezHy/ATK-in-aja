package Utils;

public class Utils {
  public static void printMenu(String[] options) {
      for (int i = 0; i < options.length; i++) {
          System.out.println((i+1) + ". " + options[i]);
      }
  }
}
