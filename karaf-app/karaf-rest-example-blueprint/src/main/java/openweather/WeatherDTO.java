package openweather;

public class WeatherDTO {
    private String name;

    public WeatherDTO() {
    }

    public WeatherDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
