import java.util.ArrayList;

public class Factor {
    type_of_shopping fType;
    int Fid;
    ArrayList<Product> pruducts;

    public Factor(int fid, Product pruduct, type_of_shopping t) {
        Fid = fid;
        this.pruducts.add(pruduct);
        fType = t;
    }

    public Factor(int fid) {
        Fid = fid;
    }
}
