package engisjava.src.renderable.cell.land;
import engisjava.src.renderable.cell.Cell;

public class Land extends Cell{
    private String landType;

    public Land(int _x, int _y){
        super(_x, _y, true);
        this.setRumput(false);
        setCellType("Land");
    }

    // Getter
    public String getLandType(){
        return landType;
    }
    // Setter

    public void setLandType(String _landType){
        landType = _landType;
    }

    // Rendering
    @Override
    public char render(){
        return '-';
    }
}