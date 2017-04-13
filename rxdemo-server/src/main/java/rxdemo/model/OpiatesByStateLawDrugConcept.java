package rxdemo.model;

import rxdemo.service.EDrugClassification;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class OpiatesByStateLawDrugConcept {

    private static EDrugClassification[] opiateClasses = new EDrugClassification[]{
            EDrugClassification.ANTIANXIETY,
            EDrugClassification.ANALGESICS_NARCOTIC,
            EDrugClassification.NARCOTIC_ANTHISTAMINE};

    public static List<EDrugClassification> getClassificationsInConcept() {
        return Arrays.asList(opiateClasses);
    }

    static boolean isDrugInConcept(DispensableDrug drug) {
        HashSet<EDrugClassification> classesForDrug = new HashSet<>(drug.getClassifications());
        classesForDrug.retainAll(Arrays.asList(opiateClasses));
        return !classesForDrug.isEmpty();
    }
}
