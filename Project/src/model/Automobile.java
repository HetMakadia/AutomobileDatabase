package model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Entity(name = "automobiles")
public class Automobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "automobile_id")
    private int automobileID;

    @Column(length = 17, unique = true, nullable = false)
    private String VIN;


    // Many-to-One unidirectional association between automobile and trim
    @ManyToOne
    @JoinColumn(name = "trim_id")
    private Trim trim;

    // Many-to-Many bidirectional association between Available Package and Automobile
    @ManyToMany
    @JoinTable(
            name = "chosenPackages",
            joinColumns = @JoinColumn(name = "automobile_id"),
            inverseJoinColumns = @JoinColumn(name = "available_id")
    )
    private Set<AvailablePackage> chosenPackages;

    public Automobile(){

    }

    public Automobile(int automobileID, Trim trim, String VIN){
        this.automobileID = automobileID;
        this.trim = trim;
        this.VIN = VIN;
    }

    public int getAutomobileID() {
        return automobileID;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getVIN() {
        return VIN;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setChosenPackages(Set<AvailablePackage> chosenPackages) {
        this.chosenPackages = chosenPackages;
    }

    public Set<AvailablePackage> getChosenPackages() {
        return chosenPackages;
    }

    public Set<Feature> getFeatures() {
        Set<Feature> allFeatures = new HashSet<>();

        allFeatures.addAll(getTrim().getTrimFeatures());
        allFeatures.addAll(getTrim().getModel().getModelFeatures());
        Iterator<AvailablePackage> itr = getChosenPackages().iterator();
        while(itr.hasNext()){
            allFeatures.addAll(itr.next().getPackage().getPackageFeatures());
        }
        return allFeatures;
    }

    public double stickerPrice() {
        float stickerPrice = 0;

        stickerPrice += getTrim().getTrimCost();

        Iterator<AvailablePackage> itr = getChosenPackages().iterator();
        while(itr.hasNext()){
            stickerPrice += itr.next().getCost();
        }

        return stickerPrice;
    }
}
