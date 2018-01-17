import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public String checkYourself(String userInput) {

        String result = "miss";

        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index); //删除已命中的格子

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk "+name+" :( ");
            } else {
                result = "hit";
            }
        }

//        System.out.println(result);

        return result;
    }
}
