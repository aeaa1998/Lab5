import java.util.*;
import java.lang.*;
import java.text.*;

public class MoleculeSimulator{
    String type;
    String name;
    double experimentalResult;
    double hoursTaken;
    double numberOfAtoms;
    double specialNumber;
    double actualAverage;
    Map<String, Double> weights = new HashMap<String, Double>();
    Map<String, Double> hours = new HashMap<String, Double>();


    public MoleculeSimulator(){
        weights.put("Cromo-48", 47.95);
        weights.put("Oro-193", 192.96);
        weights.put("Uranio-240", 240.06);
        hours.put("Cromo-48", 21.561);
        hours.put("Oro-193", 17.65);
        hours.put("Uranio-240", 14.1);
        this.specialNumber = (6.0221413 * (Math.pow(10, 23)));
        this.setName();
        this.setProperties();
    }

    private void setName() {
        ArrayList<String> names = new ArrayList<String>(Arrays.asList("Cromo-48", "Oro-193", "Uranio-240"));
        this.name = Helpers.selectOptions(names);
    }



    private void setProperties(){
        ArrayList<String> types = new ArrayList<String>(Arrays.asList("gr", "mo", "na"));
        Scanner scan = new Scanner(System.in);
        Boolean bool = true;
        DecimalFormatSymbols decimalSymbols = new DecimalFormatSymbols(new Locale("en", "US"));
        decimalSymbols.setExponentSeparator("E");
        DecimalFormat decimalFormat = new DecimalFormat("##0.##E0", decimalSymbols);
        String type = "";
        String input = "";
        double finalVal = 0;
        while (bool){
            System.out.println("Ingrese un numero en el fromato xx.xE12gr o mo o na.\n");
            input = scan.nextLine();
            try{
                input = input.trim();
                int length = input.length();
                type = input.substring(length - 2);
                if (types.contains(type)){
                    input = input.replace(type, "");
                    if (input.indexOf('E') != -1){
                        finalVal = decimalFormat.parse(input).doubleValue();
                        bool = !bool;
                    }else{
                        System.out.println("Se escribe con el formato E.");
                    }
                }else{
                    System.out.println("Los tipos validos deben de ser gr (gramos), mo (moles) o na (número de átomos).");
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Ingrese mas de dos digitos.\n");
            } catch (ParseException e){
                System.out.println("Lo que ingreso no es parseable");
            }

        }
        this.type = type;
        getAtoms(finalVal);
        getAverageHour();
        simulate();
        doFormula();
    }

    private void getAtoms(Double finalVal){
        if (this.type.equalsIgnoreCase("gr")){
            this.numberOfAtoms = (finalVal/weights.get(this.name)) * this.specialNumber;
        } else if (this.type.equalsIgnoreCase("mo")){
            this.numberOfAtoms = finalVal * this.specialNumber;
        } else if (this.type.equalsIgnoreCase("na")){
            this.numberOfAtoms = finalVal;
        }
    }

    private void getAverageHour(){
        double hour = this.hours.get(this.name);
        double percentage = 50/hour;
        double number = Math.round(100/percentage);
        this.actualAverage = number;

    }

    private void simulate(){
        while(this.numberOfAtoms > 0){
            for (double i = 0; i < this.numberOfAtoms; i++) {
                int randomGotten = (int) (Math.random() * this.actualAverage + 1);
                int checkRandom = (int) (Math.random() * this.actualAverage + 1);
                if (randomGotten == checkRandom){
                    this.numberOfAtoms--;
                }
            }
            this.hoursTaken++;
        }
    }

    private void doFormula(){
        double exponent = (this.hoursTaken/this.hours.get(this.name));
        double number = this.numberOfAtoms;
        double multFactor = Math.pow((1/2), exponent);
        this.experimentalResult = number * multFactor;
    }

    public void showResults(){
        System.out.println("El  tiempo  obtenido  con  la  simulación  es  de " + this.hoursTaken  + " horas.");
        System.out.println("Según  la fórmula, el número de átomos que quedan luego de " + this.hoursTaken + " horas es " + Math.abs(this.experimentalResult));
        if (this.experimentalResult < 1){
            System.out.println("Fue exitoso");
        }else{
            System.out.println("No fue exitoso");
        }
    }
}