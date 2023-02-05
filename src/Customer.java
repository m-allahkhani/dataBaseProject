


import java.io.Serializable;
/*

 */

import java.util.ArrayList;

public class Customer implements Serializable {
    String cID,passWord;
    String name,phoneN,email;
    //Account[]  myAccounts = new Account[10];
    //Account AccountNom;
    Factor[]factors;
    ArrayList<Intrest_li>interest_lists;
    ArrayList<Suggest_li>suggest_lists;
    MAddress adress;
    ArrayList<Suggest> suggests;

    Customer(String ID, String pass,
             String Name, String phone, String Email,
             String city, String street, String province){
        name = Name;
        cID= ID;
        passWord = pass;
        phoneN = phone;
        email = Email;
        adress=new MAddress(city,street,province);

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

    public void setFactors(Factor[] factors) {
        this.factors = factors;
    }

    public void AddInterest_lists(Intrest_li intrestLi) {

        this.interest_lists.add(intrestLi);
    }

    public void AddSuggest_lists(Suggest_li sgLi) {

        this.suggest_lists.add(sgLi);
    }


    public void setAdress(MAddress adress) {
        this.adress = adress;
    }

    public void setSuggests(Suggest sugg) {
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

    public Factor[] getFactors() {
        return factors;
    }

    public ArrayList<Intrest_li> getInterest_lists() {
        return interest_lists;
    }

    public ArrayList<Suggest_li> getSuggest_lists() {
        return suggest_lists;
    }

    public MAddress getAdress() {
        return adress;
    }

    public ArrayList<Suggest> getSuggests() {
        return suggests;
    }




}
////////////////////////////////////////////////////////


;





