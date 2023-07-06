package model;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "availablepackages")
public class AvailablePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_id")
    private int availableID;

    @JoinColumn(name = "trim_id")
    @ManyToOne
    private Trim trim;

    @JoinColumn(name = "package_id")
    @ManyToOne
    private Package pack;

    @Column(name = "available_package_cost", nullable = false)
    private float availablePackageCost;

    // Many-to-Many bidirectional association between Available Package and Automobile
    @ManyToMany(mappedBy = "chosenPackages")
    private Set<Automobile> compatibleAutomobile;

    public AvailablePackage() {

    }

    public AvailablePackage(int availableID, Trim trim, Package pack, float cost) {
        this.availableID = availableID;
        this.trim = trim;
        this.pack = pack;
        this.availablePackageCost = cost;
    }

    public int getAvailableID() {
        return availableID;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setPackage(Package pack) {
        this.pack = pack;
    }

    public Package getPackage() {
        return pack;
    }

    public void setCost(float cost) {
        this.availablePackageCost = cost;
    }

    public float getCost() {
        return availablePackageCost;
    }

    public void setCompatibleAutomobile(Set<Automobile> compatibleAutomobile) {
        this.compatibleAutomobile = compatibleAutomobile;
    }

    public Set<Automobile> getCompatibleAutomobile() {
        return compatibleAutomobile;
    }
}