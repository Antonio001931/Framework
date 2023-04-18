/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import etu1931.framework.ModelView;
import etu1931.framework.Url;
<<<<<<< Updated upstream:Test-framework/src/java/model/Dept.java
=======
import java.util.Vector;
>>>>>>> Stashed changes:Framework/src/java/model/Dept.java

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
    public Dept (){
        
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
<<<<<<< Updated upstream:Test-framework/src/java/model/Dept.java
        
        
        ModelView mv= new ModelView();
        mv.setViewname("ListDept.jsp");
=======
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
>>>>>>> Stashed changes:Framework/src/java/model/Dept.java
       return mv;
    }
    
    @Url(name="dept-add")
    public void add()
    {
        
    }
    
}
    

