package engisjava;

public class Items<E1,E2 extends Number>{
    private E1 name;
    private E2 num;

    public Items(E1 _name, E2 _num){
        name = _name;
        num = _num;
    }

    public E1 getName(){
        return name;
    }

    public E2 getNum(){
        return num;
    }
}