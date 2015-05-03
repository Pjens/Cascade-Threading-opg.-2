public class Main {

  public static void main( String[] argv ) {
    Cascade næste = null;
    
    for ( int i=0; i<10; i++ ) {
      næste = new Cascade( "Tester tråd nr. " + i, næste );
      næste.start();
    }
    
    næste.skiftTur();
  }
}
