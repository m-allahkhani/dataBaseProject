package src;

public class jewellery extends Product {
    String country;
    int making_Charge;
    public jewellery(String type_name,String country,float discount, int price, float weight, int pID) {
        super(pID,price,type_name,discount,weight);
        this.country = country;
    }

    public jewellery(int discount, int price, float weight, int pID, String country, int making_Charge) {
        super(discount, price, weight, pID);
        this.country = country;
        this.making_Charge = making_Charge;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



}
