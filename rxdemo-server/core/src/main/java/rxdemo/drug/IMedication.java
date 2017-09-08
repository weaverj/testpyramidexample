package rxdemo.drug;

public interface IMedication {
   String getName();

   boolean isFreeText();

   boolean belongsToClass(String classification);
}
