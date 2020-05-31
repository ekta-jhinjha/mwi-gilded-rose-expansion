package gilded.rose.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import gilded.rose.model.Item;

@Service
public class InventoryService {
	private  Map<Item,Integer>mapItems;
	  
	 { 
		 mapItems=new HashMap<Item,Integer>();
		 mapItems.put(new Item("Chocolate","MilkyBar",78),5);
		 mapItems.put(new Item("T Shirt","US Polo",48),4); 
		 mapItems.put(new Item("Pencil","HB Pencil",14),3);
		 mapItems.put(new Item("Notebook","HB Notebook",40),2); 
		 }
	 
	
	
	
	 public List<Item> getAllItemsFromInventory(boolean priceUpdate){
			Collection<Item> keys = mapItems.keySet();
		    ArrayList<Item> listOfKeys =new ArrayList<Item>(keys);
		
		 if(priceUpdate) { 
			 Map<Item,Integer>mapp=new HashMap<Item,Integer>();
			 for(Map.Entry<Item, Integer>temp:mapItems.entrySet()) {
					Item item=temp.getKey();
					int newPrice=item.getPrice()+10*item.getPrice()/100;
					item.setPrice(newPrice);
					mapp.put(item, temp.getValue());
					}
			 mapItems.clear();
			 mapItems.putAll(mapp);
			 keys = mapItems.keySet();
			 listOfKeys =new ArrayList<Item>(keys);
			 return listOfKeys;
			 
		 } 
		 else 
			 return listOfKeys;
			
	}
	
	public String buyRequestedItem(String itemname,String itemDescription, int price) {
		Item item=new Item(itemname,itemDescription,price);
		if(mapItems.get(item)!=0) {
			mapItems.put(item, mapItems.get(item)-1);
			return "You Order has been placed succesfully";
		}
		
		else
			return "Sorry this item is out of stock";
		
		
		
	}
	
	
	
}
