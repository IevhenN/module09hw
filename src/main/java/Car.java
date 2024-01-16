import java.util.Objects;

public class Car {
    private final String brand;
    private final String model;
    private final String sn;

    public Car(String brand, String model, String sn) {
        this.brand = brand;
        this.model = model;
        this.sn = sn;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSn() {
        return sn;
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(sn, car.sn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, sn);
    }
}
