public class Order  {
    private Integer order_id,order_price;
    private String order_name;
//    public Order(int staff_id, String first_name, String last_name, int age, String address) {
//        super(staff_id, first_name, last_name, age, address);
//    }
//      Order(int order_id, String order_name, String first_name, String last_name, int staff_id, int order_price);

    public Order() {
    }

    public Order(Integer order_id, Integer order_price, String order_name) {
        this.order_id = order_id;
        this.order_price = order_price;
        this.order_name = order_name;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public void setOrder_price(Integer order_price) {
        this.order_price = order_price;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }
}
