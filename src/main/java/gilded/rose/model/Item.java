package gilded.rose.model;



public class Item {
private String name;
private String description;
private int price;


public Item() {
	
}
public Item(String name,String description, int price) {
	super();
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

public int hashCode() {
	int hash=name.hashCode()+description.hashCode()+(int)price;
	return hash;
}

public boolean equals(Object obj) {
	if(obj!=null && obj instanceof Item) {
		Item item=(Item)obj;
		if(this.getName().equals(item.getName())) {
			return true;
		}
		
	}
	return false;
	
}

public String toString() {
	return name +" "+description+" "+price;
}


}
