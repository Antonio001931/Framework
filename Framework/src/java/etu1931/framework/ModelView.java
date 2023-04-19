/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu1931.framework;

import java.util.HashMap;

/**
 *
 * @author antonio
 */
public class ModelView {
    String url;
    HashMap<String,Object> data= new HashMap<String,Object>();

    public ModelView() {
    }

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
    

   
    
}
