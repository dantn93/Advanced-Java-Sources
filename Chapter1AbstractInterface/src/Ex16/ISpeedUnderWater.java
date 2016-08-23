/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex16;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public interface ISpeedUnderWater {
    //Calculate speed of vehicle under water
    //trend: whether same way with water or not
    void calSpeed(double distance, double time, double vWater);
}
