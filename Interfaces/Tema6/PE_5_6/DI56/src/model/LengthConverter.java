/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ubuntu
 */
public class LengthConverter {
    private static final Double mileToKm=1.60934;  // 1 milla = 1,60934 km
    
    public Double milesToKms(Double miles) {
        return miles*mileToKm;
}
    public Double KmsToMiles(Double kms) {
        return kms/mileToKm;
    }
    
    
}



