class Vehicle {
    private int numberOfWheels;
    private String color;
    public Vehicle(String color) {
        // setting the color attribute to the value from the color parameter
        this.color = color;
    }
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    public void setNumberOfWheels(int number) {
        numberOfWheels = number;
    }    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;        // 1
    }
    
    
    // ...
    // getters and setters removed for brevity
    // ...
}
