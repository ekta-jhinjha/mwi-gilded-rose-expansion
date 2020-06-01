package gilded.rose.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gilded.rose.model.Item;
import gilded.rose.service.InventoryService;

@RestController
public class InventoryController {
	
	static List<LocalDateTime>requestTimeLists=new ArrayList<LocalDateTime>();
	
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping("/v1/items")
	public List<Item> getAllItems() {
		System.out.println("Inside start of  method getAllItems ");
		boolean priceUpdate=false;
		LocalDateTime currentTime=LocalDateTime.now();
		requestTimeLists.add(currentTime);
		for(int i=requestTimeLists.size()-1;i>=0;i--) {
				for(int j=i-1;j>=0;j--) {
					if(Duration.between(requestTimeLists.get(i), requestTimeLists.get(j)).toHours()<=1 &&(i-j==10)) {
						System.out.println("if time difference is less than or equal to 1 hour and views is more than 10");
						priceUpdate=true;
						break;
					}
					
				}
				if(priceUpdate) {
					break;
				}
			}
		
		return inventoryService.getAllItemsFromInventory(priceUpdate);
	}
	
	
	
	
	
	@RequestMapping("/v1/buyItem/{itemId}/{quantity}")
	public String buyItem(@PathVariable int itemId,@PathVariable int quantity) {
		System.out.println("Inside method buyItem itemId "+itemId+" requested quantity "+quantity);
		return inventoryService.buyRequestedItem(itemId,quantity);
	}
	
	
	
	
	
}
