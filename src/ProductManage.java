import java.util.ArrayList;
import java.util.Arrays;

public class ProductManage {
    private ArrayList<Products> productsList=new ArrayList<>();
    public void addNewProduct(Products product){
        productsList.add(product);
    }
    public int checkIndexInList(int searchingId) {
        for (int i = 0; i < productsList.size(); i++) {
            Products product = productsList.get(i);
            if (product.getId() == searchingId) {
                return i;
            }
        }
        return -1;
    }
    public void editProductById(int index,String name, int price){
        if (index!=-1){
            Products product=productsList.get(index);
            product.setName(name);
            product.setPrice(price);
        }
    }
    public void removeProductById(int searchingId){
        int index=checkIndexInList(searchingId);
        if (index!=-1){
            productsList.remove(index);
        }
    }
    public void displayAll(){
        System.out.println(productsList);
    }
    public void searchingByProductName(String searchingName){
        boolean flag=false;
        for (Products product:productsList) {
            String productName=product.getName();
            if (productName==searchingName){
                System.out.println(product);
                flag=true;
            }
        }
        if (!flag) System.out.println("product 's name is invalid");
        }
    public void increaseSort(){
        for (int i = 0; i < productsList.size(); i++) {
            Products productHasMinPrice=productsList.get(i);
            int minPrice=productHasMinPrice.getPrice();
            int indexOfMinPrice=i;
            for (int j = i; j <productsList.size() ; j++) {
                Products product=productsList.get(j);
                if (product.getPrice()<minPrice){
                    minPrice=product.getPrice();
                    productHasMinPrice=product;
                    indexOfMinPrice=j;
                }
            }
            Products tempt=productsList.get(i);
            productsList.set(i,productHasMinPrice);
            productsList.set(indexOfMinPrice,tempt);
        }
    }
    public void decreaseSort() {
        if (productsList.size() >= 2) {
            for (int i = 1; i < productsList.size(); i++) {
                Products currentProduct=productsList.get(i);
                int currentPrice=currentProduct.getPrice();
                int j;
                for (j=i-1; j>=0&&productsList.get(j).getPrice()<currentPrice; j--) {
                    Products temp=productsList.get(j);
                    productsList.set(j,productsList.get(j+1));
                    productsList.set(j+1,temp);
                }
                productsList.set(i,currentProduct);
            }
        }
    }

}
