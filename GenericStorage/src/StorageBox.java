public class StorageBox <T>{
	T item;
	
	public StorageBox(T inputitem) {
		item = inputitem;
	}
	
	public void setItem(T inputitem) {
		item = inputitem;
	}

	public T getItem() {
		return this.item;
	}
	
	public boolean isEmpty() {
		if(item == null) {
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		if(this.isEmpty()) {
			return("Box is empty");
		}
		
		else {
			return(item.toString());
		}
	}
	
}
