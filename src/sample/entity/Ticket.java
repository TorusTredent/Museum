package sample.entity;

public class Ticket {
    private long id;
    private String numberTicket;
    private String exhibitionDate;
    private String exhibitionName;
    private int exhibitionId;
    private int exhibitionPrice;
    private int user_id;

    public Ticket() {
    }

    public Ticket(String numberTicket, String exhibitionDate, int exhibitionId, int exhibitionPrice, int user_id) {
        this.numberTicket = numberTicket;
        this.exhibitionDate = exhibitionDate;
        this.exhibitionId = exhibitionId;
        this.exhibitionPrice = exhibitionPrice;
        this.user_id = user_id;
    }

    public Ticket(String numberTicket, String exhibitionDate, String exhibitionName) {
        this.numberTicket = numberTicket;
        this.exhibitionDate = exhibitionDate;
        this.exhibitionName = exhibitionName;
    }

    public Ticket(String numberTicket, String exhibitionDate, String exhibitionName, int exhibitionPrice, int user_id) {
        this.numberTicket = numberTicket;
        this.exhibitionDate = exhibitionDate;
        this.exhibitionName = exhibitionName;
        this.exhibitionPrice = exhibitionPrice;
        this.user_id = user_id;
    }


    public int getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(int exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    public String getExhibitionDate() {
        return exhibitionDate;
    }

    public void setExhibitionDate(String exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setExhibitionName(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }

    public int getExhibitionPrice() {
        return exhibitionPrice;
    }

    public void setExhibitionPrice(int exhibitionPrice) {
        this.exhibitionPrice = exhibitionPrice;
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


    public String getName() {
        return exhibitionName;
    }

    public void setName(String name) {
        this.exhibitionName = name;
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
                ", date='" + exhibitionDate + '\'' +
                ", name='" + exhibitionName + '\'' +
                ", price=" + exhibitionPrice +
                ", user_id=" + user_id +
                '}';
    }
}
