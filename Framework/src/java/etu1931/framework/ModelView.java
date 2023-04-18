/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu1931.framework;

<<<<<<< Updated upstream
=======
import java.util.HashMap;

>>>>>>> Stashed changes
/**
 *
 * @author antonio
 */
public class ModelView {
<<<<<<< Updated upstream
    String Viewname;
=======
    String url;
    HashMap<String,Object> data= new HashMap<String,Object>();
>>>>>>> Stashed changes

    public ModelView() {
    }

<<<<<<< Updated upstream
    public String getViewname() {
        return Viewname;
    }

    public void setViewname(String Viewname) {
        this.Viewname = Viewname;
    }
    
    
=======
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
    public void addItem(String key,Object value)
    {
      data.put(key, value);
      
    }
    

   
>>>>>>> Stashed changes
    
}
