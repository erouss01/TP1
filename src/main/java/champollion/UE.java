package champollion;

import java.util.ArrayList;

public class UE {
    private final String myIntitule;
    private ServicePrevu SP ;
    private ArrayList<Enseignant> listEns ; 
    
    public UE (String intitule){
        myIntitule = intitule ;
    }

    public UE(String intitule, ServicePrevu SP) {
        myIntitule = intitule;
        this.SP = SP;
        listEns = new ArrayList<>();
        
    }

    public String getIntitule() {
        return myIntitule;
    }

    public ServicePrevu getSP() {
        return this.SP;
    }

    public void setSP(ServicePrevu SP) {
        this.SP = SP;
    }
  
    public void addEns(Enseignant Ens){
        listEns.add(Ens);
    }
    
    public ArrayList getEns(){
        return listEns ;
    }
    
}
