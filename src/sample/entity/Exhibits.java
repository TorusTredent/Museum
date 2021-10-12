package sample.entity;

public class Exhibits {
    private int id;
    private String name;
    private String description;
    private String exhibitionId;

    public Exhibits() {
    }

    public Exhibits(String name, String description, String exhibitionId) {
        this.name = name;
        this.description = description;
        this.exhibitionId = exhibitionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExhibitionId() {
        return exhibitionId;
    }

    public void setExhibitionId(String exhibitionId) {
        this.exhibitionId = exhibitionId;
    }

    @Override
    public String toString() {
        return "Exhibits{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", exhibitionId='" + exhibitionId + '\'' +
                '}';
    }
}
