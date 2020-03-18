/*! File: Duck.java */

package engisjava.src.farmanimal;
import engisjava.src.farmanimal.EggProducingFarmAnimal;
import engisjava.src.renderable.Renderable;
import engisjava.src.farmanimal.FarmAnimal;

public class Duck extends FarmAnimal implements EggProducingFarmAnimal,Renderable{

    public Duck(int x, int y){
        super(x,y,"duck");
    }

    //! method
    public void eat(){
        setHungerStage(0);
        setProduct(true);
        //remove grass in land
    }

    public void makeSound(){
        System.out.println("Quack quack!!");
    }

    public void interact(){
        //after player check the surroundings
        setProduct(false);
        //adding egg to inventory
    }

    public char render(){
        if(isHungry()){
            return 'd';
        } else {
            return 'D';
        }
    }

    public boolean isEggProductAvail(){
        return product;
    }
}