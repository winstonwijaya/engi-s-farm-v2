/*! File: Cow.java */

package engisjava.src.farmanimal;
import engisjava.src.farmanimal.MilkProducingFarmAnimal;
import engisjava.src.farmanimal.MeatProducingFarmAnimal;
import engisjava.src.renderable.Renderable;
import engisjava.src.farmanimal.FarmAnimal;

public class Cow extends FarmAnimal implements MilkProducingFarmAnimal,MeatProducingFarmAnimal,Renderable{

    public Cow(int x, int y){
        super(x,y,"cow");
    }

    //! method
    public void eat(){
        setHungerStage(0);
        setProduct(true);
        //remove grass in land
    }

    public void makeSound(){
        System.out.println("Moo moo!!");
    }

    public void interact(){
        //after player check the surroundings
        setProduct(false);
        //adding milk to inventory
    }

    public void kill(){
        //remove cow from animal list
        System.out.println("Your Cow is dead.");
    }

    public char render(){
        if(isHungry()){
            return 'c';
        } else {
            return 'C';
        }
    }

    public boolean isMilkProductAvail(){
        return product;
    }
}