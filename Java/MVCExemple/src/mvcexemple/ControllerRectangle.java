/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcexemple;

/**
 *
 * @author malcom
 */
public class ControllerRectangle {
    
    private ModelRectangle model;
    private DFForm vue;
    
    public ControllerRectangle(ModelRectangle monModel, DFForm maVue){
        this.model=monModel;
        this.vue=maVue;
        
        //on ajoute un observer a notre Model
        monModel.addObserver(vue);
    }
    
}
