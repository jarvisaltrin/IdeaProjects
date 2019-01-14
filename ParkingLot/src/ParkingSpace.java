public class ParkingSpace implements Space {

    private VehicleSize vehicleSize;
    private VehicleType type;
    private boolean isTaken;

    // Constructor
    public ParkingSpace(VehicleSize vehicleSize, VehicleType type){
        this.vehicleSize = vehicleSize;
        this.type = type;
    }

    @Override
    public VehicleSize getSize() {
        return this.vehicleSize;
    }

    @Override
    public VehicleType getType() {
        return this.type;
    }

    public boolean getIsTaken(){
        return this.isTaken;
    }

    @Override
    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }
}
