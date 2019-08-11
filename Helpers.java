import java.util.*;
import java.lang.*;
import java.text.*;


public final class Helpers {

    public static double doubleInput(Scanner scanner, String text, String text2, Double minimum){
        Boolean valid = true;
        double value = 0.0;
        while (valid)
        {
            System.out.println(text);
            String valueString = scanner.nextLine();
            try{
                value = Float.parseFloat(valueString);
                valid = value <= 0.0 || value < minimum;
                if (valid == true) {
                    System.out.println(text2);
                }
            }
            catch (Exception e) {
                System.out.println("Ingrese un valor double");
            }
        }
        return value;
    }

    public static float floatInput(Scanner scanner, String text, String text2, Float minimum){
        Boolean valid = true;
        float value = 0f;
        while (valid)
        {
            System.out.println(text);
            String valueString = scanner.nextLine();
            try{
                value = Float.parseFloat(valueString);
                valid = value <= 0f || value < minimum;
                if (valid == true) {
                    System.out.println(text2);
                }
            }
            catch (Exception e) {
                System.out.println("Ingrese un valor float");
            }
        }
        return value;
    }

    public static float floatInput(Scanner scanner, String text){
        Boolean valid = true;
        float value = 0f;
        while (valid)
        {
            System.out.println(text);
            String valueString = scanner.nextLine();
            try{
                value = Float.parseFloat(valueString);
                valid = !valid;
            }
            catch (Exception e) {
                System.out.println("Ingrese un valor float");
            }
        }
        return value;
    }

    public static int intInput(Scanner scanner, String text, String text2, int minimum){
        Boolean valid = true;
        int value = 0;
        while (valid)
        {
            System.out.println(text);
            String valueString = scanner.nextLine();
            try{
                value = Integer.parseInt(valueString);
                valid = value <= 0 || value < minimum;
                if (valid == true) {
                    System.out.println(text2);
                }
            }
            catch (Exception e) {
                System.out.println("Ingrese un valor integer");
            }
        }
        return value;
    }
    public static int intPositiveInput(Scanner scanner, String text, String text2){
        Boolean valid = true;
        int value = 0;
        while (valid)
        {
            System.out.println(text);
            String valueString = scanner.nextLine();
            try{
                value = Integer.parseInt(valueString);
                valid = value <= 0;
                if (valid == true) {
                    System.out.println(text2);
                }
            }
            catch (Exception e) {
                System.out.println("Ingrese un valor integer");
            }
        }
        return value;
    }

    public static int intPositiveInput(Scanner scanner, String text, String text2, int _maximum){
        Boolean valid = true;
        int value = 0;
        while (valid)
        {
            System.out.println(text);
            String valueString = scanner.nextLine();
            try{
                value = Integer.parseInt(valueString);
                valid = value <= 0 || value > _maximum;
                if (valid == true) {
                    System.out.println(text2);
                }
            }
            catch (Exception e) {
                System.out.println("Ingrese un valor integer");
            }
        }
        return value;
    }

    public static int intInput(Scanner scanner, String text){
        Boolean valid = true;
        int value = 0;
        while (valid)
        {
            System.out.println(text);
            String valueString = scanner.nextLine();
            try{
                value = Integer.parseInt(valueString);
                valid = !valid;
            }
            catch (Exception e) {
                System.out.println("Ingrese un valor integer");
            }
        }
        return value;
    }

    public static String selectOptions(ArrayList<String> arrayList){
        Scanner scan = new Scanner(System.in);
        String input = "";
        while (!arrayList.contains(input)){
            System.out.println("Ingrese una de las opciones\n");
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println((i+1) + ") " + arrayList.get(i) + "\n");
            }
            input = scan.nextLine();
            if (!arrayList.contains(input)){
                System.out.println("Ingrese una opcion valida\n");
            }
        }
        return input;
    }

    public static String selectOptions(String[] texts, String textsDisplay){
        Scanner scanner = new Scanner(System.in);
        Boolean valid = true;
        String value = "";
        while (valid == true)
        {
            System.out.println("Ingrese una opcion valida de texto\n" + textsDisplay +":\n");
            for (int i = 0; i < texts.length; i++) {
                String x = texts[i];
                System.out.print((i+1) + ". " + x + "\n");
            }
            value = scanner.nextLine();
            value = value.trim();
            valid = !Arrays.asList(texts).contains(value);
            if (valid == true) {
                System.out.println("Ingreso una opcion invalida.\n");
            }
        }
        return value;
    }

}