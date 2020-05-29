package gilded.rose.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import gilded.rose.model.Item;

@Service
public class InventoryService {
	private static Map<Item,Integer>mapItems;
	  
	 static{ 
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
			 List<Item>updatedPriceofKeys=listOfKeys.stream().map(f->new Item(f.getName(),f.getDescription(),f.getPrice()+10*f.getPrice()/100)).collect(Collectors.toList());
			 mapItems = mapItems.entrySet().stream()
						.filter(x -> x.getKey()==new Item(x.getKey().getName(),x.getKey().getDescription(),x.getKey().getPrice()+10*x.getKey().getPrice()/100))
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
			 return updatedPriceofKeys;
			 
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
