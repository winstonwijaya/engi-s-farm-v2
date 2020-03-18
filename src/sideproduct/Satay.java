/*! File: Satay.java */
package engisjava.src.sideproduct;
import engisjava.src.sideproduct.SideProduct;

public class Satay extends SideProduct {
	//! ctor
	public Satay() {
		super("Satay", 20);
	}
	public static void main(String[] args){
		Satay s = new Satay();
		System.out.println(s.getQuantity());
		System.out.println(s.getPrice());
		System.out.println(s.getSideProductType());
		s.addQuantity();
		System.out.println(s.getQuantity());
	}
}

