package model;

public enum Points {
	  ZERO("00", 0),
	  QUINZE ("15", 1),
	  TRENTE ("30", 2),
	  QUARANTE ("40", 3),
	  DEUCE("AA",4);
	  
	  private String name = "00";
	  private int value = 0;
	   
	  //Constructeur
	  Points(String name, int value){
	    this.name = name;
	    this.value = value;
	  }
	  
	  public int getValue(){
		  return value;
	  }
		   
	  public String toString(){
		    return name;
	  }
	  
	    public Points next() {
	    	if(this.value < 4){
		        for (Points p : Points.values()) {
		            if (p.value == (this.value + 1)) {
		                return p;
		            }
		        }
	    	}
	    	
	    	return null;

	    }
}
