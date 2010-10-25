package eu.masconsult.contacto.data;

import java.io.Serializable;

public class SearchFilter implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private final String term;
    private final Object propertyId;
    private String searchName;

    public SearchFilter(Object propertyId, String searchTerm, String name) {
          this.propertyId = propertyId;
          this.term = searchTerm;
          this.searchName = name;
    }

    public String getTerm() {
		return term;
	}
    
    public Object getPropertyId() {
		return propertyId;
	}
    
    public String getSearchName() {
		return searchName;
	}
    
    @Override
    public String toString() {
        return getSearchName();
    }
}
