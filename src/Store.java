import java.lang.reflect.Array;
import java.util.ArrayList;

public class Store {
    ArrayList<CISItem> items = new ArrayList<CISItem>();
    ArrayList<CISItem> phones = new ArrayList<>();

    public ArrayList<CISItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CISItem> items) {
        this.items = items;
    }

    public void addBook(Book book) {
        items.add(book);
    }

    public void addPhone(Phone phone) {
        items.add(phone);
    }

    public ArrayList<CISItem> getAllPhones() {
        for(CISItem phone:items)if(phone.getClass().getSimpleName().equals("phone"))phones.add(phone);
        return phones;
    }

    public void updatePhonesLocation(String location) {
        for(CISItem phone:items)if(phone.getClass().getSimpleName().equals("phone"))phone.setLocation(location);
    }

    public ArrayList<CISItem> getItems(String itemType) {
        ArrayList<CISItem>items=new ArrayList<>();
        for(CISItem item:items)if(item.getClass().getSimpleName().equals(itemType))items.add(item);
        return items;
    }

    public void updateItems(String itemType, String prop, String value) {
        ArrayList<CISItem>items=new ArrayList<>();
        for (CISItem item:items)if(item.getClass().getSimpleName().equals(itemType))items.add(item);
        for (CISItem item:items) {
            if(prop.equals("name")) item.setName(value);
            else if(prop.equals("location"))item.setLocation(value);
            else if(prop.equals("description"))item.setDesc(value);
            else if(prop.equals("price"))item.setPrice(Integer.parseInt(value));
        }
    }
    public void showAllInfo() {
        for (CISItem item:items){
            System.out.println(item);
        }
    }
}
