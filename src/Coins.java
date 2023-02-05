

public class  Coins extends Product {
    int C_year;
    public Coins(float discount, int price, float weight, int pID,int year) {
        super(discount, price, weight, pID);
        this.C_year=year;
    }
    public Coins(String type_name,float discount, int price, float weight,int C_year) {
        super(type_name,discount, price, weight);
        this.C_year=C_year;
    }

    public void setC_year(int c_year) {
        C_year = c_year;
    }

    public int getC_year() {
        return C_year;
    }
}
