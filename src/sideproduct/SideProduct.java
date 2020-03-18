/*! File: SideProduct.java */

package engisjava.src.sideproduct;

public class SideProduct {
	private String sideProductType;
	private int quantity;
	private int price;
	
	//! ctor
	public SideProduct(String s, int p) {
		quantity = 0;
		sideProductType = s;
		price = p;
	}
	
	//! Setter
	public void setSideProductType(String s) {
		sideProductType = s;
	}
	
	public void setPrice(int p) {
		price = p;
	}

	//! Getter
	public String getSideProductType() {
		return sideProductType;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}

	//! Method

	//! Add Quantity of SideProduct
	public void addQuantity() {
		quantity++;
	}
}

