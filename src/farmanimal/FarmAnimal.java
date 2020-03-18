/*! File: FarmAnimal.java */
package engisjava.src.farmanimal;
import java.util.Random;
import engisjava.src.renderable.cell.Cell;

public abstract class FarmAnimal extends Cell{
    protected int hungerStage;
    protected String animalType;
    protected int posX;
    protected int posY;
    protected boolean product;

    //! ctor
    public FarmAnimal(int x, int y, String type){
        hungerStage = 0;
        animalType = type;
        posX = x;
        posY = y;
        product = false;
    }

    //! Getter
    public int getHungerStage() {
        return hungerStage;
    }
    public String getAnimalType() {
        return animalType;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public boolean getProduct(){
        return product;
    }

    //! Setter
    public void setHungerStage(int n){
        hungerStage = n;
    }
    public void setAnimalType(String s){
        animalType = s;
    }
    public void setPosX(int x){
        posX = x;
    }
    public void setPosY(int y){
        posY = y;
    }
    public void setProduct(boolean x){
        product = x;
    }

    //! Validation
    public boolean isHungry() {
        return hungerStage>5;
    }

    //! method

    //! Increasing hungerStage
    public void gettingHungry(){
        hungerStage++;
    }

    //! Eat
    public abstract void eat();

    public abstract void kill();

    //! printing animal sound
    public abstract void makeSound();

    //! move on land
    public void move() {
        Random rand = new Random();
        boolean valid = false;
        int newX,newY;
        int y = getPosY();
        int x = getPosX();

        while(!valid){
            int n = rand.nextInt(4) + 1; //randomizing number from 1 to 4

            if(n == 1){                             //! ke atas
                newY = y+1;
                if(newY>=0 && newY<11 ){
                   setPosY(newY);
                   valid = true;
                }
            } else if(n == 2){                      //! ke kanan
                newX = x+1;
                if(newX>=0 && newX<11){
                    setPosX(newX);
                    valid = true;
                }
            } else if(n == 3){                      //! ke bawah
                newY = y-1;
                if(newY>=0 && newY<11){
                   setPosY(newY);
                   valid = true;
                }
            } else{                                 //! ke kiri
                newX = x-1;
                if(newX>=0 && newX<11){
                    setPosX(newX);
                    valid = true;
                }
            }
        }
        gettingHungry(); // everytime the animals move, hunger stage increase
    }


}