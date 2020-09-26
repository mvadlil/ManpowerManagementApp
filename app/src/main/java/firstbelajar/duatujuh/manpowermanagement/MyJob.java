package firstbelajar.duatujuh.manpowermanagement;

public class MyJob {

    String nama_tour, tour_location;

    public MyJob() {
    }

    public MyJob(String nama_tour, String tour_location) {
        this.nama_tour = nama_tour;
        this.tour_location = tour_location;
    }

    public String getNama_tour() {
        return nama_tour;
    }

    public void setNama_tour(String nama_tour) {
        this.nama_tour = nama_tour;
    }

    public String getTour_location() {
        return tour_location;
    }

    public void setTour_location(String tour_location) {
        this.tour_location = tour_location;
    }
}
