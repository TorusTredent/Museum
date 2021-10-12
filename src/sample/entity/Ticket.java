package sample.entity;

public class Ticket {
    private long id;
    private String numberTicket;
    private String exhibition_date;
    private String exhibition_name;
    private int exhibition_price;
    private int user_id;

    public Ticket() {
    }

    public Ticket(String numberTicket, String exhibition_date, String exhibition_name) {
        this.numberTicket = numberTicket;
        this.exhibition_date = exhibition_date;
        this.exhibition_name = exhibition_name;
    }

    public Ticket(String numberTicket, String exhibition_date, String exhibition_name, int exhibition_price, int user_id) {
        this.numberTicket = numberTicket;
        this.exhibition_date = exhibition_date;
        this.exhibition_name = exhibition_name;
        this.exhibition_price = exhibition_price;
        this.user_id = user_id;
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

    public String getDate() {
        return exhibition_date;
    }

    public void setDate(String date) {
        this.exhibition_date = date;
    }

    public String getName() {
        return exhibition_name;
    }

    public void setName(String name) {
        this.exhibition_name = name;
    }

    public int getPrice() {
        return exhibition_price;
    }

    public void setPrice(int price) {
        this.exhibition_price = price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", numberTicket=" + numberTicket +
                ", date='" + exhibition_date + '\'' +
                ", name='" + exhibition_name + '\'' +
                ", price=" + exhibition_price +
                ", user_id=" + user_id +
                '}';
    }
}
