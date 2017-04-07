package rxdemo.model;

public interface IMedication
{
	String getName();
	boolean isFreeText();
	boolean belongsToClass(String classification);
}
