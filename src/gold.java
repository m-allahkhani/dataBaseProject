

public class gold extends Product {
    int purity;
    String country;
    public gold(int discount, int price, float weight, int pID, int purity) {
        super(discount, price, weight, pID);
        this.purity = purity;
    }
    public gold(String type_name,String country,float discount, int price, float weight, int pID) {
        super(pID,price,type_name,discount,weight);
        this.country = country;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPurity() {
        return purity;
    }
    public void setPurity(int purity) {
        this.purity = purity;
    }
}