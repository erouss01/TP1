package champollion;

public class ServicePrevu {

    private int volumeCM;
    private int volumeTD;
    private int volumeTP;
    
    public ServicePrevu (int volumeCM, int volumeTD, int volumeTP){
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
    }

    public int getCM() {
        return volumeCM;
    }

    public int getTD() {
        return volumeTD;
    }

    public int getTP() {
        return volumeTP;
    }
    
    
}
