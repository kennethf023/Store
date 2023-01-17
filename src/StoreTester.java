import org.testng.annotations.Test;
import java.util.ArrayList;


import static org.testng.AssertJUnit.assertTrue;

public class StoreTester {
    @Test
    public void addBookTest() {
        Store store=new Store();
        Book book=new Book("Book","Book Store",10,"Geronimo Stilton the Kingdom of Fantasy #14: the Keepers of the Empire",500,"2009","Elisabetta Dami", "9781338756920", "14", "Geronimo Stilton");
        store.addBook(book);
        assertTrue(store.getItems().size()==1);
    }

    @Test
    public void addBookAndPhoneTest() {
        Store store=new Store();
        Book book=new Book("Book","Book Store",10,"Geronimo Stilton the Kingdom of Fantasy #14: the Keepers of the Empire",500,"2009","Elisabetta Dami", "9781338756920", "14", "Geronimo Stilton");
        Phone phone=new Phone("iPhone 14","Apple", 7000, "iPhone 14 6.1-inch display", 128, "14", "Apple", "IOS", "Mobile", 6);
        store.addBook(book);
        store.addPhone(phone);
        assertTrue(store.getItems().size()==2);
    }

    @Test
    public void updatePhoneLocationTest(){
        ArrayList<CISItem> phones = new ArrayList<>();
        Store store=new Store();
        Phone phone=new Phone("iPhone 14","Apple", 7000, "iPhone 14 6.1-inch display", 128, "14", "Apple", "IOS", "Mobile", 6);
        Phone phone2=new Phone("HUAWEI Mate 50 Pro", "Huawei", 3000, "HUAWEI Mate 50 Pro", 256, "50", "Huawei", "HarmonyOS", "Mobile", 7);
        store.addPhone(phone);
        store.addPhone(phone2);
        phones=store.getAllPhones();
        store.updatePhonesLocation("Room 312");
        for (CISItem phoneCheck : phones){
            assertTrue(phoneCheck.getLocation().equals("Room 312"));
        }
    }

    @Test
    public void getItemsTest(){
        Store store=new Store();
        ArrayList<CISItem>bookList;
        bookList=store.getItems("book");
        ArrayList<CISItem>phoneList;
        phoneList=store.getItems("phone");
        for(CISItem phone:phoneList)assertTrue(phone.getClass().getSimpleName().equals("phones"));
        for(CISItem book:bookList)assertTrue(book.getClass().getSimpleName().equals("book"));
    }
    @Test
    public void updateItemsTest(){
        Store store=new Store();
        Phone phone=new Phone("iPhone 14","Apple", 7000, "iPhone 14 6.1-inch display", 128, "14", "Apple", "IOS", "Mobile", 6);
        Phone phone2=new Phone("HUAWEI Mate 50 Pro", "Huawei", 3000, "HUAWEI Mate 50 Pro", 256, "50", "Huawei", "HarmonyOS", "Mobile", 7);
        Book book=new Book("Book","Book Store",10,"Geronimo Stilton the Kingdom of Fantasy #14: the Keepers of the Empire",500,"2009","Elisabetta Dami", "9781338756920", "14", "Geronimo Stilton");
        store.addBook(book);
        store.addPhone(phone);
        store.addPhone(phone2);
        store.updateItems("phone","name","iphone");
        ArrayList<CISItem> phones;
        phones=store.getAllPhones();
        for(CISItem tempPhone:phones)assertTrue(tempPhone.getName().equals("iphone"));
    }

    @Test
    public void showAllInfoTest(){
        Store store=new Store();
        Phone phone=new Phone("iPhone 14","Apple", 7000, "iPhone 14 6.1-inch display", 128, "14", "Apple", "IOS", "Mobile", 6);
        Phone phone2=new Phone("HUAWEI Mate 50 Pro", "Huawei", 3000, "HUAWEI Mate 50 Pro", 256, "50", "Huawei", "HarmonyOS", "Mobile", 7);
        Book book=new Book("Book","Book Store",10,"Geronimo Stilton the Kingdom of Fantasy #14: the Keepers of the Empire",500,"2009","Elisabetta Dami", "9781338756920", "14", "Geronimo Stilton");
        store.addBook(book);
        store.addPhone(phone);
        store.addPhone(phone2);
        store.showAllInfo();
    }
}
