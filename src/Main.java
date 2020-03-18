import java.util.*;
import java.awt.*; 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engisjava.src.renderable.Renderable;
import engisjava.src.renderable.cell.Cell;
import engisjava.src.renderable.cell.facility.Facility;
import engisjava.src.renderable.cell.facility.Mixer;
import engisjava.src.renderable.cell.facility.Truck;
import engisjava.src.renderable.cell.facility.Well;
import engisjava.src.farmanimal.FarmAnimal;
import engisjava.src.farmanimal.Chicken;
import engisjava.src.farmanimal.Cow;
import engisjava.src.farmanimal.Duck;
import engisjava.src.farmanimal.Goat;
import engisjava.src.farmanimal.Horse;
import engisjava.src.farmanimal.Pig;
import engisjava.src.renderable.cell.land.Land;
import engisjava.src.renderable.cell.land.Barn;
import engisjava.src.renderable.cell.land.Coop;
import engisjava.src.renderable.cell.land.Grassland;
import engisjava.Player;
import engisjava.Items;

public class Main {

	public static void renderMap(Matriks obj, Player pl, Vector<FarmAnimal> animal, ArrayList<Facility> facility, JPanel p, JPanel info) {
		p.removeAll();
		addButton(obj, pl, animal, facility, p, info);
		playerinfo(pl, info);
		/* Icons */
		ImageIcon player = new ImageIcon("../icon/Player.png");
		Image playerimg = player.getImage();
		Image newplayer = playerimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		player = new ImageIcon(newplayer);
	
		ImageIcon land = new ImageIcon("../icon/Land.png");
		Image landimg = land.getImage();
		Image newland = landimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		land = new ImageIcon(newland);
	
		ImageIcon grassland = new ImageIcon("../icon/Grassland.png");
		Image grasslandimg = grassland.getImage();
		Image newgrassland = grasslandimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		grassland = new ImageIcon(newgrassland);
	
		ImageIcon coop = new ImageIcon("../icon/Coop.png");
		Image coopimg = coop.getImage();
		Image newcoop = coopimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		coop = new ImageIcon(newcoop);
	
		ImageIcon barn = new ImageIcon("../icon/Barn.png");
		Image barnimg = barn.getImage();
		Image newbarn = barnimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		barn = new ImageIcon(newbarn);
	
		ImageIcon well = new ImageIcon("../icon/Well.png");
		Image wellimg = well.getImage();
		Image newwell = wellimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		well = new ImageIcon(newwell);
	
		ImageIcon truck = new ImageIcon("../icon/Truck.png");
		Image truckimg = truck.getImage();
		Image newtruck = truckimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		truck = new ImageIcon(newtruck);
	
		ImageIcon mixer = new ImageIcon("../icon/Mixer.png");
		Image mixerimg = mixer.getImage();
		Image newmixer = mixerimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		mixer = new ImageIcon(newmixer);
	
		ImageIcon chicken = new ImageIcon("../icon/Chicken.png");
		Image chickenimg = chicken.getImage();
		Image newchicken = chickenimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		chicken = new ImageIcon(newchicken);
	
		ImageIcon cow = new ImageIcon("../icon/Cow.png");
		Image cowimg = cow.getImage();
		Image newcow = cowimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		cow = new ImageIcon(newcow);
	
		ImageIcon duck = new ImageIcon("../icon/Duck.png");
		Image duckimg = duck.getImage();
		Image newduck = duckimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		duck = new ImageIcon(newduck);
	
		ImageIcon goat = new ImageIcon("../icon/Goat.png");
		Image goatimg = goat.getImage();
		Image newgoat = goatimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		goat = new ImageIcon(newgoat);
	
		ImageIcon horse = new ImageIcon("../icon/Horse.png");
		Image horseimg = horse.getImage();
		Image newhorse = horseimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		horse = new ImageIcon(newhorse);
	
		ImageIcon pig = new ImageIcon("../icon/Pig.png");
		Image pigimg = pig.getImage();
		Image newpig = pigimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		pig = new ImageIcon(newpig);
	
		ImageIcon chickenhungry = new ImageIcon("../icon/Chicken hungry.png");
		Image chickenhungryimg = chickenhungry.getImage();
		Image newchickenhungry = chickenhungryimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		chickenhungry = new ImageIcon(newchickenhungry);
	
		ImageIcon cowhungry = new ImageIcon("../icon/Cow hungry.png");
		Image cowhungryimg = cowhungry.getImage();
		Image newcowhungry = cowhungryimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		cowhungry = new ImageIcon(newcowhungry);
	
		ImageIcon duckhungry = new ImageIcon("../icon/Duck hungry.png");
		Image duckhungryimg = duckhungry.getImage();
		Image newduckhungry = duckhungryimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		duckhungry = new ImageIcon(newduckhungry);
	
		ImageIcon goathungry = new ImageIcon("../icon/Goat hungry.png");
		Image goathungryimg = goathungry.getImage();
		Image newgoathungry = goathungryimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		goathungry = new ImageIcon(newgoathungry);
	
		ImageIcon horsehungry = new ImageIcon("../icon/Horse hungry.png");
		Image horsehungryimg = horsehungry.getImage();
		Image newhorsehungry = horsehungryimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		horsehungry = new ImageIcon(newhorsehungry);
	
		ImageIcon pighungry = new ImageIcon("../icon/Pig hungry.png");
		Image pighungryimg = pighungry.getImage();
		Image newpighungry = pighungryimg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		pighungry = new ImageIcon(newpighungry);
		
		/* Rendering */
		JPanel[][] map = new JPanel[11][11];
		int x = 390;
		int y = 10;
		for(int i = 0; i < 11; i++) {
			y = 10;
			for(int j = 0; j < 11; j++) {
				
				JLabel pic = new JLabel(land);
				
				if (i == pl.getX() && j == pl.getY())
					pic = new JLabel(player);
				else if (obj.getData(i, j) == '-')
					pic = new JLabel(land);
				else if (obj.getData(i, j) == '#' || obj.getData(i, j) == '@' || obj.getData(i, j) == '*')
					pic = new JLabel(grassland);
				else if (obj.getData(i, j) == 'x')
					pic = new JLabel(barn);
				else if (obj.getData(i, j) == 'o')
					pic = new JLabel(coop);
				else if (obj.getData(i, j) == 'W')
					pic = new JLabel(well);
				else if (obj.getData(i, j) == 'T')
					pic = new JLabel(truck);
				else if (obj.getData(i, j) == 'M')
					pic = new JLabel(mixer);
				else
					pic = new JLabel();
					
				for (int k = 0; k < animal.size(); k++) {
					if (i == animal.get(k).getPosX() && j == animal.get(k).getPosY()) {
						if (animal.get(k).render() == 'A')
							pic = new JLabel(chicken);
						else if (animal.get(k).render() == 'a')
							pic = new JLabel(chickenhungry);
						else if (animal.get(k).render() == 'C')
							pic = new JLabel(cow);
						else if (animal.get(k).render() == 'c')
							pic = new JLabel(cowhungry);
						else if (animal.get(k).render() == 'H')
							pic = new JLabel(horse);
						else if (animal.get(k).render() == 'h')
							pic = new JLabel(horsehungry);
						else if (animal.get(k).render() == 'P')
							pic = new JLabel(pig);
						else if (animal.get(k).render() == 'p')
							pic = new JLabel(pighungry);
						else if (animal.get(k).render() == 'D')
							pic = new JLabel(duck);
						else if (animal.get(k).render() == 'd')
							pic = new JLabel(duckhungry);
						else if (animal.get(k).render() == 'G')
							pic = new JLabel(goat);
						else if (animal.get(k).render() == 'g')
							pic = new JLabel(goathungry);
					}
				}
				map[i][j] = new JPanel();
				map[i][j].add(pic);
				map[i][j].setBorder(BorderFactory.createEmptyBorder(-5, -5, -5, -5));
				map[i][j].setBackground(Color.decode("#974A02"));
				map[i][j].setBounds(x, y, 60, 60);
				p.add(map[i][j]);
				y += 60;
			}
			x += 60;
		}
		p.setVisible(true);
		p.revalidate();
		p.repaint();
	}
	public static void playerinfo (Player<String,Integer> pl, JPanel info){
		info.removeAll();
		info.setLayout(null);
		info.setSize(new Dimension(300, 300));
		JLabel inf = new JLabel("---PLAYER INFORMATION---");
		JLabel money = new JLabel("Money : " + pl.getMoney());
		JLabel water = new JLabel("Water: " + pl.getWater());
		JLabel position = new JLabel("Current position : "+ pl.getX()+"-"+pl.getY());
		// JLabel into = new JLabel("Current heading to : "+ pl.getInto());
		JLabel item = new JLabel("Item(s) in inventory : "+ pl.getNbItem());
		JLabel items = new JLabel("List of items: ");
		int start = 110;

		info.add(inf);
		inf.setBounds(20,10,200,20);
		info.add(money);
		money.setBounds(20,30,200,20);
		info.add(water);
		water.setBounds(20,50,200,20);
		info.add(position);
		position.setBounds(20,70,200,20);
		// info.add(into);
		// into.setBounds(20,70,200,20);
		info.add(item);
		item.setBounds(20,90,200,20);
		info.add(items);
		items.setBounds(20,start,200,20);
		start+=20;
		
		JLabel allItems;
		if(pl.isInventoryEmpty()){
			allItems = new JLabel("Inventory is empty");
			info.add(allItems);
			allItems.setBounds(20,start,200,20);
		}
		else{
			int total = pl.numItemType();
			for(int i = 0 ; i < total ; i++){
				String name = (String)pl.getItemAt(i);
				int number = (int)pl.getNumberAtItem(i);
				System.out.println(name);
				System.out.println(number);
				for(int j = 0 ; j < number ; j++){
					allItems = new JLabel(name);
					info.add(allItems);
					allItems.setBounds(20,start,200,20);
					start+=20;
				}
			}
		}
	}

	public static void moveanimal(Vector<FarmAnimal> an) {
		for(int i = 0; i < an.size(); i++) {
				an.get(i).move();
		}
	}

	public static void eatGrass(Matriks obj, Vector<FarmAnimal> animal){
		int x;
		int y;

		for(int i = 0; i < animal.size(); i++) {
			x = animal.get(i).getPosX();
			y = animal.get(i).getPosY();
			if(obj.getCell(x,y).getRumput() && animal.get(i).isHungry()){
				animal.get(i).eat();
				obj.getCell(x,y).setRumput(false);
			}
		}
	}

	public static void addButton(Matriks obj, Player pl, Vector<FarmAnimal> animal, ArrayList<Facility> fac, JPanel p, JPanel info){

			JButton l = new JButton("Left");
			l.setBounds(1100, 600, 60, 40);
			p.add(l);
			l.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pl.setX(pl.getX() - 1);
				moveanimal(animal); eatGrass(obj, animal);
				eatGrass(obj, animal);
				renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Right button */
			JButton r = new JButton("Right");
			r.setBounds(1220, 600, 60, 40);
			p.add(r);
			r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pl.setX(pl.getX() + 1);
				moveanimal(animal); eatGrass(obj, animal);
				renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Up button */
			JButton u = new JButton("Up");
			u.setBounds(1160, 560, 60, 40);
			p.add(u);
			u.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pl.setY(pl.getY() - 1);
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Down button */
			JButton d = new JButton("Down");
			p.add(d);
			d.setBounds(1160, 640, 60, 40);
			d.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pl.setY(pl.getY() + 1);
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Talk button */
			JButton t = new JButton("Talk");
			p.add(t);
			t.setBounds(20, 580, 90, 40);
			t.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					for (int k = 0; k < animal.size(); k++){
						if (pl.getX() == animal.get(k).getPosX()) {
							if (pl.getY() - 1 == animal.get(k).getPosY() || pl.getY() + 1 == animal.get(k).getPosY()) {
								if(animal.get(k).getAnimalType()== "chicken"){
									JOptionPane.showMessageDialog(null, "Petok petok!!");
								} else if(animal.get(k).getAnimalType()== "duck"){
									JOptionPane.showMessageDialog(null, "Quack quack!!");
								}  else if(animal.get(k).getAnimalType()== "cow"){
									JOptionPane.showMessageDialog(null, "Moo moo!!");
								} else if(animal.get(k).getAnimalType()== "goat"){
									JOptionPane.showMessageDialog(null, "Mbee mbee!!");
								} else if(animal.get(k).getAnimalType()== "horse"){
									JOptionPane.showMessageDialog(null, "Heeeyaa heeeyaa!!");
								} else if(animal.get(k).getAnimalType()== "pig"){
									JOptionPane.showMessageDialog(null, "Ngoik ngoik!!");
								}
							}
						}
						else if (pl.getX() - 1 == animal.get(k).getPosX() || pl.getX() + 1 == animal.get(k).getPosX()) {
							if (pl.getY() == animal.get(k).getPosY()) {
								if(animal.get(k).getAnimalType()== "chicken"){
									JOptionPane.showMessageDialog(null, "Petok petok!!");
								} else if(animal.get(k).getAnimalType()== "duck"){
									JOptionPane.showMessageDialog(null, "Quack quack!!");
								}  else if(animal.get(k).getAnimalType()== "cow"){
									JOptionPane.showMessageDialog(null, "Moo moo!!");
								} else if(animal.get(k).getAnimalType()== "goat"){
									JOptionPane.showMessageDialog(null, "Mbee mbee!!");
								} else if(animal.get(k).getAnimalType()== "horse"){
									JOptionPane.showMessageDialog(null, "Heeeyaa heeeyaa!!");
								} else if(animal.get(k).getAnimalType()== "pig"){
									JOptionPane.showMessageDialog(null, "Ngoik ngoik!!");
								}
							}
						}
					}
				moveanimal(animal); eatGrass(obj, animal);
				renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Interact button */
			JButton in = new JButton("Interact");
			p.add(in);
			in.setBounds(20, 620, 90, 40);
			in.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					for (int k = 0; k < animal.size(); k++){
						if (pl.getX() == animal.get(k).getPosX()) {
							if (pl.getY() - 1 == animal.get(k).getPosY() || pl.getY() + 1 == animal.get(k).getPosY()) {
								if(animal.get(k).getAnimalType()== "chicken" || animal.get(k).getProduct()){
									pl.addItem("chickenEgg", 1);
									animal.get(k).setProduct(false);
								} else if(animal.get(k).getAnimalType()== "duck" || animal.get(k).getProduct()){
									pl.addItem("duckEgg", 1);
									animal.get(k).setProduct(false);
								} else if(animal.get(k).getAnimalType()== "cow" || animal.get(k).getProduct()){
									pl.addItem("cowMilk", 1);
									animal.get(k).setProduct(false);
								}else if(animal.get(k).getAnimalType()== "horse" || animal.get(k).getProduct()){
									pl.addItem("horseMilk", 1);
									animal.get(k).setProduct(false);
								}
							}
						}
						else if (pl.getX() - 1 == animal.get(k).getPosX() || pl.getX() + 1 == animal.get(k).getPosX()) {
							if (pl.getY() == animal.get(k).getPosY()) {
								if(animal.get(k).getAnimalType()== "chicken" || animal.get(k).getProduct()){
									pl.addItem("chickenEgg", 1);
									animal.get(k).setProduct(false);
								} else if(animal.get(k).getAnimalType()== "duck" || animal.get(k).getProduct()){
									pl.addItem("duckEgg", 1);
									animal.get(k).setProduct(false);
								} else if(animal.get(k).getAnimalType()== "cow" || animal.get(k).getProduct()){
									pl.addItem("cowMilk", 1);
									animal.get(k).setProduct(false);
								}else if(animal.get(k).getAnimalType()== "horse" || animal.get(k).getProduct()){
									pl.addItem("horseMilk", 1);
									animal.get(k).setProduct(false);
								}
							}
						}
					}
				moveanimal(animal); eatGrass(obj, animal);
				renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Kill button */
			JButton ki = new JButton("Kill");
			p.add(ki);
			ki.setBounds(20, 660, 90, 40);
			ki.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					for (int k = 0; k < animal.size(); k++){
						if (pl.getX() == animal.get(k).getPosX()) {
							if (pl.getY() - 1 == animal.get(k).getPosY() || pl.getY() + 1 == animal.get(k).getPosY()) {
								//animal.get(k).kill();
								if(animal.get(k).getAnimalType()== "goat"){
									animal.remove(k);
									pl.addItem("goatMeat", 1);
								} else if(animal.get(k).getAnimalType()== "cow"){
									animal.remove(k);
									pl.addItem("cowMeat", 1);
								} else if(animal.get(k).getAnimalType()== "pig"){
									animal.remove(k);
									pl.addItem("pigMeat", 1);
								}
							}
						}
						else if (pl.getX() - 1 == animal.get(k).getPosX() || pl.getX() + 1 == animal.get(k).getPosX()) {
							if (pl.getY() == animal.get(k).getPosY()) {
								//animal.get(k).kill();
								if(animal.get(k).getAnimalType()== "goat"  ){
									animal.remove(k);
									pl.addItem("goatMeat", 1);
								} else if(animal.get(k).getAnimalType()== "cow"){
									animal.remove(k);
									pl.addItem("cowMeat", 1);
								} else if(animal.get(k).getAnimalType()== "pig"){
									animal.remove(k);
									pl.addItem("pigMeat", 1);
								}
							}
						}
					}
				moveanimal(animal); eatGrass(obj, animal);
				renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Fill button */
			JButton f = new JButton("Fill");
			f.setBounds(110, 580, 90, 40);
			p.add(f);
			f.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (pl.getX() == fac.get(0).getX()) {
						if (pl.getY() - 1 == fac.get(0).getY() || pl.getY() + 1 == fac.get(0).getY()) {
							pl.addWater();
						}
					}
					else if (pl.getX() - 1 == fac.get(0).getX() || pl.getX() + 1 == fac.get(0).getX()) {
						if (pl.getY() == fac.get(0).getY()) {
							pl.addWater();
						}
					}
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Sell button */
			JButton s = new JButton("Sell");
			s.setBounds(110, 620, 90, 40);
			p.add(s);
			s.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (pl.getX() == fac.get(2).getX()) {
						if (pl.getY() - 1 == fac.get(2).getY() || pl.getY() + 1 == fac.get(2).getY()) {
							// if (pl.isInventoryEmpty()){
							// 	System.out.println("There is nothing to sell");
							// }
							// else{
								pl.sellItem();
							// }
						}
					}
					else if (pl.getX() - 1 == fac.get(2).getX() || pl.getX() + 1 == fac.get(2).getX()) {
						if (pl.getY() == fac.get(2).getY()) {
							// if (pl.isInventoryEmpty()){
							// 	System.out.println("There is nothing to sell");
							// }
							// else{
								pl.sellItem();
							// }
						}
					}
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Grow button */
			JButton g = new JButton("Grow");
			p.add(g);
			g.setBounds(110, 660, 90, 40);
			g.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pl.getWater() > 0) {
						pl.subWater();
						obj.getCell(pl.getX(), pl.getY()).setRumput(true);
					}
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Input mixture */
			JTextField m1 = new JTextField();
			p.add(m1);
			m1.setBounds(200, 580, 90, 40);
			JTextField m2 = new JTextField();
			m2.setBounds(200, 620, 90, 40);
			p.add(m2);

			/* Mix button */
			JButton m = new JButton("Mix");
			p.add(m);
			m.setBounds(200, 660, 90, 40);
			m.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pl.getX() == fac.get(1).getX()) {
						if (pl.getY() - 1 == fac.get(1).getY() || pl.getY() + 1 == fac.get(1).getY()) {
							String mix1 = m1.getText();
							String mix2 = m2.getText();
							System.out.println(mix1);
							System.out.println(mix2);
							pl.mix(mix1, mix2);
							System.out.println("Campurrrr");
						}
					}
					else if (pl.getX() - 1 == fac.get(1).getX() || pl.getX() + 1 == fac.get(1).getX()) {
						if (pl.getY() == fac.get(1).getY()) {
							String mix1 = m1.getText();
							String mix2 = m2.getText();
							System.out.println(mix1);
							System.out.println(mix2);
							pl.mix(mix1, mix2);
							System.out.println("Campurrrr");
						}
					}
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});

	}

	public static void main (String[] args) {
			Display frm = new Display("Engi's Farm");
			JButton l, r, u, d, t, in, ki, f, m, s, g;
			JTextField m1, m2;
			Matriks obj = new Matriks();
			JPanel p = new JPanel();
			JPanel info = new JPanel();
			
			Player<String,Integer> pl = new Player<String,Integer>(5,5);
			
			Vector<FarmAnimal> animal = new Vector<FarmAnimal>();
			Chicken ch = new Chicken(1, 1);
			Duck du = new Duck(2, 1);
			Goat go = new Goat(5, 4);
			Pig pi = new Pig(6, 3);
			Cow co = new Cow(7, 8);
			Horse ho = new Horse(9, 9);
			animal.add(ch);
			animal.add(du);
			animal.add(go);
			animal.add(pi);
			animal.add(co);
			animal.add(ho);
			// animal.add(new Chicken(1, 1));
			// animal.get(0).setPosX(1);
			// animal.add(new Duck(2, 1));
			// animal.add(new Goat(5, 4));
			// animal.add(new Pig(6, 3));
			// animal.add(new Cow(7, 8));
			// animal.add(new Horse(9, 9));

			ArrayList<Facility> fac = new ArrayList<Facility>(3);
			fac.add(new Well(9, 0));
			fac.add(new Mixer(9, 1));
			fac.add(new Truck(9, 3, 10));
			
			obj.setData(0, 0, new Coop(0, 0));
			obj.setData(0, 1, new Coop(0, 1));
			obj.setData(0, 2, new Coop(0, 2));
			obj.setData(0, 3, new Coop(0, 3));
			obj.setData(0, 4, new Grassland(0, 4));
			obj.setData(0, 5, new Grassland(0, 5));
			obj.setData(0, 6, new Grassland(0, 6));

			obj.setData(0, 7, new Grassland(0, 7));
			obj.setData(0, 8, new Grassland(0, 8));
			obj.setData(0, 9, new Grassland(0, 9));
			obj.setData(0, 10, new Grassland(0, 10));
			
			obj.setData(1, 0, new Coop(1, 0));
			obj.setData(1, 1, new Coop(1, 1));
			obj.setData(1, 2, new Coop(1, 2));
			obj.setData(1, 3, new Coop(1, 3));
			obj.setData(1, 4, new Grassland(1, 4));
			obj.setData(1, 5, new Grassland(1, 5));
			obj.setData(1, 6, new Grassland(1, 6));
			obj.setData(1, 7, new Grassland(1, 7));
			obj.setData(1, 8, new Grassland(1, 8));
			obj.setData(1, 9, new Grassland(1, 9));
			obj.setData(1, 10, new Grassland(1, 10));
			
			obj.setData(2, 0, new Coop(2, 0));
			obj.setData(2, 1, new Coop(2, 1));
			obj.setData(2, 2, new Coop(2, 2));
			obj.setData(2, 3, new Coop(2, 3));
			obj.setData(2, 4, new Grassland(2, 4));
			obj.setData(2, 5, new Grassland(2, 5));
			obj.setData(2, 6, new Grassland(2, 6));
			obj.setData(2, 7, new Grassland(2, 7));
			obj.setData(2, 8, new Grassland(2, 8));
			obj.setData(2, 9, new Grassland(2, 9));
			obj.setData(2, 10, new Grassland(2, 10));

			obj.setData(3, 0, new Barn(3, 0));
			obj.setData(3, 1, new Barn(3, 1));
			obj.setData(3, 2, new Barn(3, 2));
			obj.setData(3, 3, new Barn(3, 3));
			obj.setData(3, 4, new Grassland(3, 4));
			obj.setData(3, 5, new Grassland(3, 5));
			obj.setData(3, 6, new Grassland(3, 6));
			obj.setData(3, 7, new Grassland(3, 7));
			obj.setData(3, 8, new Grassland(3, 8));
			obj.setData(3, 9, new Grassland(3, 9));
			obj.setData(3, 10, new Grassland(3, 10));
			
			obj.setData(4, 0, new Barn(4, 0));
			obj.setData(4, 1, new Barn(4, 1));
			obj.setData(4, 2, new Barn(4, 2));
			obj.setData(4, 3, new Barn(4, 3));
			obj.setData(4, 4, new Grassland(4, 4));
			obj.setData(4, 5, new Grassland(4, 5));
			obj.setData(4, 6, new Grassland(4, 6));
			obj.setData(4, 7, new Grassland(4, 7));
			obj.setData(4, 8, new Grassland(4, 8));
			obj.setData(4, 9, new Grassland(4, 9));
			obj.setData(4, 10, new Grassland(4, 10));
			
			obj.setData(5, 0, new Barn(5, 0));
			obj.setData(5, 1, new Barn(5, 1));
			obj.setData(5, 2, new Barn(5, 2));
			obj.setData(5, 3, new Barn(5, 3));
			obj.setData(5, 4, new Grassland(5, 4));
			obj.setData(5, 5, new Grassland(5, 5));
			obj.setData(5, 6, new Grassland(5, 6));
			obj.setData(5, 7, new Grassland(5, 7));
			obj.setData(5, 8, new Grassland(5, 8));
			obj.setData(5, 9, new Grassland(5, 9));
			obj.setData(5, 10, new Grassland(5, 10));
			
			obj.setData(6, 0, new Grassland(6, 0));
			obj.setData(6, 1, new Grassland(6, 1));
			obj.setData(6, 2, new Grassland(6, 2));
			obj.setData(6, 3, new Grassland(6, 3));
			obj.setData(6, 4, new Grassland(6, 4));
			obj.setData(6, 5, new Grassland(6, 5));
			obj.setData(6, 6, new Grassland(6, 6));
			obj.setData(6, 7, new Grassland(6, 7));
			obj.setData(6, 8, new Grassland(6, 8));
			obj.setData(6, 9, new Grassland(6, 9));
			obj.setData(6, 10, new Grassland(6, 10));

			obj.setData(7, 0, new Grassland(7, 0));
			obj.setData(7, 1, new Grassland(7, 1));
			obj.setData(7, 2, new Grassland(7, 2));
			obj.setData(7, 3, new Grassland(7, 3));
			obj.setData(7, 4, new Grassland(7, 4));
			obj.setData(7, 5, new Grassland(7, 5));
			obj.setData(7, 6, new Grassland(7, 6));
			obj.setData(7, 7, new Grassland(7, 7));
			obj.setData(7, 8, new Grassland(7, 8));
			obj.setData(7, 9, new Grassland(7, 9));
			obj.setData(7, 10, new Grassland(7, 10));

			obj.setData(8, 0, new Grassland(8, 0));
			obj.setData(8, 1, new Grassland(8, 1));
			obj.setData(8, 2, new Grassland(8, 2));
			obj.setData(8, 3, new Grassland(8, 3));
			obj.setData(8, 4, new Grassland(8, 4));
			obj.setData(8, 5, new Grassland(8, 5));
			obj.setData(8, 6, new Grassland(8, 6));
			obj.setData(8, 7, new Grassland(8, 7));
			obj.setData(8, 8, new Grassland(8, 8));
			obj.setData(8, 9, new Grassland(8, 9));
			obj.setData(8, 10, new Grassland(8, 10));

			obj.setData(9, 0, new Well(9, 0));
			obj.setData(9, 1, new Mixer(9, 1));
			obj.setData(9, 2, new Grassland(9, 2));
			obj.setData(9, 3, new Truck(9, 3, 10));
			obj.setData(9, 4, new Grassland(9, 4));
			obj.setData(9, 5, new Grassland(9, 5));
			obj.setData(9, 6, new Grassland(9, 6));
			obj.setData(9, 7, new Grassland(9, 7));
			obj.setData(9, 8, new Grassland(9, 8));
			obj.setData(9, 9, new Grassland(9, 9));
			obj.setData(9, 10, new Grassland(9, 10));

			obj.setData(10, 0, new Grassland(10, 0));
			obj.setData(10, 1, new Grassland(10, 1));
			obj.setData(10, 2, new Grassland(10, 2));
			obj.setData(10, 3, new Grassland(10, 3));
			obj.setData(10, 4, new Grassland(10, 4));
			obj.setData(10, 5, new Grassland(10, 5));
			obj.setData(10, 6, new Grassland(10, 6));
			obj.setData(10, 7, new Grassland(10, 7));
			obj.setData(10, 8, new Grassland(10, 8));
			obj.setData(10, 9, new Grassland(10, 9));
			obj.setData(10, 10, new Grassland(10, 10));
			
			renderMap(obj, pl, animal, fac, p, info);
			
			playerinfo(pl, info);
			frm.getContentPane().add(info);
			
			/* Left button */
			l = new JButton("Left");
			p.setLayout(null);
			l.setBounds(1100, 600, 60, 40);
			l.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pl.setX(pl.getY() - 1);
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});
			frm.getContentPane().add(p);
			p.add(l);
			
			/* Right button */
			r = new JButton("Right");
			p.setLayout(null);
			r.setBounds(1220, 600, 60, 40);
			p.add(r);
			r.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pl.setX(pl.getY() + 1);
					moveanimal(animal); eatGrass(obj, animal);
					p.add(r);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});
			frm.getContentPane().add(p);
			
			/* Up button */
			u = new JButton("Up");
			p.setLayout(null);
			u.setBounds(1160, 560, 60, 40);
			u.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pl.setY(pl.getX() - 1);
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});
			p.add(u);
			frm.getContentPane().add(p);
			
			/* Down button */
			d = new JButton("Down");
			p.setLayout(null);
			d.setBounds(1160, 640, 60, 40);
			d.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pl.setY(pl.getX() + 1);
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});
			p.add(d);
			frm.getContentPane().add(p);

			/* Talk button */
			t = new JButton("Talk");
			p.add(t);
			t.setBounds(20, 580, 90, 40);
			t.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					for (int k = 0; k < animal.size(); k++){
						if (pl.getX() == animal.get(k).getPosX()) {
							if (pl.getY() - 1 == animal.get(k).getPosY() || pl.getY() + 1 == animal.get(k).getPosY()) {
								animal.get(k).makeSound();
							}
						}
						else if (pl.getX() - 1 == animal.get(k).getPosX() || pl.getX() + 1 == animal.get(k).getPosX()) {
							if (pl.getY() == animal.get(k).getPosY()) {
								animal.get(k).makeSound();
							}
						}
					}
				moveanimal(animal); eatGrass(obj, animal);
				renderMap(obj, pl, animal, fac, p, info);
				}
			});

			/* Interact button */
			in = new JButton("Interact");
			p.setLayout(null);
			in.setBounds(20, 620, 90, 40);
			p.add(in);
			frm.getContentPane().add(p);
			
			/* Kill button */
			ki = new JButton("Kill");
			p.add(ki);
			ki.setBounds(20, 660, 90, 40);
			ki.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					for (int k = 0; k < animal.size(); k++){
						if (pl.getX() == animal.get(k).getPosX()) {
							if (pl.getY() - 1 == animal.get(k).getPosY() || pl.getY() + 1 == animal.get(k).getPosY()) {
								//animal.get(k).kill();
								if(animal.get(k).getAnimalType()== "goat"){
									animal.remove(k);
									pl.addItem("goatMeat", 1);
								} else if(animal.get(k).getAnimalType()== "cow"){
									animal.remove(k);
									pl.addItem("cowMeat", 1);
								} else if(animal.get(k).getAnimalType()== "pig"){
									animal.remove(k);
									pl.addItem("pigMeat", 1);
								}
							}
						}
						else if (pl.getX() - 1 == animal.get(k).getPosX() || pl.getX() + 1 == animal.get(k).getPosX()) {
							if (pl.getY() == animal.get(k).getPosY()) {
								//animal.get(k).kill();
								if(animal.get(k).getAnimalType()== "goat"  ){
									animal.remove(k);
									pl.addItem("goatMeat", 1);
								} else if(animal.get(k).getAnimalType()== "cow"){
									animal.remove(k);
									pl.addItem("cowMeat", 1);
								} else if(animal.get(k).getAnimalType()== "pig"){
									animal.remove(k);
									pl.addItem("pigMeat", 1);
								}
							}
						}
					}
				moveanimal(animal); eatGrass(obj, animal);
				renderMap(obj, pl, animal, fac, p, info);
				}
			});
			frm.getContentPane().add(p);
			
			/* Fill button */
			f = new JButton("Fill");
			p.setLayout(null);
			f.setBounds(110, 580, 90, 40);
			f.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (pl.getX() == fac.get(0).getX()) {
						if (pl.getY() - 1 == fac.get(0).getY() || pl.getY() + 1 == fac.get(0).getY()) {
							pl.addWater();
						}
					}
					else if (pl.getX() - 1 == fac.get(0).getX() || pl.getX() + 1 == fac.get(0).getX()) {
						if (pl.getY() == fac.get(2).getY()) {
							pl.addWater();
						}
					}
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});
			p.add(f);
			frm.getContentPane().add(p);
			
			/* Sell button */
			s = new JButton("Sell");
			p.setLayout(null);
			s.setBounds(110, 620, 90, 40);
			s.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (pl.getX() == fac.get(2).getX()) {
						if (pl.getY() - 1 == fac.get(2).getY() || pl.getY() + 1 == fac.get(2).getY()) {
							// if (pl.isInventoryEmpty()){
							// 	System.out.println("There is nothing to sell");
							// }
							// else{
								pl.sellItem();
							// }
						}
					}
					else if (pl.getX() - 1 == fac.get(2).getX() || pl.getX() + 1 == fac.get(2).getX()) {
						if (pl.getY() == fac.get(2).getY()) {
							// if (pl.isInventoryEmpty()){
							// 	System.out.println("There is nothing to sell");
							// }
							// else{
								pl.sellItem();
							// }
						}
					}
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});
			p.add(s);
			frm.getContentPane().add(p);
			
			/* Grow button */
			g = new JButton("Grow");
			p.setLayout(null); 
			g.setBounds(110, 660, 90, 40);
			g.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pl.getWater() > 0) {
						pl.subWater();
						obj.getCell(pl.getX(), pl.getY()).setRumput(true);
					}
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});
			p.add(g);
			frm.getContentPane().add(p);
			
			/* Input mixture */
			m1 = new JTextField();
			p.setLayout(null);
			m1.setBounds(200, 580, 90, 40);
			p.add(m1);
			frm.getContentPane().add(p);

			m2 = new JTextField();
			p.setLayout(null);
			m2.setBounds(200, 620, 90, 40);
			p.add(m2);
			frm.getContentPane().add(p);
			
			/* Mix button */
			m = new JButton("Mix");
			p.setLayout(null);
			m.setBounds(200, 660, 90, 40);
			m.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (pl.getX() == fac.get(1).getX()) {
						if (pl.getY() - 1 == fac.get(1).getY() || pl.getY() + 1 == fac.get(1).getY()) {
							String mix1 = m1.getText();
							String mix2 = m2.getText();
							System.out.println(mix1);
							System.out.println(mix2);
							pl.mix(mix1, mix2);
							System.out.println("Campurrrr");
						}
					}
					else if (pl.getX() - 1 == fac.get(1).getX() || pl.getX() + 1 == fac.get(1).getX()) {
						if (pl.getY() == fac.get(1).getY()) {
							String mix1 = m1.getText();
							String mix2 = m2.getText();
							System.out.println(mix1);
							System.out.println(mix2);
							pl.mix(mix1, mix2);
							System.out.println("Campurrrr");
						}
					}
					moveanimal(animal); eatGrass(obj, animal);
					renderMap(obj, pl, animal, fac, p, info);
				}
			});
			p.add(m);
			frm.getContentPane().add(p);

			frm.setSize(1366, 750);
			frm.setVisible(true);
	}
}