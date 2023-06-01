package gui;
public class GameBoard14 extends GameBoard {
    public GameBoard14() {
        super();
        PropertyCell blue1 = new PropertyCell();
        PropertyCell blue2 = new PropertyCell();
        PropertyCell blue3 = new PropertyCell();
        PropertyCell green1 = new PropertyCell();
        PropertyCell green2 = new PropertyCell();
        PropertyCell green3 = new PropertyCell();
        PropertyCell red1 = new PropertyCell();
        PropertyCell red2 = new PropertyCell();
        PropertyCell red3 = new PropertyCell();
        PropertyCell purple1 = new PropertyCell();
        PropertyCell purple2 = new PropertyCell();
        PropertyCell yellow1 = new PropertyCell();
        PropertyCell yellow2 = new PropertyCell();

        setBlueNames(blue1, blue2, blue3);
        setGreenNames(green1, green2, green3);
        setRedNames(red1, red2, red3);
        setPurpleNames(purple1, purple2);
        setYellowNames(yellow1, yellow2);

        setBluePrices(blue1, blue2, blue3);
        setGreenPrices(green1, green2, green3);
        setRedPrices(red1, red2, red3);
        setPurplePrices(purple1, purple2);
        setYellowPrices(yellow1, yellow2);


        setBlueRent(blue1, blue2, blue3);
        setGreenRent(green1, green2, green3);
        setRedRent(red1, red2, red3);
        setPurpleRent(purple1, purple2);
        setYellowRent(yellow1, yellow2);

        setBlueHPrice(blue1, blue2, blue3);
        setGreenHPrice(green1, green2, green3);
        setRedHPrice(red1, red2, red3);
        setPurpleHPrice(purple1, purple2);
        setYellowHPrice(yellow1, yellow2);

        addCells(blue1, blue2, blue3);
        addCells(green1, green2, green3);
        addCells(red1, red2, red3);
        addCells(purple1, purple2, yellow1);
        addCell(yellow2);
    }

    private void addCells(PropertyCell cell1, PropertyCell cell2,
                          PropertyCell cell3) {
        addCell(cell1);
        addCell(cell2);
        addCell(cell3);
    }

    private void setYellowHPrice(PropertyCell yellow1, PropertyCell yellow2) {
        yellow1.setHousePrice(70);
        yellow2.setHousePrice(70);
    }

    private void setPurpleHPrice(PropertyCell purple1, PropertyCell purple2) {
        purple1.setHousePrice(60);
        purple2.setHousePrice(60);
    }

    private void setRedHPrice(PropertyCell red1, PropertyCell red2,
                              PropertyCell red3) {
        red1.setHousePrice(50);
        red2.setHousePrice(50);
        red3.setHousePrice(50);
    }

    private void setGreenHPrice(PropertyCell green1, PropertyCell green2,
                                PropertyCell green3) {
        green1.setHousePrice(40);
        green2.setHousePrice(40);
        green3.setHousePrice(40);
    }

    private void setBlueHPrice(PropertyCell blue1, PropertyCell blue2,
                               PropertyCell blue3) {
        blue1.setHousePrice(30);
        blue2.setHousePrice(30);
        blue3.setHousePrice(30);
    }

    private void setYellowRent(PropertyCell yellow1, PropertyCell yellow2) {
        yellow1.setRent(40);
        yellow2.setRent(42);
    }

    private void setPurpleRent(PropertyCell purple1, PropertyCell purple2) {
        purple1.setRent(34);
        purple2.setRent(36);
    }

    private void setRedRent(PropertyCell red1, PropertyCell red2,
                            PropertyCell red3) {
        red1.setRent(30);
        red2.setRent(30);
        red3.setRent(32);
    }

    private void setGreenRent(PropertyCell green1, PropertyCell green2,
                              PropertyCell green3) {
        green1.setRent(20);
        green2.setRent(24);
        green3.setRent(26);
    }

    private void setBlueRent(PropertyCell blue1, PropertyCell blue2,
                             PropertyCell blue3) {
        blue1.setRent(10);
        blue2.setRent(10);
        blue3.setRent(12);
    }

    private void setYellowPrices(PropertyCell yellow1, PropertyCell yellow2) {
        yellow1.setPrice(400);
        yellow2.setPrice(420);
    }

    private void setPurplePrices(PropertyCell purple1, PropertyCell purple2) {
        purple1.setPrice(340);
        purple2.setPrice(360);
    }

    private void setRedPrices(PropertyCell red1, PropertyCell red2,
                              PropertyCell red3) {
        red1.setPrice(300);
        red2.setPrice(300);
        red3.setPrice(320);
    }

    private void setGreenPrices(PropertyCell green1, PropertyCell green2,
                                PropertyCell green3) {
        green1.setPrice(200);
        green2.setPrice(240);
        green3.setPrice(260);
    }

    private void setBluePrices(PropertyCell blue1, PropertyCell blue2,
                               PropertyCell blue3) {
        blue1.setPrice(100);
        blue2.setPrice(100);
        blue3.setPrice(120);
    }

    private void setYellowNames(PropertyCell yellow1, PropertyCell yellow2) {
        yellow1.setName("Yellow 1");
        yellow1.setColorGroup("yellow");
        yellow2.setName("Yellow 2");
        yellow2.setColorGroup("yellow");
    }

    private void setPurpleNames(PropertyCell purple1, PropertyCell purple2) {
        purple1.setName("Purple 1");
        purple1.setColorGroup("purple");
        purple2.setName("Purple 2");
        purple2.setColorGroup("purple");
    }

    private void setRedNames(PropertyCell red1, PropertyCell red2,
                             PropertyCell red3) {
        red1.setName("Red 1");
        red1.setColorGroup("red");
        red2.setName("Red 2");
        red2.setColorGroup("red");
        red3.setName("Red 3");
        red3.setColorGroup("red");
    }

    private void setGreenNames(PropertyCell green1, PropertyCell green2,
                               PropertyCell green3) {
        green1.setName("Green 1");
        green1.setColorGroup("green");
        green2.setName("Green 2");
        green2.setColorGroup("green");
        green3.setName("Green 3");
        green3.setColorGroup("green");
    }

    private void setBlueNames(PropertyCell blue1, PropertyCell blue2,
                              PropertyCell blue3) {
        blue1.setName("Blue 1");
        blue1.setColorGroup("blue");
        blue2.setName("Blue 2");
        blue2.setColorGroup("blue");
        blue3.setName("Blue 3");
        blue3.setColorGroup("blue");
    }
}
