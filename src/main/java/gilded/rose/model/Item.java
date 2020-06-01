package gilded.rose.model;



public class Item {

private int itemId;
private String name;
private String description;
private int price;


public Item() {
	
}
public Item(int id,String name,String description, int price) {
	super();
	itemId=id;
	this.name=name;
	this.description=description;
	this.price=price;
	
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}


public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public int hashCode() {
	int hash=(int)itemId+name.hashCode()+description.hashCode()+(int)price;
	return hash;
}

public boolean equals(Object obj) {
	if(obj!=null && obj instanceof Item) {
		Item item=(Item)obj;
		if(this.getItemId()==item.getItemId()) {
			return true;
		}
		
	}
	return false;
	
}

public String toString() {
	return itemId+" "+name +" "+description+" "+price;
}


}
