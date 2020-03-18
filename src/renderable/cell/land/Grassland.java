package engisjava.src.renderable.cell.land;
import engisjava.src.renderable.cell.land.Land;

public class Grassland extends Land{
    public Grassland(int _x, int _y){
        super(_x,_y);
        setLandType("Grassland");
    }

    // Rendering
    @Override
    public char render(){
        if (getLandType() == "Grassland"){
            if(getRumput()){
                return '#';
            }
            else{
                return '-';
            }
        }
        else{
            return '-';
        }
    }

}

