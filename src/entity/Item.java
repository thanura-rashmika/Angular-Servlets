package entity;

public class Item {
    private int iid;
    private String description;
    private double unit_price;
    private double qty_on_hand;

    public Item() {

    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getQty_on_hand() {
        return qty_on_hand;
    }

    public void setQty_on_hand(double qty_on_hand) {
        this.qty_on_hand = qty_on_hand;
    }
}
