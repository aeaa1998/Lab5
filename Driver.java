import java.util.*;
import java.lang.*;
import java.text.*;

class Driver{
    public static void main(String[] args) throws CloneNotSupportedException{
//        ArrayList<String> names = new ArrayList<String>(Arrays.asList("Cromo-48", "Oro-193", "Uranio-240"));
//        String name = Helpers.selectOptions(names);
        MoleculeSimulator simulator =  new MoleculeSimulator();
        simulator.showResults();
    }


}