package SettingWindow;

import java.io.Serializable;

public class SquareFactory implements Serializable {
    private static SquareFactory _instance;

    private SquareFactory() {

    }

    public static SquareFactory getInstance() {
        if(_instance == null) {
            _instance = new SquareFactory();
        }
        return _instance;
    }
    public String[] squareNames = {"Go","Bình Thuận","MiniGame","Ninh Thuận","InComeTax","Beach","Long An","Chance"
    ,"Tiền Giang","Trà Vinh", "Jail","Đắk Lắk","Beach","Kon Tum","Gia Lai","MiniGame","Khánh Hòa","Chance","Quảng Ngãi"
    ,"Nghệ An","Festival","Bắc Ninh","Chance","Phú Thọ","Hải Phòng","MiniGame","Cần Thơ","Nha Trang","Beach","Sa Pa"
    ,"Bus Station","Đà Lạt","Đà Nẵng","Beach","Huế","MiniGame","Chance","Hà Nội","InComeTax","Sài Gòn"};

    int BinhThuanPrice = 30;
    int NinhThuậnPrice = 40;

    int LongAnPrice = 90;
    int TienGiangPrice = 90;
    int TraVinhPrice = 120;
    int DakLakPrice = 140;
    int GiaLaiPrice = 150;

    int KonTumPrice = 160;
    int KhanhHoaPrice = 170;
    int QuangNgaiPrice = 180;
    int NgheAnPrice = 210;
    int BacNinhPrice = 210;
    int PhuThoPrice = 240;
    int HaiPhongPrice = 250;
    int CanThoPrice = 270;
    int NhaTrangPrice = 300;
    int SaPaPrice = 320;
    int DaLatPrice = 330;
    int DaNangPrice = 360;
    int HuePrice = 360;
    int HaNoiPrice = 390;
    int SaiGonPrice = 420;

    int[] BinhThuanList = { 45,  80, 125, 625};
    int[] NinhThuanList = BinhThuanList;
    int[] LongAnList = {45, 120,  350, 850};
    int[] TienGiangList = { 80, 225, 600, 1000};
    int[] TraVinhList = { 100, 300,  600, 1100};
    int[] DakLakList = { 160, 475,  800, 1300};
    int[] KonTumList = DakLakList;
    int[] GiaLaiList = { 200, 550, 950, 1450};
    int[] KhanhHoaList = { 240, 670, 1025, 1525};

    int[] QuangNgaiList = { 300, 750,  1100, 1600};

    int[] NgheAnList = { 345, 825,  1180, 2180};
    int[] BacNinhList = { 390, 900, 1275, 2275};

    int[] PhuThoList = {470, 1050,  1500, 2500};

    int[] HaiPhongList = {520, 1125,  1605, 2800 };
    int[] CanThoList = { 575, 1300, 1700, 3000};
    int[] NhaTrangList = {600,1375,1785, 3250};
    int[] SaPaList = { 630, 1450,2050, 3550};
    int[] DaLatList = {700,1500,2100,3675};

    int[] DaNangList = { 750, 1600,  2300, 3850};
    int[] HueList = { 825, 1800,  2550, 4050};
    int[] HaNoiList = { 900, 2000,  3000, 4500};
    int[] SaiGonList = { 1000, 2200,  3300, 5000};

    String BinhThuanColor = "Brown";
    String NinhThuanColor = "Brown";
    String LongAnColor = "Light Blue";
    String TienGiangColor = "Light Blue";
    String TraVinhColor = "Light Blue";

    String DakLakColor = "Pink";
    String KonTumColor = "Pink";
    String GiaLaiColor = "Pink";

    String KhanhHoaColor = "Orange";
    String QuangNgaiColor = "Orange";
    String NgheAnColor = "Orange";

    String BacNinhColor = "Red";
    String PhuThoColor = "Red";
    String HaiPhongColor = "Red";

    String CanThoColor = "Green";
    String NhaTrangColor = "Green";
    String SaPaColor = "Green";
    

    String DaLatColor = "Green";
    String DaNangColor = "Green";
    String HueColor = "Green";

    String HaNoiColor = "Blue";
    String SaiGonColor = "Blue";


    public Square createOuterSquares(int index) {
        switch (index) {
            case 0:
                return new GoSquare(squareNames[index], "Go Square");
            case 1:
                return new PropertySquare(squareNames[index], "Property Square",BinhThuanPrice,BinhThuanColor,BinhThuanList);
            case 2, 15, 25, 35:
                return new MiniGame(squareNames[index], "MiniGame");
            case 3:
                return new PropertySquare(squareNames[index], "Property Square",NinhThuậnPrice,NinhThuanColor,NinhThuanList);
            case 4, 38:
                return new TaxSquare(squareNames[index], "Tax Square");
            case 5, 12, 28, 33:
                return new Beach(squareNames[index], "Beach");
            case 6:
                return new PropertySquare(squareNames[index], "Property Square",LongAnPrice,LongAnColor,LongAnList);
            case 7, 17, 22, 36:
                return new ChanceCardSquare(squareNames[index], "Chance Square");
            case 8:
                return new PropertySquare(squareNames[index], "Property Square",TienGiangPrice,TienGiangColor,TienGiangList);
            case 9:
                return new PropertySquare(squareNames[index], "Property Square",TraVinhPrice,TraVinhColor,TraVinhList);
            case 11:
                return new PropertySquare(squareNames[index], "Property Square",DakLakPrice,DakLakColor,DakLakList);
            case 13:
                return new PropertySquare(squareNames[index], "Property Square",KonTumPrice,KonTumColor,KonTumList);
            case 14:
                return new PropertySquare(squareNames[index], "Property Square",GiaLaiPrice,GiaLaiColor,GiaLaiList);
            case 16:
                return new PropertySquare(squareNames[index], "Property Square",KhanhHoaPrice,KhanhHoaColor,KhanhHoaList);
            case 18:
                return new PropertySquare(squareNames[index], "Property Square",QuangNgaiPrice,QuangNgaiColor,QuangNgaiList);
            case 19:
                return new PropertySquare(squareNames[index], "Property Square",NgheAnPrice,NgheAnColor,NgheAnList);
            case 21:
                return new PropertySquare(squareNames[index], "Property Square",BacNinhPrice,BacNinhColor,BacNinhList);
            case 23:
                return new PropertySquare(squareNames[index], "Property Square",PhuThoPrice,PhuThoColor,PhuThoList);
            case 24:
                return new PropertySquare(squareNames[index], "Property Square",HaiPhongPrice,HaiPhongColor,HaiPhongList);
            case 26:
                return new PropertySquare(squareNames[index], "Property Square",CanThoPrice,CanThoColor,CanThoList);
            case 27:
                return new PropertySquare(squareNames [index],"Property Square",NhaTrangPrice,NhaTrangColor,NhaTrangList);
            case 29:
                return new PropertySquare(squareNames [index],"Property Square",SaPaPrice,SaPaColor,SaPaList);
            case 31:
                return new PropertySquare(squareNames [index],"Property Square",DaLatPrice,DaLatColor,DaLatList);
            case 32:
                return new PropertySquare(squareNames [index],"Property Square",DaNangPrice,DaNangColor,DaNangList);
            case 34:
                return new PropertySquare(squareNames [index],"Property Square",HuePrice,HueColor,HueList);
            case 37:
                return new PropertySquare(squareNames [index],"Property Square",HaNoiPrice,HaNoiColor,HaNoiList);
            case 39:
                return new PropertySquare(squareNames [index],"Property Square",SaiGonPrice,SaiGonColor,SaiGonList);
            case 10:
                return new JailSquare(squareNames [index],"Jail");
            case 20:
                return new Festival(squareNames [index],"Festival");
            case 30:
                return new BusCell(squareNames [index],"Bus Station");
            default:
                return null;
        }
    }
}
