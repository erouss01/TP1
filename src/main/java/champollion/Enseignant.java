package champollion;

import static champollion.Typeintervention.CM;
import static champollion.Typeintervention.TP;
import java.util.ArrayList;
import java.util.Date;

public class Enseignant extends Personne {

    private ArrayList<UE> unitenseignement ;
    private ArrayList<Intervention> listinter;
    
    public Enseignant(String nom, String email) {
        super(nom, email);
        unitenseignement = new ArrayList <> ();
        listinter = new ArrayList <> () ;
    }
    
    /**e
     * Calcule le nombre total d'heures prévues pour cet enseignant
     * en "heures équivalent TD"
     * Pour le calcul :
     * 1 heure de cours magistral vaut 1,5 h "équivalent TD"
     * 1 heure de TD vaut 1h "équivalent TD"
     * 1 heure de TP vaut 0,75h "équivalent TD"
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant
     **/
    public float heuresPrevues() {
        float hp = 0 ;
        ArrayList<Float> listNBH = new ArrayList<>();
    
        for (UE ue : unitenseignement){
            float nbh = heuresPrevuesPourUE(ue);
            listNBH.add(nbh);
        }
        for (float nbh : listNBH){
            hp = hp + nbh ;
        }
        return hp ;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée
     * en "heures équivalent TD"
     * Pour le calcul :
     * 1 heure de cours magistral vaut 1,5 h "équivalent TD"
     * 1 heure de TD vaut 1h "équivalent TD"
     * 1 heure de TP vaut 0,75h "équivalent TD"
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant
     **/  
    public float heuresPrevuesPourUE(UE ue) {
         int nbh=0;
         ServicePrevu sp =null;
         double coefCM = 1.5 ;
         double coefTP = 0.75 ;         
         for (UE ue2 : unitenseignement){
             if (ue2.equals(ue)){
                 sp=ue2.getSP();
                 nbh=(int) Math.round(coefCM*sp.getCM()+sp.getTD()+coefTP*sp.getTP());
             }
         }
         return nbh;
    }
    
    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral 
     * @param volumeTD le volume d'heures de TD 
     * @param volumeTP le volume d'heures de TP 
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
         ServicePrevu sp = new ServicePrevu (volumeCM,volumeTD,volumeTP) ;  
         ue.setSP(sp);
         unitenseignement.add(ue);
    }
    public float heurePlannifiees (){
        double coefCM = 1.5 ;
        double coefTP = 0.75 ;
        ArrayList <Float> hp = new ArrayList<>();
        Typeintervention typeint = null ;
        boolean annulee = false ;
        float duree = 0;
        float ht = 0 ;
        for (Intervention inter : listinter ){
            annulee = inter.isAnnulee() ; 
            if (annulee==false){
                duree = inter.getDuree();
                typeint = inter.getTypeint();
                if(typeint.equals(TP)){
                    duree = (float) (duree * coefTP) ; 
                }
                if (typeint.equals(CM)){
                    duree = (float) (duree * coefCM) ;
                }
                hp.add(duree);
            }
        }
        for (Float heure : hp){
            ht = ht + heure ; 
        }
        return ht ;
    }
    
    public boolean enSousService(){
        float ht = heurePlannifiees ();
        float hp = heuresPrevues() ; 
        //si le nombre d'heures plannifiées < heures prévues alors en sous service
        if (ht < hp){
            return true ;
        }
        else {
            return false ;
        }
    }
    
    public void ajouterIntervention (Intervention e){
        listinter.add(e);
    }
	
}
