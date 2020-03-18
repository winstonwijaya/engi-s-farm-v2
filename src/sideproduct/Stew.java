/*! File: Stew.java */
package engisjava.src.sideproduct;
import engisjava.src.sideproduct.SideProduct;

public class Stew extends SideProduct {
	//! ctor
	public Stew() {
		super("Stew", 20);
	}
	public static void main(String[] args){
		Stew s = new Stew();
		System.out.println(s.getQuantity());
		System.out.println(s.getPrice());
		System.out.println(s.getSideProductType());
		s.addQuantity();
		System.out.println(s.getQuantity());
	}
}

