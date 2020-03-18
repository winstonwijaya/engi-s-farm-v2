#include <iostream>
#include <vector>
#include <string>
#include "Renderable/Renderable.hpp"
#include "Renderable/Cell/Cell.hpp"
#include "Renderable/Cell/Land/Land.hpp"
#include "Renderable/Cell/Land/Coop.hpp"
#include "Renderable/Cell/Facility/Facility.hpp"
#include "Renderable/Cell/Facility/Well.hpp"
#include "Renderable/Cell/Facility/Mixer.hpp"
#include "Renderable/Cell/Facility/Truck.hpp"
#include "Renderable/Cell/Land/Barn.hpp"
#include "Renderable/Cell/Land/Grassland.hpp"
#include "Renderable/Cell/FarmAnimal/EggProducingFarmAnimal/Chicken.hpp"
#include "Renderable/Cell/FarmAnimal/MeatProducingFarmAnimal/Goat.hpp"
#include "Renderable/Cell/FarmAnimal/MilkProducingFarmAnimal/Horse.hpp"
#include "Renderable/Cell/FarmAnimal/MeatProducingFarmAnimal/Pig.hpp"
#include "Renderable/Cell/FarmAnimal/MilkProducingFarmAnimal/Cow.hpp"
#include "Renderable/Cell/FarmAnimal/EggProducingFarmAnimal/Duck.hpp"
#include "Renderable/Cell/FarmAnimal/EggProducingFarmAnimal/EggProducingFarmAnimal.hpp"
#include "Renderable/Cell/FarmAnimal/FarmAnimal.hpp"
#include "Renderable/Cell/FarmAnimal/MeatProducingFarmAnimal/MeatProducingFarmAnimal.hpp"
#include "Renderable/Cell/FarmAnimal/MilkProducingFarmAnimal/MilkProducingFarmAnimal.hpp"
#include "SideProduct/Martabak.hpp"
#include "SideProduct/Omelette.hpp"
#include "SideProduct/Satay.hpp"
#include "SideProduct/Stew.hpp"
#include "FarmProduct/FarmProduct.hpp"
#include "FarmProduct/ChickenEgg.hpp"
#include "FarmProduct/CowMeat.hpp"
#include "FarmProduct/CowMilk.hpp"
#include "FarmProduct/DuckEgg.hpp"
#include "FarmProduct/GoatMeat.hpp"
#include "FarmProduct/HorseMilk.hpp"
#include "FarmProduct/PigMeat.hpp"
#include "Player.hpp"

using namespace std;

void showTitle(){
    cout<<"  ______ _   _  _____ _____ _  _____   ______      _____  __  __ "<<endl;
    cout<<" |  ____| | | |/ ____|_   _( )/ ____| |  ____/|   |  __ ||  |/  |"<<endl;
    cout<<" | |__  |  || | |  __  | | |/| (___   | |__ /  |  | |__) | |  | |"<<endl;
    cout<<" |  __| | . ` | | |_ | | |    |___ |  |  __/ /| | |  _  /| ||/| |"<<endl;
    cout<<" | |____| ||  | |__| |_| |_   ____) | | | / ____ || | | || |  | |"<<endl;
    cout<<" |______|_| |_||_____|_____| |_____/  |_|/_/    |_|_|  |_|_|  |_|"<<endl;                                                                                                                         
}

void showGameOver(Player<int> P){
    cout<<"\t\t _____ _____ _____ _____    _____ _____ _____ _____"<<endl; 
    cout<<"\t\t|   __|  _  |     |   __|  |     |  |  |   __| __  |"<<endl;
    cout<<"\t\t|  |  |     | | | |   __|  |  |  |  |  |   __|    -|"<<endl;
    cout<<"\t\t|_____|__|__|_|_|_|_____|  |_____|(___)|_____|__|__|"<<endl;
    cout<<endl;
    cout<<endl;
    cout<<endl;
    cout<<"\t\t\t\tYour score is "<<P.getMoney()<<endl;
    cout<<"\t   Thanks for playing with us, hope you find it enjoyable game!"<<endl;
    cout<<"\t\t\t\tSee you next time!"<<endl;
}

void showHelp(){
    cout<<"Command list:"<<endl;
    cout<<"1. W, S, A, D = Move player(up, down, left, right)"<<endl;
    cout<<"2. T - Talk with animal"<<endl;
    cout<<"3. I - Interact with animal"<<endl;
    cout<<"4. K - Kill an animal"<<endl;
    cout<<"5. F - Fill your watering can at well"<<endl;
    cout<<"6. M - Mix your farm product at mixer to make a side product"<<endl;
    cout<<"7. Z - sell all items in inventory at truck"<<endl;
    cout<<"8. G - grow grass at your current position"<<endl;
    cout<<"9. H - show help menu"<<endl;
}

void showLoc(vector<FarmAnimal*> AL){
    for(int k = 0 ; k < AL.size() ; k++){
        cout<< AL.at(k)->getAnimalType()<< ": " <<AL.at(k)->getX() << " " << AL.at(k)->getY()<<endl;
    }
}

int main(){
    bool play = true;
    //! intialize animal
    vector<FarmAnimal*> AnimalList;
    Player<int> P(5, 5);
    AnimalList.push_back(new Chicken(1,1));
    AnimalList.push_back(new Duck(2,1));
    AnimalList.push_back(new Goat(5,4));
    AnimalList.push_back(new Pig(6,3));
    AnimalList.push_back(new Cow(7,8));
    AnimalList.push_back(new Horse(9,9));

    //! initialize facility
    vector<Facility*> FacilityList;
    FacilityList.push_back(new Well(9,0));
    FacilityList.push_back(new Mixer(9,1));
    FacilityList.push_back(new Truck(9,3,10));

    //! initialize map
    vector<Cell*> mapList;
    mapList.push_back(new Coop(0,0));
    mapList.push_back(new Coop(0,1));
    mapList.push_back(new Coop(0,2));
    mapList.push_back(new Coop(0,3));
    mapList.push_back(new Grassland(0,4));
    mapList.push_back(new Grassland(0,5));
    mapList.push_back(new Grassland(0,6));
    mapList.push_back(new Grassland(0,7));
    mapList.push_back(new Grassland(0,8));
    mapList.push_back(new Grassland(0,9));
    mapList.push_back(new Grassland(0,10));

    mapList.push_back(new Coop(1, 0));
    mapList.push_back(new Coop(1, 1));
    mapList.push_back(new Coop(1, 2));
    mapList.push_back(new Coop(1, 3));
    mapList.push_back(new Grassland(1,4));
    mapList.push_back(new Grassland(1,5));
    mapList.push_back(new Grassland(1,6));
    mapList.push_back(new Grassland(1,7));
    mapList.push_back(new Grassland(1,8));
    mapList.push_back(new Grassland(1,9));
    mapList.push_back(new Grassland(1,10));

    mapList.push_back(new Coop(2, 0));
    mapList.push_back(new Coop(2, 1));
    mapList.push_back(new Coop(2, 2));
    mapList.push_back(new Coop(2, 3));
    mapList.push_back(new Grassland(2,4));
    mapList.push_back(new Grassland(2,5));
    mapList.push_back(new Grassland(2,6));
    mapList.push_back(new Grassland(2,7));
    mapList.push_back(new Grassland(2,8));
    mapList.push_back(new Grassland(2,9));
    mapList.push_back(new Grassland(2,10));

    mapList.push_back(new Barn(3, 0));
    mapList.push_back(new Barn(3, 1));
    mapList.push_back(new Barn(3, 2));
    mapList.push_back(new Barn(3, 3));
    mapList.push_back(new Grassland(3,4));
    mapList.push_back(new Grassland(3,5));
    mapList.push_back(new Grassland(3,6));
    mapList.push_back(new Grassland(3,7));
    mapList.push_back(new Grassland(3,8));
    mapList.push_back(new Grassland(3,9));
    mapList.push_back(new Grassland(3,10));

    mapList.push_back(new Barn(4, 0));
    mapList.push_back(new Barn(4, 1));
    mapList.push_back(new Barn(4, 2));
    mapList.push_back(new Barn(4, 3));
    mapList.push_back(new Grassland(4,4));
    mapList.push_back(new Grassland(4,5));
    mapList.push_back(new Grassland(4,6));
    mapList.push_back(new Grassland(4,7));
    mapList.push_back(new Grassland(4,8));
    mapList.push_back(new Grassland(4,9));
    mapList.push_back(new Grassland(4,10));

    mapList.push_back(new Barn(5, 0));
    mapList.push_back(new Barn(5, 1));
    mapList.push_back(new Barn(5, 2));
    mapList.push_back(new Barn(5, 3));
    mapList.push_back(new Grassland(5,4));
    mapList.push_back(new Grassland(5,5));
    mapList.push_back(new Grassland(5,6));
    mapList.push_back(new Grassland(5,7));
    mapList.push_back(new Grassland(5,8));
    mapList.push_back(new Grassland(5,9));
    mapList.push_back(new Grassland(5,10));

    mapList.push_back(new Grassland(6, 0));
    mapList.push_back(new Grassland(6, 1));
    mapList.push_back(new Grassland(6, 2));
    mapList.push_back(new Grassland(6, 3));
    mapList.push_back(new Grassland(6,4));
    mapList.push_back(new Grassland(6,5));
    mapList.push_back(new Grassland(6,6));
    mapList.push_back(new Grassland(6,7));
    mapList.push_back(new Grassland(6,8));
    mapList.push_back(new Grassland(6,9));
    mapList.push_back(new Grassland(6,10));


    mapList.push_back(new Grassland(7, 0));
    mapList.push_back(new Grassland(7, 1));
    mapList.push_back(new Grassland(7, 2));
    mapList.push_back(new Grassland(7, 3));
    mapList.push_back(new Grassland(7,4));
    mapList.push_back(new Grassland(7,5));
    mapList.push_back(new Grassland(7,6));
    mapList.push_back(new Grassland(7,7));
    mapList.push_back(new Grassland(7,8));
    mapList.push_back(new Grassland(7,9));
    mapList.push_back(new Grassland(7,10));

    mapList.push_back(new Grassland(8, 0));
    mapList.push_back(new Grassland(8, 1));
    mapList.push_back(new Grassland(8, 2));
    mapList.push_back(new Grassland(8, 3));
    mapList.push_back(new Grassland(8,4));
    mapList.push_back(new Grassland(8,5));
    mapList.push_back(new Grassland(8,6));
    mapList.push_back(new Grassland(8,7));
    mapList.push_back(new Grassland(8,8));
    mapList.push_back(new Grassland(8,9));
    mapList.push_back(new Grassland(8,10));

    mapList.push_back(new Well(9, 0));
    mapList.push_back(new Mixer(9, 1));
    mapList.push_back(new Grassland(9, 2));
    mapList.push_back(new Truck(9, 3, 10));
    mapList.push_back(new Grassland(9,4));
    mapList.push_back(new Grassland(9,5));
    mapList.push_back(new Grassland(9,6));
    mapList.push_back(new Grassland(9,7));
    mapList.push_back(new Grassland(9,8));
    mapList.push_back(new Grassland(9,9));
    mapList.push_back(new Grassland(9,10));

    mapList.push_back(new Grassland(10, 0));
    mapList.push_back(new Grassland(10, 1));
    mapList.push_back(new Grassland(10, 2));
    mapList.push_back(new Grassland(10, 3));
    mapList.push_back(new Grassland(10,4));
    mapList.push_back(new Grassland(10,5));
    mapList.push_back(new Grassland(10,6));
    mapList.push_back(new Grassland(10,7));
    mapList.push_back(new Grassland(10,8));
    mapList.push_back(new Grassland(10,9));
    mapList.push_back(new Grassland(10,10));

    while (AnimalList.size() > 0) {
        int n =0;
        int m = 0;
        showTitle();
        // T.tick();
        for (int k = 0; k<AnimalList.size(); k++){
            AnimalList.at(k)->move();
        }
        cout<<"-----------------------MAP-----------------------"<<endl;
        cout<<"-------------------------------------------------"<<endl;
        for (int i = 0; i <11;i++)
        {
            cout<<"| ";
            for (int j = 0;j<11;j++)
            {
                // cout << "-";
                if(m<mapList.size()){
                    if(i == P.getposX() && j     == P.getposY()){
                        cout << P.render() << " | ";
                    }
                    else if(n<AnimalList.size()){
                        if (AnimalList.at(n)->getX() == i && AnimalList.at(n)->getY() == j){
                        cout<< AnimalList.at(n)->render() << " | ";
                            n++;
                        }
                        else{
                            cout<< mapList.at(m)->render() << " | ";
                            m++;
                        }
                    }
                    else{
                        cout<<mapList.at(m)->render()<< " | ";
                        m++;
                    }
                }
            }
            cout<< endl;
        }
        cout << "-------------------------------------------------"<<endl;
        P.print();
        showLoc(AnimalList);        
        char coba;
        cin>> coba;
        if (coba == 'A') {
            if(P.getposY()-1 < 0){
                cout << "Invalid Movement" << endl;
            }
            else{
                P.setposY(P.getposY() - 1);
            }
        }
        else if (coba == 'W') {
            if(P.getposX() - 1  < 0){
                cout << "Invalid movement"<<endl;
            }
            else{
                P.setposX(P.getposX() - 1);
            }
        }
        else if (coba == 'S') {
            if(P.getposX() - 1  > 10){
                cout << "Invalid Movement" << endl;
            }
            else{
                P.setposX(P.getposX() + 1);
            }
        }
        else if (coba == 'D') {
            if(P.getposY()+1 > 10){
                cout << "Invalid Movement" << endl;
            }
            else{
                P.setposY(P.getposY() + 1);
            }
        }
        else if (coba == 'T') {
            for(int k = 0 ; k < AnimalList.size(); k++){
                if(AnimalList.at(k)->getX() == P.getposX()-1 && AnimalList.at(k)->getY() == P.getposY()){
                    AnimalList.at(k)->makeSound();
                    cout << endl;
                    break;
                }
                else if(AnimalList.at(k)->getX() == P.getposX()+1 && AnimalList.at(k)->getY() == P.getposY()){
                    AnimalList.at(k)->makeSound();
                    cout << endl;
                    break;

                }
                else if(AnimalList.at(k)->getX() == P.getposX() && AnimalList.at(k)->getY() == P.getposY()-1){
                    AnimalList.at(k)->makeSound();
                    cout << endl;
                    break;
                }
                else if(AnimalList.at(k)->getX() == P.getposX() && AnimalList.at(k)->getY() == P.getposY()+1){
                    AnimalList.at(k)->makeSound();
                    cout << endl;
                    break;
                }
            }
        }
        else if (coba == 'I') {
            bool match = false;
            for(int k = 0; k < AnimalList.size() ; k++){
                if(AnimalList.at(k)->getX() == P.getposX()){                                                                   
                    if ( (AnimalList.at(k)->getY() == P.getposY()-1) || (AnimalList.at(k)->getY() == P.getposY()+1) ){         // x j x 
                        if(AnimalList.at(k)->getProductAvail()){                                                          
                            if(AnimalList.at(k)->getAnimalType() == "cow"){
                                    P.addItem("cowMilk",1);
                                    match = true;
                                } else if(AnimalList.at(k)->getAnimalType() == "horse"){
                                    P.addItem("horseMilk",1);
                                    match = true;
                                }
                                else if(AnimalList.at(k)->getAnimalType() == "chicken"){
                                    P.addItem("chickenEgg",1);
                                    match = true;
                                } else {
                                    P.addItem("duckEgg",1);
                                    match = true;
                                }
                            break;
                        }    
                    }
                }
                else if(AnimalList.at(k)->getY() == P.getposY()){                                                                   
                    if ( (AnimalList.at(k)->getX() == P.getposX()-1) || (AnimalList.at(k)->getX() == P.getposX()+1) ){         // x j x 
                        if(AnimalList.at(k)->getProductAvail() == true){                                                          
                            if(AnimalList.at(k)->getAnimalType() == "cow"){
                                    P.addItem("cowMilk",1);
                                    match = true;
                                } else if(AnimalList.at(k)->getAnimalType() == "horse"){
                                    P.addItem("horseMilk",1);
                                    match = true;
                                }
                                else if(AnimalList.at(k)->getAnimalType() == "chicken"){
                                    P.addItem("chickenEgg",1);
                                    match = true;
                                } else {
                                    P.addItem("duckEgg",1);
                                    match = true;
                                }
                            break;
                        }    
                    }
                }

                // if(AnimalList.at(k)->getAnimalType() == "cow" || AnimalList.at(k)->getAnimalType() == "horse"){ //MILK PRODUCING
                //     if(AnimalList.at(k)->getProductAvail() == true){
                //         if(AnimalList.at(k)->getX() == P.getposX()){
                //             if ( (AnimalList.at(k)->getY() == P.getposY()-1) || (AnimalList.at(k)->getY() == P.getposY()+1) ){
                //                 if(AnimalList.at(k)->getAnimalType() == "cow"){
                //                     P.addItem("cowMilk",1);
                //                     match = true;
                //                 } else {
                //                     P.addItem("horseMilk",1);
                //                     match = true;
                //                 }
                //             }
                //             break;
                //         }
                //         else if( (AnimalList.at(k)->getX() == P.getposX()+1) || (AnimalList.at(k)->getX() == P.getposX()-1) ){
                //             if(FacilityList.at(k)->getY() == P.getposY()){
                //                 if(AnimalList.at(k)->getAnimalType() == "cow"){
                //                     P.addItem("cowMilk",1);
                //                     match = true;
                //                 } else {
                //                     P.addItem("horseMilk",1);
                //                     match = true;
                //                 }
                //             }
                //             break;
                //         }
                //     }
                // }

                // if(AnimalList.at(k)->getAnimalType() == "chicken" || AnimalList.at(k)->getAnimalType() == "duck"){ //EGG PRODUCING
                //     if(AnimalList.at(k)->getProductAvail() == true){
                //         if(AnimalList.at(k)->getX() == P.getposX()){
                //             if ( (AnimalList.at(k)->getY() == P.getposY()-1) || (AnimalList.at(k)->getY() == P.getposY()+1) ){
                //                 if(AnimalList.at(k)->getAnimalType() == "chicken"){
                //                     P.addItem("chickenEgg",1);
                //                     match = true;
                //                 } else {
                //                     P.addItem("duckEgg",1);
                //                     match = true;
                //                 }
                //             }
                //             break;
                //         }
                //         else if( (FacilityList.at(k)->getX() == P.getposX()+1) || (FacilityList.at(k)->getX() == P.getposX()-1) ){
                //             if(FacilityList.at(k)->getY() == P.getposY()){
                //                 if(AnimalList.at(k)->getAnimalType() == "chicken"){
                //                     P.addItem("chickenEgg",1);
                //                     match = true;
                //                 } else {
                //                     P.addItem("duckEgg",1);
                //                     match = true;
                //                 }
                //             }
                //             break;
                //         }
                //     }
                // }
            }
            if(!match){
                cout << "There is no animal near you or no product available" << endl;
            }
        }
        else if (coba == 'K') {
            for(int k = 0 ; k < AnimalList.size(); k++){
                if(AnimalList.at(k)->getX() == P.getposX()-1 && AnimalList.at(k)->getY() == P.getposY()){
                    if(AnimalList.at(k)->getAnimalType() == "goat"){
                        P.addItem("goatMeat",1);
                        cout<<"a"<<endl;
                    }
                    else if (AnimalList.at(k)->getAnimalType() == "pig"){
                        P.addItem("pigMeat",1);
                        cout<<"a"<<endl;
                    }
                    else if(AnimalList.at(k)->getAnimalType() == "cow"){
                            P.addItem("cowMeat",1);
                            cout<<"a"<<endl;
                    }                    
                    AnimalList.at(k)->kill();
                    AnimalList.erase(AnimalList.begin() + k);
                    break;
                }
                else if(AnimalList.at(k)->getX() == P.getposX()+1 && AnimalList.at(k)->getY() == P.getposY()){
                    if(AnimalList.at(k)->getAnimalType() == "goat"){
                        P.addItem("goatMeat",1);
                        cout<<"a";
                    }
                    else if (AnimalList.at(k)->getAnimalType() == "pig"){
                        P.addItem("pigMeat",1);
                        cout<<"a";
                    }
                    else if(AnimalList.at(k)->getAnimalType() == "cow"){
                            P.addItem("cowMeat",1);
                    }
                    AnimalList.at(k)->kill();
                    AnimalList.erase(AnimalList.begin() + k);
                    break;
                }
                else if(AnimalList.at(k)->getX() == P.getposX() && AnimalList.at(k)->getY() == P.getposY()-1){
                    if(AnimalList.at(k)->getAnimalType() == "goat"){
                        P.addItem("goatMeat",1);
                        cout<<"a"<<endl;
                    }
                    else if (AnimalList.at(k)->getAnimalType() == "pig"){
                        P.addItem("pigMeat",1);
                        cout<<"a"<<endl;
                    }
                    else if(AnimalList.at(k)->getAnimalType() == "cow"){
                            P.addItem("cowMeat",1);
                            cout<<"a"<<endl;
                    }
                    AnimalList.at(k)->kill();
                    AnimalList.erase(AnimalList.begin() + k);
                    break;
                }
                else if(AnimalList.at(k)->getX() == P.getposX() && AnimalList.at(k)->getY() == P.getposY()+1){
                    if(AnimalList.at(k)->getAnimalType() == "goat"){
                        P.addItem("goatMeat",1);
                        cout<<"a"<<endl;
                    }
                    else if (AnimalList.at(k)->getAnimalType() == "pig"){
                        P.addItem("pigMeat",1);
                        cout<<"a"<<endl;
                    }
                    else if(AnimalList.at(k)->getAnimalType() == "cow"){
                            P.addItem("cowMeat",1);
                            cout<<"a"<<endl;
                    }
                    AnimalList.at(k)->kill();
                    AnimalList.erase(AnimalList.begin() + k);
                    break;
                }
            }
        }
        else if (coba == 'F') {
            bool found = false;
            for(int k = 0; k < FacilityList.size() ; k++){
                if(FacilityList.at(k)->getFacilityType() == "Well"){
                    if(FacilityList.at(k)->getX() == P.getposX()){
                        if ((FacilityList.at(k)->getY() == P.getposY()-1) || (FacilityList.at(k)->getY() == P.getposY()+1) ){
                            P.addWater();
                            found = true;
                        }
                        break;
                    }
                    else if( (FacilityList.at(k)->getX() == P.getposX()+1) || (FacilityList.at(k)->getX() == P.getposX()-1) ){
                        if(FacilityList.at(k)->getY() == P.getposY()){
                            P.addWater();
                            found = true;
                        }
                        break;
                    }
                }
            }
            if(!found){
                cout << "No well near your place" << endl;
            }
        }
        else if (coba == 'M') {
            bool found = false;
            string m1,m2;
            for(int k = 0; k < FacilityList.size() ; k++){
                if(FacilityList.at(k)->getFacilityType() == "Mixer"){
                    if(FacilityList.at(k)->getX() == P.getposX()){
                        if ((FacilityList.at(k)->getY() == P.getposY()-1) || (FacilityList.at(k)->getY() == P.getposY()+1) ){
                            found = true;
                            cin >> m1;
                            cin >> m2;
                            if (P.isMixtureAvailable(m1, m2)) {
                                if (m1 == "duckEgg" && m2 == "chickenEgg") {
                                    P.subItem("duckEgg");
                                    P.subItem("chickenEgg");
                                    P.addItem("Martabak", 1);
                                }
                                else if (m1 == "chickenEgg" && m2 == "cowMilk") {
                                    P.subItem("chickenEgg");
                                    P.subItem("cowMilk");
                                    P.addItem("Omelette", 1);
                                }
                                else if (m1 == "horseMilk" && m2 == "goatMeat") {
                                    P.subItem("horseMilk");
                                    P.subItem("goatMeat");
                                    P.addItem("Satay", 1);
                                }
                                else if (m1 == "pigMeat" && m2 == "cowMeat") {
                                    P.subItem("pigMeat");
                                    P.subItem("cowMeat");
                                    P.addItem("Stew", 1);
                                }
                            }
                            else {
                                cout << "Mixture not available" << endl;
                            }
                        }
                        break;
                    }
                    else if( (FacilityList.at(k)->getX() == P.getposX()+1) || (FacilityList.at(k)->getX() == P.getposX()-1) ){
                        if(FacilityList.at(k)->getY() == P.getposY()){
                            found = true;
                            cin >> m1;
                            cin >> m2;
                            if (P.isMixtureAvailable(m1, m2)) {
                                if (m1 == "duckEgg" && m2 == "chickenEgg") {
                                    P.subItem("duckEgg");
                                    P.subItem("chickenEgg");
                                    P.addItem("Martabak", 1);
                                }
                                else if (m1 == "chickenEgg" && m2 == "cowMilk") {
                                    P.subItem("chickenEgg");
                                    P.subItem("cowMilk");
                                    P.addItem("Omelette", 1);
                                }
                                else if (m1 == "horseMilk" && m2 == "goatMeat") {
                                    P.subItem("horseMilk");
                                    P.subItem("goatMeat");
                                    P.addItem("Satay", 1);
                                }
                                else if (m1 == "pigMeat" && m2 == "cowMeat") {
                                    P.subItem("pigMeat");
                                    P.subItem("cowMeat");
                                    P.addItem("Stew", 1);
                                }
                            }
                            else {
                                cout << "Mixture not available" << endl;
                            }
                        }
                        break;
                    }
                }
            }
            if(!found)
                cout << "No mixer near your place" << endl;
        }
        else if (coba == 'Z') {
            P.sellItem();
        }
        else if (coba == 'G'){
            for(int k = 0 ; k < mapList.size(); k++){
                if( P.getWater()>0 ){
                    P.subWater();
                    if(mapList.at(k)->getX() == P.getposX() && mapList.at(k)->getY() == P.getposY()){
                        mapList.at(k)->setRumput(true);
                    }
                    break;
                }
                else{
                    cout << "Insufficient Water" << endl;
                    break;
                }
            }
        }else if(coba == 'H'){
            showHelp();
        }
    }
    showGameOver(P);
    // Coop C1(1,2);
    // Grassland G1(1,6);
    // Grassland G2(2,6);
    // C1.setRumput(true);
    // G1.setRumput(true);
    // Coop C2(2,2);
    // Well W(1,3);
    // Mixer M(1,4);
    // Truck T(1,5, 10);
    // Chicken Ch(5,5);
    // Duck D(10,10);
    // Horse H(9,9);
    // Cow as(11,11);
    // Pig P(20,20);
    // Goat G(12,12);
    // Barn B1(23, 23);
    // Barn B2(24,24);
    // B1.setRumput(true);

    // cout << "FACILITY" << endl;
    // cout << W.render() << endl;
    // cout << M.render() << endl;
    // cout << T.render() << endl;
    // cout << endl;

    // cout << "LAND" << endl;
    // cout << C1.render() << endl;
    // cout << C2.render() << endl;
    // cout << G1.render() << endl;
    // cout << G2.render() << endl;
    // cout << B1.render() << endl;
    // cout << B2.render() << endl;
    // cout << endl;

    // cout << "ANIMAL" << endl;
    // cout << Ch.getAnimalType() <<endl;
    // cout << Ch.render() << endl;
    // Ch.makeSound();cout<<endl;
    // cout<<"TELUR" << endl;
    // cout<< Ch.getEggProduct()<<endl;
    // Ch.setEggProduct(true);
    // cout<< Ch.getEggProduct()<<endl;
    // cout<<"Laper" << endl;
    // cout<< Ch.getHunggerStage()<<endl;
    // Ch.gettingHungry();
    // cout<< Ch.getHunggerStage()<<endl;
    // cout<< Ch.isHungry() << endl;
    // Ch.gettingHungry();
    // Ch.gettingHungry();
    // Ch.gettingHungry();
    // Ch.gettingHungry();
    // cout<< Ch.isHungry() <<endl;
    // cout<< Ch.render() <<endl;
    // cout << endl;

    // cout << D.getAnimalType() <<endl;
    // cout << D.render() << endl;
    // D.makeSound();cout<<endl;
    // cout<<"TELUR" << endl;
    // cout<< D.getEggProduct()<<endl;
    // D.setEggProduct(true);
    // cout<< D.getEggProduct()<<endl;
    // cout<<"Laper" << endl;
    // cout<< D.getHunggerStage()<<endl;
    // D.gettingHungry();
    // cout<< D.getHunggerStage()<<endl;
    // cout<< D.isHungry() << endl;
    // D.gettingHungry();
    // D.gettingHungry();
    // D.gettingHungry();
    // D.gettingHungry();
    // cout<< D.isHungry() <<endl;
    // cout<< D.render() <<endl;
    // cout <<endl;

    // cout << H.getAnimalType() <<endl;
    // cout << H.render() << endl;
    // H.makeSound();cout<<endl;
    // cout<< H.getHunggerStage()<<endl;
    // H.gettingHungry();
    // H.gettingHungry();
    // H.gettingHungry();
    // H.gettingHungry();
    // H.gettingHungry();
    // cout<< H.isHungry() <<endl;
    // cout<< H.render() <<endl;
    // cout<< endl;

    // cout << as.getAnimalType() <<endl;
    // cout << as.render() << endl;
    // as.makeSound();cout<<endl;
    // cout<< as.getHunggerStage()<<endl;
    // as.gettingHungry();
    // as.gettingHungry();
    // as.gettingHungry();
    // as.gettingHungry();
    // as.gettingHungry();
    // as.move();
    // cout << "--" << endl;
    // as.move();
    // as.move();
    // as.move();
    // as.move();
    // cout<< as.isHungry() <<endl;
    // cout<< as.render() <<endl;
    // cout<< endl;
    // as.kill();

    // cout << P.getAnimalType() <<endl;
    // cout << P.render() << endl;
    // P.makeSound();cout<<endl;
    // cout<< P.getHunggerStage()<<endl;
    // P.gettingHungry();
    // P.gettingHungry();
    // P.gettingHungry();
    // P.gettingHungry();
    // P.gettingHungry();
    // cout<< P.isHungry() <<endl;
    // cout<< P.render() <<endl;
    // cout<< endl;

    // cout << G.getAnimalType() <<endl;
    // cout << G.render() << endl;
    // G.makeSound();cout<<endl;
    // cout<< G.getHunggerStage()<<endl;
    // G.gettingHungry();
    // G.gettingHungry();
    // G.gettingHungry();
    // G.gettingHungry();
    // G.gettingHungry();
    // cout<< G.isHungry() <<endl;
    // cout<< G.render() <<endl;
    // cout<< endl;

    // cout << "test" <<endl;
    return 0;
}