package entities;

public class ClothInfo {
    private String ID;
    private String kinds;
    private String lining;
    private String Season;
    private String Size;
    private String Images;
    private String Stars;

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public String getStars() {
        return Stars;
    }

    public void setStars(String stars) {
        Stars = stars;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public String getLining() {
        return lining;
    }

    public void setLining(String lining) {
        this.lining = lining;
    }

    public String getSeason() {
        return Season;
    }

    public void setSeason(String season) {
        Season = season;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }
}
