/*! File: Mixer.java */

package engisjava.src.renderable.cell.facility;
import engisjava.src.renderable.cell.facility.Facility;

public class Mixer extends Facility {
	//! ctor
	public Mixer(int _x, int _y) {
		super(_x, _y);
		setFacilityType("Mixer");
	}

	//! Rendering
	@Override
	public char render() {
		return 'M';
	}
}
