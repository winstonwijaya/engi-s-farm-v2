//! Player Class
package engisjava;
import java.util.*;

public class Player<E1,E2 extends Number>{ //implements Renderable{
    //! Atribute of Player 
    private int money;
    private int water;
    private int nbItem;
    private int x;
    private int y;
    private int into;
    private ArrayList<Items<E1,E2>> inventory;
    private int neff;

    private static int DEF_WATER = 30;

    public Player(int _x, int _y){
        money = 0;
        water = 0;
        nbItem = 0;
        x = _x;
        y = _y;
        into = 0;
        neff = 0;
        inventory = new ArrayList<Items<E1,E2>>(); 
    }

    public void setX(int _x){
        x = _x;
    }

    public void setY(int _y){
        y = _y;
    }

    public void setNbInv(int minNb){
            nbItem -= minNb;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getMoney(){
        return money;
    }

    public int getWater(){
        return water;
    }

    public int getInto(){
        return into;
    }

    public int getNbItem(){
        return nbItem;
    }

    public boolean isMixtureAvailabel(String m1, String m2){
        Iterator<Items<E1,E2>> itr =  inventory.iterator();
        boolean found1 = false, found2 = false;

        while(itr.hasNext() && !found1){
            Items<E1,E2> it = itr.next();
            if(it.getName() == m1){
                found1 = true;
            }
        }

        Iterator<Items<E1,E2>> itr2 = inventory.iterator();
        while(itr2.hasNext() && !found2){
            Items<E1,E2> it2 = itr2.next();
            if(it2.getName() == m2){
                found2 = true;
            }
        }

        return found1 && found2;
    }

    public void addWater(){
        water = DEF_WATER;
    }

    public void subWater(){
        water--;
    }

    public void addMoney(int addedMoney){
        money += addedMoney;
    }

    public void addItem(E1 _name, E2 _num){
        nbItem += (int)_num;
        boolean stop = false;
        int loc = 0;
        Iterator<Items<E1,E2>> itr = inventory.iterator();

        while(!stop && itr.hasNext()){
            Items<E1,E2> it = itr.next();
            if(it.getName()==_name){
                stop = true;
            }
            else{
                loc++;
            }
        }
        if(stop){                                   // found the item
            Items<E1,E2> temp = inventory.get(loc);
            temp = new Items<E1,E2>(temp.getName(), (E2) new Integer((int)temp.getNum() + (int)_num));
            inventory.set(loc,temp);
        }
        else{
            Items<E1,E2> temp = new Items<E1,E2>(_name,_num);
            System.out.println(temp.getName());
            inventory.add(neff,temp);
            // print();
            neff++;
        }
    }

    public void subItem(E1 item){
        nbItem--;
        boolean stop = false;
        Iterator<Items<E1,E2>> itr = inventory.iterator();
        while(!stop && itr.hasNext()){
            Items<E1,E2> it = itr.next();
            if(it.getName()==item){
                if((int)it.getNum()>1){
                    int loc = inventory.indexOf(it);
                    inventory.set(loc,new Items<E1,E2>(it.getName(),(E2) new Integer((int)it.getNum()-1)));
                }
                else{
                    Items<E1,E2> temp = inventory.remove(inventory.indexOf(it));
                    neff--;
                }
                stop = true;
            }
        }

    }

    public boolean isInventoryEmpty(){
        return inventory.isEmpty();
    }

    public void sellItem(){
        int addedMoney = 0;
        neff = 0;
        nbItem = 0;
        Iterator<Items<E1,E2>> itr = inventory.iterator();
        while(itr.hasNext()){
            Items<E1,E2> it = itr.next();
            addedMoney += ((int)it.getNum()*15);
        }
        this.addMoney(addedMoney);
        inventory.clear();
    }

    public boolean isMixtureAvailabel(E1 m){
        boolean found = false;
        Iterator<Items<E1,E2>> itr = inventory.iterator();
        while(!found && itr.hasNext()){
            Items<E1,E2> it = itr.next();
            if(it.getName() == m){
                found = true;
            }
        }
        return found;
    }

    public String combine(E1 m1, E1 m2){
        if ((m1 == "duckEgg" && m2 == "chickenEgg") || (m1 == "chickenEgg" && m2 == "duckEgg"))
            return "Martabak";
        else if ((m1 == "chickenEgg" && m2 == "cowMilk") || (m1 == "cowMilk" && m2 == "chickenEgg"))
            return "Omelette";
        else if ((m1 == "horseMilk" && m2 == "goatMeat") || (m1 == "goatMeat" && m2 == "horseMilk"))
            return "Stew";
        else if ((m1 == "pigMeat" && m2 == "cowMeat") || (m1 == "cowMeat" && m2 == "pigMeat"))
            return "Satay";
        else
            return "Nope";
    }
    
    public boolean isValid(E1 m1, E1 m2){
        if ((m1 == "duckEgg" && m2 == "chickenEgg") || (m1 == "chickenEgg" && m2 == "duckEgg"))
            return true;
        else if ((m1 == "chickenEgg" && m2 == "cowMilk") || (m1 == "cowMilk" && m2 == "chickenEgg"))
            return true;
        else if ((m1 == "horseMilk" && m2 == "goatMeat") || (m1 == "goatMeat" && m2 == "horseMilk"))
            return true;
        else if ((m1 == "pigMeat" && m2 == "cowMeat") || (m1 == "cowMeat" && m2 == "pigMeat"))
            return true;
        else
            return false;
    }
    
    public void mix(E1 m1, E1 m2){
		try {
			if (!isValid(m1, m2))
				throw new Exception("Mixture invalid");
			else {
				if (isMixtureAvailabel(m1) && isMixtureAvailabel(m2)) {
					String Combination = combine(m1,m2);
					if(Combination != "Nope") {
						addItem((E1)Combination,(E2) new Integer(1));
						subItem(m1);
						subItem(m2);
					}
				else {
					System.out.println("Combination not found");
				}
			}
			}
		}
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public int numItemType(){
        Iterator<Items<E1,E2>> itr = inventory.iterator();
        int nb = 0;
        while(itr.hasNext()){
            Items<E1,E2> it = itr.next();
            nb = nb + 1;
        }
        return nb;
    }

    public E1 getItemAt(int n){
        Iterator<Items<E1,E2>> itr = inventory.iterator();
        int i = 0;
        Items<E1,E2> it = itr.next();
        while(i < n && itr.hasNext()){
           it = itr.next();
           i++;
        }
        return (it.getName());
    }

    public E2 getNumberAtItem(int n){
        Iterator<Items<E1,E2>> itr = inventory.iterator();
        int i = 0;
        Items<E1,E2> it = itr.next();
        while(i < n && itr.hasNext()){
           it = itr.next();
           i++;
        }
        return (it.getNum());
    }

    public void print(){
        System.out.println("Money: " + money);
        System.out.println("Water: " + water);
        System.out.println("Total item in inventory: " + nbItem);
        System.out.println("Current player location: " + x + " " + y);
        System.out.println("Currently heading to: " + into);
        System.out.println("Item(s) in inventory: ");
        if(inventory.isEmpty()){
            System.out.println("Inventory is empty");
        }
        else{
            Iterator<Items<E1,E2>> itr = inventory.iterator();
            while(itr.hasNext()){
                Items<E1,E2> it = itr.next();
                for(int i = 0 ; i < (int)it.getNum() ; i++ ){
                    System.out.println(it.getName());
                }
            }            
        }
    }

    public char render(){
        return 'J';
    }

    // public static void main(String[] args){
    //     Player<String,Integer> p = new Player<String,Integer>(5,5);
    //     p.addItem("Satay",5);
    //     p.addItem("Stew",2);
    //     p.print();
    //     p.subItem("Stew");
    //     p.print();
    //     p.sellItem();
    //     p.print();
    //     p.addItem("duckEgg",1);
    //     p.addItem("chickenEgg",2);
    //     p.addItem("cowMilk",1);
    //     p.addItem("horseMilk",1);
    //     p.addItem("goatMeat",1);
    //     p.addItem("cowMeat",1);
    //     p.addItem("pigMeat",1);
    //     p.print();
    //     p.mix("duckEgg","chickenEgg");
    //     p.mix("chickenEgg","cowMilk");
    //     p.mix("horseMilk","goatMeat");
    //     p.mix("pigMeat","cowMeat");
    //     p.mix("duckEgg","cowMeat");
    //     p.print();
    //     p.sellItem();
    //     if(p.isInventoryEmpty()){
    //         System.out.println("Bag is empty");
    //     }
    // }
}
