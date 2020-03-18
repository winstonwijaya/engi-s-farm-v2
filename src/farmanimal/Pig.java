/*! File: Pig.java */

package engisjava.src.farmanimal;
import engisjava.src.farmanimal.MeatProducingFarmAnimal;
import engisjava.src.renderable.Renderable;
import engisjava.src.farmanimal.FarmAnimal;

public class Pig extends FarmAnimal implements MeatProducingFarmAnimal,Renderable{

    public Pig(int x, int y){
        super(x,y,"pig");
    }

    //! method
    public void eat(){
        setHungerStage(0);
        setProduct(true);
        //remove grass in land
    }

    public void makeSound(){
        System.out.println("Ngoik ngoik!!");
    }

    public void kill(){
        //remove Pig from animal list
        System.out.println("Your Pig is dead.");
    }

    public char render(){
        if(isHungry()){
            return 'p';
        } else {
            return 'P';
        }
    }

}