/*! File: Chicken.java */
package engisjava.src.farmanimal;
import engisjava.src.farmanimal.EggProducingFarmAnimal;
import engisjava.src.renderable.Renderable;
import engisjava.src.farmanimal.FarmAnimal;

public class Chicken extends FarmAnimal implements EggProducingFarmAnimal,Renderable{

    public Chicken(int x, int y){
        super(x,y,"chicken");
    }

    //! method
    public void eat(){
        setHungerStage(0);
        setProduct(true);
        //remove grass in land
    }

    public void makeSound(){
        System.out.println("Petok petok!!");
    }

    public void interact(){
        //after player check the surroundings
        setProduct(false);
        //adding egg to inventory
    }

    public char render(){
        if(isHungry()){
            return 'a';
        } else {
            return 'A';
        }
    }

    public boolean isEggProductAvail(){
        return product;
    }
}