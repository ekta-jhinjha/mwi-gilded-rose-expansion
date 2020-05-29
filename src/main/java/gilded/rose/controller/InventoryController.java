package gilded.rose.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gilded.rose.model.Item;
import gilded.rose.service.InventoryService;

@RestController
public class InventoryController {

	static int  counter=0;
	static LocalDateTime dtime;
	
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping("/items")
	public List<Item> getAllItems() {
		counter++;
		boolean priceUpdate=false;
		if(null==dtime) {
			 dtime= LocalDateTime.now();
		}
		if(counter>10) {
			LocalDateTime now=LocalDateTime.now();
			long hours = Duration.between(dtime, now).toHours();
			if (hours <=1 ) {
				priceUpdate=true;
				counter=0;
				dtime=now;
				
			} 
		}
		
		
		return inventoryService.getAllItemsFromInventory(priceUpdate);
	}
	
	
	
	
	
	@RequestMapping("/buyItem")
	public String buyItem(@RequestBody Item item) {
		
		String itemName=item.getName();
		String description=item.getDescription();
		int price=item.getPrice();
		return inventoryService.buyRequestedItem(itemName,description,price);
	}
	
	
}
