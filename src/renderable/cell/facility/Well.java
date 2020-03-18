/*! File: Well.java */

package engisjava.src.renderable.cell.facility;
import engisjava.src.renderable.cell.facility.Facility;

public class Well extends Facility {
	//! ctor
	public Well(int _x, int _y) {
		super(_x, _y);
		setFacilityType("Well");
	}

	//! Rendering
	@Override
	public char render() {
		return 'W';
	}
}
