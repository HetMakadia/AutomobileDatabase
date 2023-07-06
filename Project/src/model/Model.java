package model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "modelYear"})})
@Entity(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private int modelID;

    @Column(nullable = false)
    private String modelName;

    @Column(length = 4)
    private int modelYear;

    // Many-to-Many unidirectional association between model and feature
    @ManyToMany
    @JoinTable(
            name = "modelFeatures",
            joinColumns = @JoinColumn(name = "model_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private Set<Feature> modelFeatures;

    // One-to-Many bidirectional association between trim and model
    @OneToMany(mappedBy = "model")
    private List<Trim> trims;


    public Model(){

    }

    public Model(int modelID, String name, int year){
        this.modelID = modelID;
        this.modelName = name;
        this.modelYear = year;
    }

    public int getModelID() {
        return modelID;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelFeatures(Set<Feature> modelFeatures) {
        this.modelFeatures = modelFeatures;
    }

    public Set<Feature> getModelFeatures() {
        return modelFeatures;
    }

    public void setTrims(List<Trim> trims) {
        this.trims = trims;
    }

    public List<Trim> getTrims() {
        return trims;
    }
}