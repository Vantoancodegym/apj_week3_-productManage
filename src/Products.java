public class Products {
    private String name;
    private int productId;
    private int price;
    public Products(){};
    public Products(String name, int productId, int price) {
        this.name = name;
        this.productId = productId;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return productId;
    }
}
