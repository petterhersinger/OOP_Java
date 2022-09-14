package fordon;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Garage {

    private String adress;
    private ArrayList<Fordon> fordonspark;

    Garage (String adress) {
        this.adress = adress;
        fordonspark = new ArrayList<>();
    }
    public void laggTillFordon(Fordon f) {
        fordonspark.add(f);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Garaget på "
                + adress
                + " innehåller följande fordon: \n");
        for(Fordon f : fordonspark){
            sb.append(f + "\n");
        }
        return sb.toString();
    }
}
