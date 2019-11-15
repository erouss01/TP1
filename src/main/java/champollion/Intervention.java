/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author Emma
 */
public class Intervention {
    private Date date ;
    private float duree ;
    private boolean annulee;
    private UE ue ;
    private Salle salle ;
    private Typeintervention typeint;
    
    public Intervention(Date debut, float duree, boolean annulee, UE ue, Salle salle, Typeintervention typeint){
        this.date = debut ;
        this.duree=duree ;
        this.annulee=annulee;
        this.ue = ue ;
        this.salle = salle ;
        this.typeint = typeint;
    }

    public float getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public Typeintervention getTypeint() {
        return typeint;
    }
    
}
