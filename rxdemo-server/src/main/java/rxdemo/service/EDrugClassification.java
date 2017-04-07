package rxdemo.service;

// highly simplified, non-hiearchical drug classification concepts

public enum EDrugClassification
{
	ANALGESIC(3645, "Analgesic, Anti-inflammatory, or Antipyretic"),  //aspirin
	ANALGESICS_NARCOTIC(582, "Analgesics - Narcotic"),  //oxycodone
	ANTIANXIETY(523, "Antianxiety Agent - Benzodiazepines"),  //diazepam
	ANTIBACTERIAL(2549, "Antibacterial Agents"),  //bactrim
	VITAMINS_WATER_SOLUBLE(658, "Vitamins - Water Soluble"),  //folic acid
	ACE_INHIBITORS(6108, "ACE Inhibitors and ACE Inhibitor Combinations"),  //lisinopril
	ANTIHYPERLIPIDEMICS(263, "Antihyperlipidemics"),  //simvastatin
	NARCOTIC_ANTHISTAMINE(338, "Narcotic Antitussive-Antihistamine Combinations"),  //hydrocodone-chlorpheniramine
	PLATELET_AGGREGATION_INHIBITORS(3530, "Platelet Aggregation Inhibitors and Combinations");  // aspirin


	private int etcClassificationCode;
	private String description;


	EDrugClassification(int code, String description)
	{
		this.etcClassificationCode = code;
		this.description = description;
	}

	public int getEtcClassificationCode()
	{
		return etcClassificationCode;
	}

	public String getDescription()
	{
		return description;
	}
}
