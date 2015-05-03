public class Cascade extends Thread {
  
	
	private Cascade n�steir�kken;
	private boolean nuv�rendetur;
	private String navn;
	
  
  public Cascade( String navn, Cascade n�ste ) {
    this.navn = navn;
    n�steir�kken = n�ste;
    nuv�rendetur = false; // un�dvendigt
  }
  
  public void skiftTur() {
    nuv�rendetur = true;
  }
  
  public void run() {
    while ( !nuv�rendetur )
      sleepRandom(3);
    
       System.out.println(navn + ", Udskrift completed!.");
    if ( n�steir�kken != null )
      n�steir�kken.skiftTur();
  }
  
////------ Start p� hj�lpemetoder (som sjovt nok ikke er servicemetoder ?)------ ////
	
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
	  
	 ////----- Slut p� hj�lpemetoder -----////
  
  
}