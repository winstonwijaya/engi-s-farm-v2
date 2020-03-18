/*! File: Omelette.java */
package engisjava.src.sideproduct;
import engisjava.src.sideproduct.SideProduct;

public class Omelette extends SideProduct {
	//! ctor
	public Omelette() {
		super("Omelette", 20);
	}
	public static void main(String[] args){
		Omelette s = new Omelette();
		System.out.println(s.getQuantity());
		System.out.println(s.getPrice());
		System.out.println(s.getSideProductType());
		s.addQuantity();
		System.out.println(s.getQuantity());
	}
}

