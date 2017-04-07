package rxdemo.service;

import rxdemo.model.DispensableDrug;

import java.util.ArrayList;
import java.util.List;

/**
 *  Represents a vendor drug database - a stub.
 */
public class DrugDatabase
{
	private static List<DispensableDrug> drugsInDatabase;

	List<DispensableDrug> getDrugsAvailableForPrescribing() {
		return null;
	}

	boolean doesDrugBelongToClass(String drugClassification) {
		return false;
	}


	private static void loadDrugData() {
		drugsInDatabase = new ArrayList<>();
		drugsInDatabase.add(new DispensableDrug(100, "Aspirin", new String[]{""} ));
	}


}
