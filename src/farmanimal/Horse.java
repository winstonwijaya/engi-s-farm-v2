/*! File: Horse.java */

package engisjava.src.farmanimal;
import engisjava.src.farmanimal.MilkProducingFarmAnimal;
import engisjava.src.renderable.Renderable;
import engisjava.src.farmanimal.FarmAnimal;

public class Horse extends FarmAnimal implements MilkProducingFarmAnimal,Renderable{

    public Horse(int x, int y){
        super(x,y,"horse");
    }

    //! method
    public void eat(){
        setHungerStage(0);
        setProduct(true);
        //remove grass in land
    }

    public void makeSound(){
        System.out.println("Hiyaaa hiyaaa!!");
    }

    public void interact(){
        //after player check the surroundings
        setProduct(false);
        //adding milk to inventory
    }

    public char render(){
        if(isHungry()){
            return 'h';
        } else {
            return 'H';
        }
    }

    public boolean isMilkProductAvail(){
        return product;
    }
}