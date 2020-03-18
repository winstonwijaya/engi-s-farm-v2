package engisjava.src.renderable.cell.land;
import engisjava.src.renderable.cell.land.Land;

public class Coop extends Land{
    public Coop(int _x, int _y){
        super(_x,_y);
        setLandType("Coop");
    }

    // Rendering
    @Override
    public char render(){
        if (getLandType() == "Coop"){
            if(getRumput()){
                return '*';
            }
            else{
                return 'o';
            }
        }
        else{
            return '-';
        }
    }
}

