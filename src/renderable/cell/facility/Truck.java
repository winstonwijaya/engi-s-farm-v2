/*! File: Truck.java */

package engisjava.src.renderable.cell.facility;
import engisjava.src.renderable.cell.facility.Facility;

public class Truck extends Facility {
	private int tick;
	
	//! ctor
	public Truck(int _x, int _y, int t) {
		super(_x, _y);
		setFacilityType("Truck");
		tick = t;
	}

	//! Setter
	public void setTick(int t) {
		tick = t;
	}

	//! Getter
	public int getTick() {
		return tick;
	}

	//! Method

	//! Decrease tick
	public void Tick() {
		if (tick > 0)
			tick--;
	}
	
	//! Rendering
	@Override
	public char render() {
		return 'T';
	}
}
