package rxdemo.vendordata;

// highly simplified, non-hiearchical drug classification concepts

public enum EDrugClassification {
   ANALGESIC(3645, "Analgesic, Anti-inflammatory, or Antipyretic"),
   ANALGESICS_NARCOTIC(582, "Analgesics - Narcotic"),
   ANTIANXIETY(523, "Antianxiety Agent - Benzodiazepines"),
   ANTIBACTERIAL(2549, "Antibacterial Agents"),
   VITAMINS_WATER_SOLUBLE(658, "Vitamins - Water Soluble"),
   NASAL_CORTICOSTEROIDS(301, "Nasal Corticosteroids"),
   ACE_INHIBITORS(6108, "ACE Inhibitors and ACE Inhibitor Combinations"),
   ANTIHYPERLIPIDEMICS(263, "Antihyperlipidemics"),
   NARCOTIC_ANTHISTAMINE(338, "Narcotic Antitussive-Antihistamine Combinations"),
   PLATELET_AGGREGATION_INHIBITORS(3530, "Platelet Aggregation Inhibitors and Combinations");


   private int etcClassificationCode;
   private String description;


   EDrugClassification(int code, String description) {
      this.etcClassificationCode = code;
      this.description = description;
   }

   public int getEtcClassificationCode() {
      return etcClassificationCode;
   }

   public String getDescription() {
      return description;
   }
}
