/*! File: FarmProduct.java */
package engisjava.src.farmproduct;

public class FarmProduct{
    protected String farmProductType;
    protected int price;

    //!ctor
    public FarmProduct(String type, int p){
        farmProductType = type;
        price = p;
    }

    //! Setter
    public void setFarmProductType(String type){
        farmProductType = type;
    }
    //public void setQuantity(int qt);
    public void setPrice(int pr){
        price = pr;
    }

    //! Getter
    public String getFarmProductType(){
        return farmProductType;
    }
    //public int getQuantitiy();
    public int getPrice(){
        return price;
    }

    //public void addquantity();
    //public void subquantity();
}