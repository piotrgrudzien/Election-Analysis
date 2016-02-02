package wybory;
/**
 * Represents an object needed to identify one poll location (jedna komisje wyborcza)
 * @author Piotrek
 *
 */
public class IdentSet {
	private String Kod;
	private String Obwod;
	public IdentSet(String Kod, String Obwod) {
		this.Kod = Kod;
		this.Obwod = Obwod;
	}
	
	public String getKod(){
		return this.Kod;
	}
	
	public String getObwod(){
		return this.Obwod;
	}
	
	public String toString(){
		return this.Kod + " " +  this.Obwod;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof IdentSet))return false;
	    IdentSet otherIdentSet = (IdentSet)other;
		if(!this.Kod.equals(otherIdentSet.getKod())) return false;
		if(!this.Obwod.equals(otherIdentSet.getObwod())) return false;
		return true;
		/*System.out.println("POROWNUJE");
		return false;*/
	}
	
	@Override
	public int hashCode() {
		int prime = 5;
		int result = 1;
		result = prime * result + this.Kod.hashCode();
		result = prime * result + this.Obwod.hashCode();
		return result;
	}
}
