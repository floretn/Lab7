package task10;

public class Neighbor {
    String city;
    int distance;

    public Neighbor(String city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Neighbor{" +
                "city='" + city + '\'' +
                ", distance=" + distance +
                '}';
    }
}
