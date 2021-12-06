package sample.entity;

public class TableClassBasket {
    private String numberTicket;
    private String exhibitionName;
    private String data;
    private int cost;

    public TableClassBasket(String numberTicket, String exhibitionName, String data, int cost) {
        this.numberTicket = numberTicket;
        this.exhibitionName = exhibitionName;
        this.data = data;
        this.cost = cost;
    }

    public String getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(String numberTicket) {
        this.numberTicket = numberTicket;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setExhibitionName(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
