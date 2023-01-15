package test;/*

 */


import java.io.Serializable;
/*

 */

import java.util.ArrayList;
import java.util.Date;

public class Customer implements Serializable {
    String cID,passWord;
    String name,phoneN,email;
    //Account[]  myAccounts = new Account[10];
    //Account AccountNom;
    test.Factor[]factors;
    ArrayList<test.Intrest_li>interest_lists;
    ArrayList<test.Suggest_li>suggest_lists;
    test.MAddress adress;
    ArrayList<test.Suggest> suggests;

    Customer(String ID, String pass,
             String Name, String phone, String Email,
             String city, String street, String province){
        name = Name;
        cID= ID;
        passWord = pass;
        phoneN = phone;
        email = Email;
        adress=new test.MAddress(city,street,province);

    }
    Customer(String ID){//baray zamani ke mikhaim dade be jadvale rabete ezafe konim
        cID= ID;
    }
    public void setcID(String cID) {
        this.cID = cID;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneN(String phoneN) {
        this.phoneN = phoneN;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public void setAccountNom(Account accountNom) {
//        AccountNom = accountNom;
//    }

    public void setFactors(test.Factor[] factors) {
        this.factors = factors;
    }

    public void AddInterest_lists(test.Intrest_li intrestLi) {

        this.interest_lists.add(intrestLi);
    }

    public void AddSuggest_lists(test.Suggest_li sgLi) {

        this.suggest_lists.add(sgLi);
    }


    public void setAdress(test.MAddress adress) {
        this.adress = adress;
    }

    public void setSuggests(test.Suggest sugg) {
        suggests.add(sugg);
    }

    public String getcID() {
        return cID;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getName() {
        return name;
    }

    public String getPhoneN() {
        return phoneN;
    }

    public String getEmail() {
        return email;
    }

    // public Account getAccountNom() {
//        return AccountNom;
//    }

    public test.Factor[] getFactors() {
        return factors;
    }

    public ArrayList<test.Intrest_li> getInterest_lists() {
        return interest_lists;
    }

    public ArrayList<test.Suggest_li> getSuggest_lists() {
        return suggest_lists;
    }

    public test.MAddress getAdress() {
        return adress;
    }

    public ArrayList<test.Suggest> getSuggests() {
        return suggests;
    }




}
////////////////////////////////////////////////////////


enum type_of_shopping{};
class Factor {
    test.type_of_shopping fType ;
    int Fid;
    ArrayList<test.Product> pruducts;

    public Factor(int fid, test.Product pruduct, test.type_of_shopping t) {
        Fid = fid;
        this.pruducts.add(pruduct) ;
        fType=t;
    }

    public Factor(int fid) {
        Fid = fid;
    }
}


class MAddress{
    String city;
    String street;
    String province;

    public MAddress(String city, String street, String province) {
        this.city = city;
        this.street = street;
        this.province = province;
    }
}
class Suggest{

}
class Intrest_li{
    String condition;
    Date update_date;

    public Intrest_li(String condition, Date update_date) {
        this.condition = condition;
        this.update_date = update_date;
    }

}

class Suggest_li{
    String condition;
    Date update_date;

    public Suggest_li(String condition, Date update_date) {
        this.condition = condition;
        this.update_date = update_date;
    }
}





