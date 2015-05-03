public class Cascade extends Thread {
  
	
	private Cascade næsteirækken;
	private boolean nuværendetur;
	private String navn;
	
  
  public Cascade( String navn, Cascade næste ) {
    this.navn = navn;
    næsteirækken = næste;
    nuværendetur = false; // unødvendigt
  }
  
  public void skiftTur() {
    nuværendetur = true;
  }
  
  public void run() {
    while ( !nuværendetur )
      sleepRandom(3);
    
       System.out.println(navn + ", Udskrift completed!.");
    if ( næsteirækken != null )
      næsteirækken.skiftTur();
  }
  
////------ Start på hjælpemetoder (som sjovt nok ikke er servicemetoder ?)------ ////
	
	public static double sleepInterruptable( double sekunder ) {
	    long start = System.currentTimeMillis();

	    try {
	      Thread.sleep( (long) (sekunder * 1000) );
	    } catch ( InterruptedException e ) {
	      // accept interruption
	    }

	    return ( (double) System.currentTimeMillis() - start ) / 1000;
	  }
	  
	  public static double sleep( double sekunder ) {
	    double delta=0;

	    while ( delta < sekunder )
	      delta += sleepInterruptable( sekunder - delta );
	    
	    return delta;  
	  }
	  
	  public static double nap() {
	    return sleep( 0.1 );
	  }
	  
	  public static double sleepRandom( double sekunder ) {
	    return sleep( sekunder * Math.random() );
	  }
	  
	 ////----- Slut på hjælpemetoder -----////
  
  
}