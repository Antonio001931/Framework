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
public class Emp {
    int id;
    String nom;
    Date date;
    
    public Emp()
    {}

    public Emp(int id, String nom,Date date) {
        this.id = id;
        this.nom = nom;
        this.date=date;
        
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
  @Url(name = "emp-all")
    public ModelView findall()
    {
        Date d=new Date("2020-02-10");
       
        Emp e = new Emp(100, "rindra", d);
        Emp e1= new Emp(50, "le", d);
        Vector<Emp> v=new Vector();
        v.add(e);
        v.add(e1);
         ModelView mv= new ModelView();
        mv.addItem("emp", v);
        mv.setUrl("ListEmp.jsp");
       return mv;
    }
    
    @Url(name="emp-add")
    public void add()
    {
        
    }
  @Url(name= "save-emp")
    public ModelView save() {
      
         Emp emp = new Emp();
         Vector<Emp> lemp=new Vector();
         lemp.add(this);
        
        ModelView mv= new ModelView();
        mv.addItem("empl",lemp);
        mv.setUrl("ListEmp.jsp");
        return mv;       
    }
    
    
     
     
     
  /*@Url(name = "emp-det")
    public ModelView select(int idp)
    {
     
       //this.id=idp;
       Emp emp = new Emp();
         Vector<Emp> lemp=new Vector();
         lemp.add(this);
        p emp = new Emp();
         Vector<Emp> lemp=new Vector();
         
        ModelView mv= new ModelView();
        mv.addItem("empl",lemp);
        mv.setUrl("ListEmp.jsp");
        return mv;       
    }*/
}
