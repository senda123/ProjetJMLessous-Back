package tn.esprit.spring.entity;

public enum OperationType {
VERSEMENT,RETRAIT,VIREMENT;
public String toString(){
    switch(this){
    case VERSEMENT :
        return "versement";
    case RETRAIT :
        return "retrait";
    case VIREMENT :
        return "virement";
    }
    return null;
}
}
