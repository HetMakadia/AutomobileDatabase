package model;

import jakarta.persistence.*;

@Entity(name = "features")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feature_id")
    private int featureID;

    @Column(unique = true, nullable = false)
    private String featureName;

    public Feature() {
    }

    public Feature(int featureID, String name){
        this.featureID = featureID;
        this.featureName = name;
    }

    public int getFeatureID() {
        return featureID;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureName() {
        return featureName;
    }
}