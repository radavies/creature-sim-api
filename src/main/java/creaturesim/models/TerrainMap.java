package creaturesim.models;

import java.util.ArrayList;

public class TerrainMap {

    private ArrayList<ArrayList<String>> map;

    public ArrayList<ArrayList<String>> getMap(){
        return map;
    }

    public TerrainMap(){
        map = new ArrayList<>();
        generateWorld();
    }

    private void generateWorld(){
        ArrayList<String> rowOne = new ArrayList<>();
        rowOne.add("M");
        rowOne.add("M");
        rowOne.add("M");
        rowOne.add("M");
        rowOne.add("M");
        rowOne.add("M");
        rowOne.add("M");
        rowOne.add("M");
        rowOne.add("W");
        rowOne.add("W");

        ArrayList<String> rowTwo = new ArrayList<>();
        rowTwo.add("M");
        rowTwo.add("M");
        rowTwo.add("M");
        rowTwo.add("M");
        rowTwo.add("M");
        rowTwo.add("H");
        rowTwo.add("H");
        rowTwo.add("H");
        rowTwo.add("W");
        rowTwo.add("W");

        ArrayList<String> rowThree = new ArrayList<>();
        rowThree.add("M");
        rowThree.add("H");
        rowThree.add("H");
        rowThree.add("H");
        rowThree.add("H");
        rowThree.add("H");
        rowThree.add("H");
        rowThree.add("H");
        rowThree.add("H");
        rowThree.add("W");

        ArrayList<String> rowFour = new ArrayList<>();
        rowFour.add("H");
        rowFour.add("H");
        rowFour.add("H");
        rowFour.add("P");
        rowFour.add("P");
        rowFour.add("H");
        rowFour.add("P");
        rowFour.add("P");
        rowFour.add("P");
        rowFour.add("H");

        ArrayList<String> rowFive = new ArrayList<>();
        rowFive.add("P");
        rowFive.add("P");
        rowFive.add("P");
        rowFive.add("P");
        rowFive.add("P");
        rowFive.add("P");
        rowFive.add("P");
        rowFive.add("P");
        rowFive.add("P");
        rowFive.add("P");

        ArrayList<String> rowSix = new ArrayList<>();
        rowSix.add("P");
        rowSix.add("P");
        rowSix.add("P");
        rowSix.add("P");
        rowSix.add("P");
        rowSix.add("P");
        rowSix.add("P");
        rowSix.add("P");
        rowSix.add("P");
        rowSix.add("P");

        ArrayList<String> rowSeven = new ArrayList<>();
        rowSeven.add("P");
        rowSeven.add("P");
        rowSeven.add("P");
        rowSeven.add("P");
        rowSeven.add("W");
        rowSeven.add("P");
        rowSeven.add("P");
        rowSeven.add("P");
        rowSeven.add("P");
        rowSeven.add("P");

        ArrayList<String> rowEight = new ArrayList<>();
        rowEight.add("P");
        rowEight.add("P");
        rowEight.add("P");
        rowEight.add("W");
        rowEight.add("W");
        rowEight.add("W");
        rowEight.add("P");
        rowEight.add("P");
        rowEight.add("P");
        rowEight.add("P");

        ArrayList<String> rowNine = new ArrayList<>();
        rowNine.add("P");
        rowNine.add("P");
        rowNine.add("P");
        rowNine.add("P");
        rowNine.add("D");
        rowNine.add("D");
        rowNine.add("D");
        rowNine.add("D");
        rowNine.add("D");
        rowNine.add("D");

        ArrayList<String> rowTen = new ArrayList<>();
        rowTen.add("D");
        rowTen.add("D");
        rowTen.add("D");
        rowTen.add("D");
        rowTen.add("D");
        rowTen.add("D");
        rowTen.add("D");
        rowTen.add("D");
        rowTen.add("D");
        rowTen.add("D");

        map.add(rowOne);
        map.add(rowTwo);
        map.add(rowThree);
        map.add(rowFour);
        map.add(rowFive);
        map.add(rowSix);
        map.add(rowSeven);
        map.add(rowEight);
        map.add(rowNine);
        map.add(rowTen);
    }
}
