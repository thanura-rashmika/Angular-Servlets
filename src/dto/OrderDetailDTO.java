package dto;

public class OrderDetailDTO {
    private int odid;
    private int oid;
    private double unit_price;
    private double qty;

    public int getOdid() {
        return odid;
    }

    public void setOdid(int odid) {
        this.odid = odid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
}
