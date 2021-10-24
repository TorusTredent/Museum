package sample.entity;

public class TableClassPersonalArea {
    private int id;
    private String numberTicket;
    private String data;
    private String exhibitionName;

    public TableClassPersonalArea(String numberTicket, String data, String exhibitionName) {
        this.numberTicket = numberTicket;
        this.data = data;
        this.exhibitionName = exhibitionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setExhibitionName(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }
}
