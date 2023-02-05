public class Product{
    int discount;
    int price;
    int weight;
    int pID;

    public Product(int discount, int price, int weight, int pID) {
        this.discount = discount;
        this.price = price;
        this.weight = weight;
        this.pID = pID;
    }

}
class  Coins extends test.Product {
    public Coins(int discount, int price, int weight, int pID,int y) {
        super(discount, price, weight, pID);
        year=y;
    }

    int year;

}
class gold extends test.Product {
    public gold(int discount, int price, int weight, int pID, int purity) {
        super(discount, price, weight, pID);
        this.purity = purity;
    }

    int purity;

}
class jewellery extends test.Product {
    public jewellery(int discount, int price, int weight, int pID) {
        super(discount, price, weight, pID);
    }

    public jewellery(int discount, int price, int weight, int pID, String country, int making_Charge) {
        super(discount, price, weight, pID);
        this.country = country;
        this.making_Charge = making_Charge;
    }

    String country;
    int making_Charge;

}
