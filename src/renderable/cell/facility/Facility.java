/*! File: Facility.java */

package engisjava.src.renderable.cell.facility;
import engisjava.src.renderable.cell.Cell;

public class Facility extends Cell {
	private String facilityType;
	
	//! ctor
	public Facility(int _x, int _y) {
		super(_x, _y, true);
		setCellType("Facility");
	}

	//! Setter
	public void setFacilityType(String f) {
		facilityType = f;
	}

	//! Getter
	public String getFacilityType() {
		return facilityType;
	}
	
	//! Rendering
	@Override
    public char render(){
		return '-';
    }
}

