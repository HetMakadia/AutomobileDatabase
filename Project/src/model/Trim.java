package model;

import jakarta.persistence.*;
import java.util.Set;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"model_id", "trim_name"})})
@Entity(name = "trims")
public class Trim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trim_id")
    private int trimID;

    @Column(name = "trim_name", nullable = false)
    private String trimName;

    private float trimCost;

    // Many-to-Many unidirectional association between trim and feature
    @ManyToMany
    @JoinTable(
            name = "trimFeatures",
            joinColumns = @JoinColumn(name = "trim_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private Set<Feature> trimFeatures;


    // Many-to-many bidirectional association between trim and package with an association class named Available Package
    @OneToMany(mappedBy = "trim")
    private Set<AvailablePackage> trimPackages;

    // Many-to-One bidirectional association between trim and model
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    public Trim() {

    }

    public Trim(int trimID, Model model, float cost, String name) {
        this.trimID = trimID;
        this.model = model;
        this.trimCost = cost;
        this.trimName = name;
    }

    public int getTrimID() {
        return trimID;
    }

    public void setTrimName(String trimName) {
        this.trimName = trimName;
    }

    public String getTrimName() {
        return trimName;
    }

    public void setTrimCost(float trimCost) {
        this.trimCost = trimCost;
    }

    public float getTrimCost() {
        return trimCost;
    }

    public void setTrimFeatures(Set<Feature> trimFeatures) {
        this.trimFeatures = trimFeatures;
    }

    public Set<Feature> getTrimFeatures() {
        return trimFeatures;
    }

    public Set<AvailablePackage> getTrimPackages() {
        return trimPackages;
    }

    public void setTrimPackages(Set<AvailablePackage> trimPackages) {
        this.trimPackages = trimPackages;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}