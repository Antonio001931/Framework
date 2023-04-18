/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

<<<<<<< Updated upstream:Test-framework/src/java/model/Emp.java
import etu1931.framework.Url;
=======
import etu1931.framework.ModelView;
import etu1931.framework.Url;
import java.util.Vector;
>>>>>>> Stashed changes:Framework/src/java/model/Emp.java

/**
 *
 * @author antonio
 */
public class Emp {
    int id;
    String nom;
    
    public Emp()
    {}

    public Emp(int id, String nom) {
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
    
  @Url(name = "emp-all")
    public ModelView findall()
    {
        
        Emp e1=new Emp(1,"Antonio");
         Emp e2=new Emp(2,"Rindra");
          Emp e3=new Emp(3,"Imanoela");
        Vector<Emp> v=new Vector();
        v.add(e1);
         v.add(e2);
          v.add(e3);
        
        ModelView mv= new ModelView();
        mv.addItem("emp", v);
        mv.setUrl("ListEmp.jsp");
       return mv;
    }
    
    @Url(name="emp-add")
    public void add()
    {
        
    }
    
}
