
public class Product{
    float discount;
    int price;
    float weight;
    int idProduct;
    int idOrders;
    String type_name;
    int count;
    String f_date;
    public Product(float discount, int price, float weight, int pID) {
        this.discount = discount;
        this.price = price;
        this.weight = weight;
        this.idProduct = pID;
    }
    public Product(int idProduct,int price,int idOrders, String type_name
            ,int count){
        this.idProduct=idProduct;
        this.idOrders=idOrders;
        this.type_name=type_name;
        this.price=price;
        this.count=count;
    }
    public Product(int idProduct,int price,int idOrders, String type_name
            ,String f_date){
        this.idProduct=idProduct;
        this.idOrders=idOrders;
        this.type_name=type_name;
        this.price=price;
        this.f_date=f_date;
    }
    public Product (String type_name,float discount,int price,float weight){
        this.weight=weight;
        this.type_name=type_name;
        this.discount=discount;
        this.price=price;
    }
    public Product(int idProduct,int price, String type_name,
                   float discount,float weight){
        this.idProduct=idProduct;
        this.type_name=type_name;
        this.price=price;
        this.discount=discount;
        this.weight=weight;
    }
    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public void setF_date(String f_date) {
        this.f_date = f_date;
    }
    public String getF_date() {
        return f_date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setIdOrders(int idOrders) {
        this.idOrders = idOrders;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getType_name() {
        return type_name;
    }

    public int getIdOrders() {
        return idOrders;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    public float getWeight() {
        return weight;
    }
    public float getDiscount() {
        return discount;
    }
}



