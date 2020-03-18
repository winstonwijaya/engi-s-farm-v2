/*! File: Martabak.java */
package engisjava.src.sideproduct;
import engisjava.src.sideproduct.SideProduct;

public class Martabak extends SideProduct {
	//! ctor
	public Martabak() {
		super("Martabak", 20);
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

