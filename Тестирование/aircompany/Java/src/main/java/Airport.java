import Planes.experimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;



    public List<PassengerPlane> getPassengerPlane() {//getPasPl название мутода то что он возвращает краткость
        List<? extends Plane> listPlane = this.planes;//l
        List<PassengerPlane> passenger = new ArrayList<>();// x точное название переменной
        for (Plane plane : listPlane) {if (plane instanceof PassengerPlane) {passenger.add((PassengerPlane) plane);}}
        return passenger;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }

        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }

        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    for (int i = 0; i < militaryPlanes.size(); i++) {

    if (militaryPlanes.get(i).getType() == MilitaryType.TRANSPORT) {
    transportMilitaryPlanes.add(militaryPlanes.get(i));
    }
    }
    return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {

            if (militaryPlanes.get(i).getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlanes.get(i));
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, Comparator.comparingInt(Plane::GetMaxFlightDistance));
        return this;
    }


    /**
     * Sorts by max speed
     * @return Airport
     */
    public Airport sortByMaxSpeed() {
        Collections.sort(planes, Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, Comparator.comparingInt(Plane::getMinLoadCapacity));
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void printPlaneCollection(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            //Plane plane = iterator.next();
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
