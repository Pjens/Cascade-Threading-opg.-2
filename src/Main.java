public class Main {

  public static void main( String[] argv ) {
    Cascade n�ste = null;
    
    for ( int i=0; i<10; i++ ) {
      n�ste = new Cascade( "Tester tr�d nr. " + i, n�ste );
      n�ste.start();
    }
    
    n�ste.skiftTur();
  }
}
