package engisjava.src.renderable.cell.land;
import engisjava.src.renderable.cell.land.Land;

public class Barn extends Land{
    public Barn(int _x, int _y){
        super(_x,_y);
        setLandType("Barn");
    }

    // Rendering
    @Override
    public char render(){
        if (getLandType() == "Barn"){
            if(getRumput()){
                return '@';
            }
            else{
                return 'x';
            }
        }
        else{
            return '-';
        }
    }
}

