/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import etu1931.framework.ModelView;
import etu1931.framework.Url;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author antonio
 */
public class Dept {
     int id;
    String nom;
 

    
    public Dept (){
        
    }
    
    public Dept(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
   
  @Url(name = "dept-all")
    public ModelView findall()
    {
        Dept dp1=new Dept(1,"MATH");
          Dept dp2=new Dept(2,"ITU");
           Dept dp3=new Dept(3,"LETTRES");
           
           Vector<Dept> vect=new Vector();
           vect.add(dp1);
            vect.add(dp2);
             vect.add(dp3);
            
             
        ModelView mv= new ModelView();
        mv.addItem("list",vect);
        mv.setUrl("ListDept.jsp");
       return mv;
    }
    
    @Url(name="dept-add")
    public void add()
    {
        
    }
    /*@Url(name = "dept-det")
    public ModelView select(int idp)
    {
     
       this.id=idp;
      
         Vector<Dept> lemp=new Vector();
         lemp.add(this);
        
        ModelView mv= new ModelView();
        mv.addItem("dept",lemp);
        mv.setUrl("ListDept.jsp");
        return mv;       
    }*/
    
}
    

