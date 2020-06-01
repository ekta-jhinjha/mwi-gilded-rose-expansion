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
		 mapItems.put(new Item(11,"Chocolate","MilkyBar",78),5);
		 mapItems.put(new Item(12,"T Shirt","US Polo",48),4); 
		 mapItems.put(new Item(13,"Pencil","HB Pencil",14),3);
		 mapItems.put(new Item(14,"Notebook","HB Notebook",40),2); 
		 }
	 
	
	 static boolean surgedPrice=false;
	
	 public List<Item> getAllItemsFromInventory(boolean priceUpdate){
		 System.out.println("Start of method getAllItemsFromInventory and priceUpdate value "+priceUpdate);
			Collection<Item> keys = mapItems.keySet();
		    ArrayList<Item> listOfKeys =new ArrayList<Item>(keys);
		
		 if(priceUpdate && !surgedPrice ) { 
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
			 surgedPrice=true;
			 return listOfKeys;
			 
			 
		 } 
		 else 
			 return listOfKeys;
			
	}
	
	public String buyRequestedItem(int itemId, int quantity) {
		System.out.println("Inside method buyRequestedItem itemId : "+itemId+" quantity : "+quantity);
		for(Map.Entry<Item, Integer>temp:mapItems.entrySet()) {
			Item item=temp.getKey();
			int id=item.getItemId();
			if(itemId==id) {
				return buyAndUpdateItems(item,quantity);
			}
			}
		return "Yours requested item is not valid";
		
}
	
	public String buyAndUpdateItems(Item item,int quantity) {
		System.out.println("Start of method buyAndUpdateItems and quantity value "+quantity);
		if(mapItems.get(item)!=0 && mapItems.get(item)>=quantity) {
			mapItems.put(item, mapItems.get(item)-quantity);
			return "You Order has been placed succesfully";
		}
		
		else
			return "Sorry this item is out of stock";
	}
	
	
	
	
}
