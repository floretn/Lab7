package dop;

import java.util.Objects;

public class Tower implements Comparable<Tower>{

    private final double x;
    private final double radius;
    private final String name;

    public Tower(double x, double radius, String name) {
        this.x = x;
        this.radius = radius;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public double getRadius() {
        return radius;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tower tower = (Tower) o;
        return Double.compare(tower.x, x) == 0 && Double.compare(tower.radius, radius) == 0 && Objects.equals(name, tower.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, radius, name);
    }

    @Override
    public String toString() {
        return "Tower{" +
                "x=" + x +
                ", radius=" + radius +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Tower o) {
        return (int) (this.x - o.x);
    }
}
