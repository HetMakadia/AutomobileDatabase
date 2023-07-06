package model;

import jakarta.persistence.*;
import java.util.Set;

@Entity(name = "packages")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private int packageID;

    @Column(nullable = false)
    private String packageName;

    // Many-to-Many unidirectional association between package and feature
    @ManyToMany
    @JoinTable(
            name = "packageFeatures",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private Set<Feature> packageFeatures;

    // Many-to-many bidirectional association between trim and package with an association class named Available Package
    @OneToMany(mappedBy = "pack")
    private Set<AvailablePackage> trimPackages;


    public Package() {

    }

    public Package(int packageID, String name) {
        this.packageID = packageID;
        this.packageName = name;
    }

    public Integer getPackageID() {
        return packageID;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageFeatures(Set<Feature> packageFeatures) {
        this.packageFeatures = packageFeatures;
    }

    public Set<Feature> getPackageFeatures() {
        return packageFeatures;
    }

    public Set<AvailablePackage> getTrimPackages() {
        return trimPackages;
    }

    public void setTrimPackages(Set<AvailablePackage> trimPackages) {
        this.trimPackages = trimPackages;
    }

}
