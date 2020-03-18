// import java.util.*;
package engisjava.src.renderable.cell;
import engisjava.src.renderable.Renderable;

public class Cell implements Renderable{
    private int x;
    private int y;
    private boolean occupied;
    private boolean rumput;
    private String cellType;

    public Cell(){
        x = 0;
        y = 0;
        occupied = false;
    }

    public Cell(int _x, int _y, boolean _occupied){
        x = _x;
        y = _y;
        occupied = _occupied;
        rumput = false;
    }

    // Getter

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getCellType(){
        return cellType;
    }

    public boolean getOccupied(){
        return occupied;
    }

    public boolean getRumput(){
        return rumput;
    }

    // Setter

    public void setX(int _x){
        this.x = _x;
    }

    public void setY(int _y){
        this.y = _y;
    }
    public void setOccupied(){
        this.occupied = true;
    }

    public void setCellType(String type){
        this.cellType = type;
    }

    public void setRumput(boolean x){
        this.rumput = x;
    }

    public boolean isValid(){
        if (getCellType() == "Facility") {
            return false;
        }
        else{
            return true;
        }
    }

    //! Rendering
    public char render(){
        return '-';
    }
}