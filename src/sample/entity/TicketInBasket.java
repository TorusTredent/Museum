package sample.entity;

public class TicketInBasket {
    private long id;
    private String numberTicket;
    private String data;
    private int exhibitionId;
    private int amountTicket;
    private int cost;
    private int userId;



    public TicketInBasket(String numberTicket, String data, int amountTicket, int cost) {
        this.numberTicket = numberTicket;
        this.data = data;
        this.amountTicket = amountTicket;
        this.cost = cost;
    }



    public TicketInBasket(String numberTicket, String data, int exhibitionId, int amountTicket, int cost, int userId) {
        this.numberTicket = numberTicket;
        this.data = data;
        this.exhibitionId = exhibitionId;
        this.amountTicket = amountTicket;
        this.cost = cost;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(String numberTicket) {
        this.numberTicket = numberTicket;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public int getAmountTicket() {
        return amountTicket;
    }

    public void setAmountTicket(int amountTicket) {
        this.amountTicket = amountTicket;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TicketInBasket{" +
                "id=" + id +
                ", numberTicket='" + numberTicket + '\'' +
                ", data='" + data + '\'' +
                ", exhibitionName='" + exhibitionId + '\'' +
                ", amountTicket=" + amountTicket +
                ", cost=" + cost +
                ", user_id=" + userId +
                '}';
    }
}
