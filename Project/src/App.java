import java.util.*;

import jakarta.persistence.*;

import model.*;
import model.Package;

public class App {
    private static void addFeatures() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3");
        EntityManager em = factory.createEntityManager();

        String[] features = {"leather seats", "plug-in hybrid engine", "power sliding doors", "hands-free sliding doors", "Amazon FireTV", "rear-seat entertainment screens", "all-wheel drive", "adaptive cruise control" };
        em.getTransaction().begin();
        for (int i = 0; i < features.length; i++) {
            Feature feature = new Feature(i, features[i]);
            em.persist(feature);
        }
        em.getTransaction().commit();

    }

    private static void addPackages() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3");
        EntityManager em = factory.createEntityManager();

        String[] packages = {"Theater Package", "Amazon Theater Package", "Safety Package" };
        em.getTransaction().begin();

        // Inserting 1st package with features
        model.Package pack = new model.Package(1, packages[0]);
        Set<Feature> features = new HashSet<>();
        String jpaQuery = "SELECT f FROM features f WHERE f.featureName = "+ "'rear-seat entertainment screens'";
        Feature feature = em.createQuery(jpaQuery, Feature.class).getSingleResult();
        features.add(feature);
        pack.setPackageFeatures(features);
        em.persist(pack);

        // Inserting 2nd package with features
        pack = new model.Package(2, packages[1]);
        features = new HashSet<>();
        jpaQuery = "SELECT f FROM features f WHERE f.featureName = " + "'rear-seat entertainment screens'";
        feature = em.createQuery(jpaQuery, Feature.class).getSingleResult();
        features.add(feature);
        jpaQuery = "SELECT f FROM features f WHERE f.featureName = " + "'Amazon FireTV'";
        feature = em.createQuery(jpaQuery, Feature.class).getSingleResult();
        features.add(feature);
        pack.setPackageFeatures(features);
        em.persist(pack);

        // Inserting 3rd package with features
        pack = new model.Package(3, packages[2]);
        features = new HashSet<>();
        jpaQuery = "SELECT f FROM features f WHERE f.featureName = " + "'adaptive cruise control'";
        feature = em.createQuery(jpaQuery, Feature.class).getSingleResult();
        features.add(feature);
        pack.setPackageFeatures(features);
        em.persist(pack);

        em.getTransaction().commit();
    }

    public static void createModel1(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model model = new Model(1, "Pacifica", 2022);
        Set<Feature> features = new HashSet<>();
        String jpaQuery = "SELECT f FROM features f WHERE f.featureName = " + "'power sliding doors'";
        Feature feature = em.createQuery(jpaQuery, Feature.class).getSingleResult();
        features.add(feature);
        model.setModelFeatures(features);

        List<Trim> modelTrims = new ArrayList<>();

        String [] trimFeatures = {};
        String [] trimPackages = {"Safety Package"};
        int [] costs = {3000};
        Trim trim = createTrims(em, 1, model, 30000, "Touring", trimFeatures, trimPackages, costs);
        em.persist(trim);
        modelTrims.add(trim);
        em.persist(model);

        trimFeatures = new String[]{"leather seats", "hands-free sliding doors" };
        trimPackages = new String[]{"Amazon Theater Package"};
        costs = new int[]{2500};
        trim = createTrims(em, 2, model, 34000, "Limited", trimFeatures, trimPackages, costs);
        em.persist(trim);
        modelTrims.add(trim);
        em.persist(model);



        trimFeatures = new String[]{"leather seats", "hands-free sliding doors", "rear-seat entertainment screens", "Amazon FireTV", "all-wheel drive"};
        trimPackages = new String[]{};
        costs = new int[]{};
        trim = createTrims(em, 3, model, 42000, "Pinnacle", trimFeatures, trimPackages, costs);
        em.persist(trim);
        model.setTrims(modelTrims);
        em.persist(model);


        em.getTransaction().commit();
    }

    public static void createModel2(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model model = new Model(2, "Pacifica Hybrid", 2022);

        Set<Feature> features = new HashSet<>();
        String jpaQuery = "SELECT f FROM features f WHERE f.featureName = " + "'power sliding doors'";
        Feature feature = em.createQuery(jpaQuery, Feature.class).getSingleResult();
        features.add(feature);

        jpaQuery = "SELECT f FROM features f WHERE f.featureName = " + "'plug-in hybrid engine'";
        feature = em.createQuery(jpaQuery, Feature.class).getSingleResult();
        features.add(feature);
        model.setModelFeatures(features);

        List<Trim> modelTrims = new ArrayList<>();

        String [] trimFeatures = {};
        String [] trimPackages = {};
        int [] costs = {};
        Trim trim = createTrims(em, 4, model, 43000, "Touring", trimFeatures, trimPackages, costs);
        em.persist(trim);
        modelTrims.add(trim);
        em.persist(model);

        trimFeatures = new String[]{"leather seats", "hands-free sliding doors" };
        trimPackages = new String[]{"Amazon Theater Package"};
        costs = new int[]{2500};
        trim = createTrims(em, 5, model, 48000, "Limited", trimFeatures, trimPackages, costs);
        em.persist(trim);
        modelTrims.add(trim);
        em.persist(model);



        trimFeatures = new String[]{"leather seats", "hands-free sliding doors", "rear-seat entertainment screens", "Amazon FireTV"};
        trimPackages = new String[]{};
        costs = new int[]{};
        trim = createTrims(em, 6, model, 54000, "Pinnacle", trimFeatures, trimPackages, costs);
        em.persist(trim);
        model.setTrims(modelTrims);
        em.persist(model);


        em.getTransaction().commit();
    }

    public static void createModel3(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model model = new Model(1, "Pacifica Hybrid", 2021);

        Set<Feature> features = new HashSet<>();
        String jpaQuery = "SELECT f FROM features f WHERE f.featureName = " + "'power sliding doors'";
        Feature feature = em.createQuery(jpaQuery, Feature.class).getSingleResult();
        features.add(feature);

        jpaQuery = "SELECT f FROM features f WHERE f.featureName = " + "'plug-in hybrid engine'";
        feature = em.createQuery(jpaQuery, Feature.class).getSingleResult();
        features.add(feature);
        model.setModelFeatures(features);

        List<Trim> modelTrims = new ArrayList<>();

        String [] trimFeatures = {};
        String [] trimPackages = {"Safety Package"};
        int [] costs = {3000};
        Trim trim = createTrims(em, 7, model, 41000, "Touring", trimFeatures, trimPackages, costs);
        em.persist(trim);
        modelTrims.add(trim);
        em.persist(model);

        trimFeatures = new String[]{"leather seats", "hands-free sliding doors" };
        trimPackages = new String[]{"Theater Package", "Safety Package"};
        costs = new int[]{2500, 2000};
        trim = createTrims(em, 8, model, 46000, "Limited", trimFeatures, trimPackages, costs);
        em.persist(trim);
        modelTrims.add(trim);
        em.persist(model);



        trimFeatures = new String[]{"leather seats", "hands-free sliding doors", "rear-seat entertainment screens", "adaptive cruise control"};
        trimPackages = new String[]{};
        costs = new int[]{};
        trim = createTrims(em, 9, model, 52000, "Pinnacle", trimFeatures, trimPackages, costs);
        em.persist(trim);
        model.setTrims(modelTrims);
        em.persist(model);


        em.getTransaction().commit();
    }

    public static Trim createTrims(EntityManager em, int ID, Model model, int cost, String name, String [] features, String [] packages, int [] costs) {


        Trim trim = new Trim(ID, model, cost, name);

        Set<Feature> trimFeatures = new HashSet<>();
        for (int i=0; i< features.length; i++){
            String jpaQuery = "SELECT f FROM features f WHERE f.featureName = '" + features[i] +"'";
            Feature feature = em.createQuery(jpaQuery, Feature.class).getSingleResult();
            trimFeatures.add(feature);
        }
        trim.setTrimFeatures(trimFeatures);

        Set<AvailablePackage> availablePackages = new HashSet<>();
        for (int i=0; i< packages.length; i++){
            String jpaQuery = "SELECT p FROM packages p WHERE p.packageName = '" + packages[i] +"'";
            model.Package pack = em.createQuery(jpaQuery, model.Package.class).getSingleResult();
            AvailablePackage apack = new AvailablePackage(i, trim, pack, costs[i]);
            em.persist(apack);
            availablePackages.add(apack);
            em.persist(trim);
        }
        trim.setTrimPackages(availablePackages);


        return trim;



    }

    public static void createAutomobiles(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        String [] addedPacks = {"Amazon Theater Package"};
        Automobile auto = generateAutomobile(em, 1, 2, "12345abcde", addedPacks);
        em.persist(auto);

        addedPacks = new String[]{};
        auto = generateAutomobile(em, 2, 6, "67890abcde", addedPacks);
        em.persist(auto);

        addedPacks = new String[]{};
        auto = generateAutomobile(em, 3, 9, "99999aaaaa", addedPacks);
        em.persist(auto);

        addedPacks = new String[]{"Safety Package"};
        auto = generateAutomobile(em, 4, 7, "aaaaa88888", addedPacks);
        em.persist(auto);

        addedPacks = new String[]{"Safety Package", "Theater Package"};
        auto = generateAutomobile(em, 5, 8, "bbbbb77777", addedPacks);
        em.persist(auto);





        em.getTransaction().commit();

    }

    public static Automobile generateAutomobile(EntityManager em, int id, int trimID, String vin, String [] packages){


        Trim trim = em.find(Trim.class, trimID);
        Automobile auto = new Automobile(1, trim, vin);
        Set<AvailablePackage> cPackSet = new HashSet<>();

        for (int i=0; i<packages.length; i++){
            String jpaQuery = "SELECT a FROM availablepackages a WHERE a.trim.trimID = " + trimID + " and a.pack.packageName = '" + packages[i] + "'";
            AvailablePackage chosenPack = em.createQuery(jpaQuery, AvailablePackage.class).getSingleResult();
            cPackSet.add(chosenPack);
        }

        auto.setChosenPackages(cPackSet);

        return auto;

    }

    public static int menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Automobile Database\n");
        System.out.println("Options: \n1. Instantiate model \n2. Automobile lookup \n3. Feature search \n4. Quit");
        int option = scan.nextInt();
        return option;
    }

    public static void scanAutomobile(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3");
        EntityManager em = factory.createEntityManager();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter VIN : ");
        String userInput = scan.next();

        var automobile = em.createQuery("SELECT a from automobiles a where a.VIN = ?1", Automobile.class);
        automobile.setParameter(1, userInput);
        try {
            Automobile requested = automobile.getSingleResult();
            System.out.println(requested.getTrim().getModel().getModelYear() + " " + requested.getTrim().getModel().getModelName() + " " + requested.getTrim().getTrimName());
            System.out.println(requested.stickerPrice());
            System.out.println("Features: ");
            Set<Feature> set = requested.getFeatures();
            TreeSet<String> featureNames = new TreeSet<>();
            for (Feature s : set){
                featureNames.add(s.getFeatureName());
            }
            for (String s : featureNames){
                System.out.println(s);
            }

            System.out.println("\n\n");
        } catch (NoResultException ex){
            System.out.println("There is no automobile with the VIN that you provided.");
        }
    }

    public static void featureDetails(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3");
        EntityManager em = factory.createEntityManager();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter feature name : ");
        String userInput = scan.nextLine();

        var feature = em.createQuery("SELECT f from features f where f.featureName = ?1", Feature.class);
        feature.setParameter(1, userInput);

        TypedQuery<String> automobile1 = em.createQuery("SELECT a.VIN FROM automobiles a JOIN a.trim t JOIN t.trimFeatures tf JOIN t.model m JOIN m.modelFeatures mf LEFT JOIN a.chosenPackages cp LEFT JOIN cp.pack p LEFT JOIN p.packageFeatures pf WHERE tf.featureName = ?1 OR mf.featureName = ?1 OR pf.featureName = ?1", String.class);
        automobile1.setParameter(1, userInput);

        try {

            Feature requested = feature.getSingleResult();
            List<String> list1 = automobile1.getResultList();
            LinkedHashSet<String> hashSet = new LinkedHashSet<>(list1);
            ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);

//            for (int i=0; i<list1.size(); i++){
//                System.out.println(list1.get(i));
//            }
            for (String s : listWithoutDuplicates){
                System.out.println(s);
            }

        } catch (NoResultException ex) {
            System.out.println("There is no feature with the feature name that you provided.");
        }

    }


    public static void main(String[] args) throws Exception {



        int choice = menu();

        while (choice != 4){
            if (choice == 1){
                addFeatures();
                addPackages();
                createModel1();
                createModel2();
                createModel3();
                createAutomobiles();
            } else if (choice == 2) {
                scanAutomobile();
            } else {
                featureDetails();
            }
            choice = menu();
        }


    }
}
