import java.util.Scanner;

public class Main {
    public static ProductManage productManage=new ProductManage();
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add new product");
            System.out.println("2. Edit Product by Id");
            System.out.println("3. Remove Product by Id");
            System.out.println("4. Searching produtc by name");
            System.out.println("5. Display All");
            System.out.println("6. Increase sort");
            System.out.println("7. Decrease sort");
            System.out.println("0. Exit");
            choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    editProductById();
                    break;
                case 3:
                    removeProductById();
                    break;
                case 4:
                    searchingProductByName();
                    break;
                case 5:
                    productManage.displayAll();
                    break;
                case 6:
                    productManage.increaseSort();
                    break;
                case 7:
                    productManage.decreaseSort();
                    break;
                case 0:
                    System.exit(0);
            }

        }while (choice!=0);
    }
    public static void addNewProduct(){
        System.out.println("Enter product name");
        String name= scanner.nextLine();
        System.out.println("Enter product price");
        int price=Integer.parseInt(scanner.nextLine());
        System.out.println("Enter product Id");
        int productId=Integer.parseInt(scanner.nextLine());
        Products product=new Products(name,productId,price);
        productManage.addNewProduct(product);
    }
    public static void editProductById(){
        System.out.println("Enter searching Id");
        int searchingId=Integer.parseInt(scanner.nextLine());
        int index=productManage.checkIndexInList(searchingId);
        if (index==-1) System.out.println("Id is invalid");
        else {
            System.out.println("Enter new name");
            String newName=scanner.nextLine();
            System.out.println("Enter new price");
            int newPrice=Integer.parseInt(scanner.nextLine());
            productManage.editProductById(index,newName,newPrice);
        }
    }
    public static void removeProductById(){
        System.out.println("Enter searching Id");
        int searchingId=Integer.parseInt(scanner.nextLine());
        productManage.removeProductById(searchingId);
    }
    public static void searchingProductByName(){
        System.out.println("Enter searchingName");
        String searchingName=scanner.nextLine();
        productManage.searchingByProductName(searchingName);
    }
}
