/*! File: Goat.java */

package engisjava.src.farmanimal;
import engisjava.src.farmanimal.MeatProducingFarmAnimal;
import engisjava.src.renderable.Renderable;
import engisjava.src.farmanimal.FarmAnimal;

public class Goat extends FarmAnimal implements MeatProducingFarmAnimal,Renderable{

    public Goat(int x, int y){
        super(x,y,"goat");
    }

    //! method
    public void eat(){
        setHungerStage(0);
        setProduct(false);
        //remove grass in land
    }

    public void makeSound(){
        System.out.println("Mbeee mbeee!!");
    }

    public void kill(){
        //remove Goat from animal list
        System.out.println("Your Goat is dead.");
    }

    public char render(){
        if(isHungry()){
            return 'g';
        } else {
            return 'G';
        }
    }

}