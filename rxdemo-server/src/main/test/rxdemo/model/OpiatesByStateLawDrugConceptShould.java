package rxdemo.model;

import org.junit.Assert;
import org.junit.Test;
import rxdemo.service.EDrugClassification;

public class OpiatesByStateLawDrugConceptShould {

    @Test
    public void identifyDrugInConcept() {
        DispensableDrug drug = new DispensableDrug(1, "diazepam",
                new EDrugClassification[]{EDrugClassification.ANTIANXIETY} );
        Assert.assertTrue(OpiatesByStateLawDrugConcept.isDrugInConcept(drug));
    }

    @Test
    public void identifiesDrugInConceptWhenDrugHasMultipleClasses() {
        DispensableDrug drug = new DispensableDrug(1, "fake drug",
                new EDrugClassification[]{EDrugClassification.ANTIBACTERIAL, EDrugClassification.ANTIANXIETY} );
        Assert.assertTrue(OpiatesByStateLawDrugConcept.isDrugInConcept(drug));
    }

    @Test
    public void rejectDrugNotInConcept() {
        DispensableDrug drug = new DispensableDrug(1, "fluticasone",
                new EDrugClassification[]{EDrugClassification.NASAL_CORTICOSTEROIDS});
        Assert.assertFalse(OpiatesByStateLawDrugConcept.isDrugInConcept(drug));
    }

}