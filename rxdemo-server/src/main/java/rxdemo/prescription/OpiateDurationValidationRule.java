package rxdemo.prescription;

public class OpiateDurationValidationRule
{
}


//package vanderbilt.rxwriter.rxbuilderrules.rules;
//
//		import org.apache.commons.lang.StringUtils;
//
//		import vanderbilt.rxwriter.drugclassification.DrugConceptController;
//		import vanderbilt.rxwriter.drugclassification.EDrugClassificationConcept;
//		import vanderbilt.rxwriter.druginfo.interfaces.controllers.IDrugClassificationsController;
//		import vanderbilt.rxwriter.prescription.model.IDispensedPrescriptionReadOnly;
//		import vanderbilt.rxwriter.rxbuilderrules.infrastructure.ERxBuilderField;
//		import vanderbilt.rxwriter.rxbuilderrules.infrastructure.IRxBuilderRule;
//		import vanderbilt.rxwriter.rxbuilderrules.infrastructure.IRxBuilderRuleResult;
//		import vanderbilt.rxwriter.rxbuilderrules.infrastructure.RxBuilderRuleResult;
//		import vanderbilt.rxwriter.util.calculation.DaysSupplyCalculator;
//
//public class TennesseeOpiates30DayRule implements IRxBuilderRule
//{
//	private DrugConceptController conceptController;
//
//	public static String ADDISON_SHARP_TEXT = "Tennessee law prohibits the dispensing of opioids and benzodiazepines in quantities greater than " +
//			"a 30-day supply. Refills may be used to extend the intended duration of treatment.";
//
//
//	public TennesseeOpiates30DayRule(IDrugClassificationsController classificationsController)
//	{
//		this.conceptController = new DrugConceptController(classificationsController);
//	}
//
//
//	public boolean isRuleApplicableToRx(IDispensedPrescriptionReadOnly rx)
//	{
//		return conceptController.isMedicationIncludedInConcept(rx.getMedication(), EDrugClassificationConcept.OPIATE);
//	}
//
//	public IRxBuilderRuleResult runRuleForRx(IDispensedPrescriptionReadOnly rx)
//	{
//		RxBuilderRuleResult result = new RxBuilderRuleResult();
//
//		result.markFieldToClearAndDisable(ERxBuilderField.FREE_TEXT_DOSING_ENABLED);
//		result.markFieldToClearAndDisable(ERxBuilderField.FREE_TEXT_DOSING_TEXT);
//
//		if (rx.getFreeTextDosing())
//		{
//			result.markFieldAsInvalid(ERxBuilderField.FREE_TEXT_DOSING_ENABLED, "Free text dosing is not allowed for opioids or benzodiazepines.");
//			result.addOtherIncompleteReason(ADDISON_SHARP_TEXT);
//		}
//		else if (rx.getDuration() == null || StringUtils.isBlank(rx.getDuration()))
//		{
//			result.markRequiredFieldAsMissing(ERxBuilderField.DURATION);
//			result.addOtherIncompleteReason(ADDISON_SHARP_TEXT);
//		}
//		else
//		{
//			if (DaysSupplyCalculator.getDaysSupplyInt(rx.getDuration()) == 0)
//			{
//				result.markFieldAsInvalid(ERxBuilderField.DURATION, "Duration must be convertible to days.");
//				result.addOtherIncompleteReason(ADDISON_SHARP_TEXT);
//			}
//			else if (DaysSupplyCalculator.getDaysSupplyInt(rx.getDuration()) > 30)
//			{
//				result.markFieldAsInvalid(ERxBuilderField.DURATION, "Duration exceeds 30 days.");
//				result.addOtherIncompleteReason(ADDISON_SHARP_TEXT);
//			}
//		}
//
//		return result;
//	}
//}
