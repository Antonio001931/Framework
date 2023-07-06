package etu1931.framework.servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import etu1931.framework.Dates;
import etu1931.framework.ModelView;
import etu1931.framework.Find_annotation;
import etu1931.framework.Mapping;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etu1931.framework.Mapping;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;





/**
 *
 * @author antonio
 */
@WebServlet(name = "FrontServlet", urlPatterns = {"/FrontServlet"})
public class FrontServlet extends HttpServlet { 
 
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HashMap<String,Mapping>  mappinUrls;
    
       public void init() throws ServletException{
        mappinUrls=new HashMap<String,Mapping>();
        List<Find_annotation.AnnotatedMethod> annotatedMethods;
        try {
            annotatedMethods = Find_annotation.findAnnotatedMethods();
            for (Find_annotation.AnnotatedMethod method : annotatedMethods) {
           // out.println("Annotated method " + method.getMethod().getName() + " in class " + method.getClassName() +" value ="+method.getValue());
           Mapping mapping = new Mapping(method.getClassName(),method.getMethod().getName());
           mappinUrls.put(method.getValue(), mapping);
            }

        } catch (Exception ex) {
           
            System.out.println(ex.getMessage());
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        /*    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Servlet : FrontServlet");
        out.println("");
        out.println("Context Path :"+request.getContextPath());
        out.println("");
        out.println("URL :"+request.getRequestURL());
        out.println("");     
         for (Map.Entry<String,Mapping> entry : mappinUrls.entrySet()) {
            
            out.println("KEY--> "+entry.getKey() + " ,VALUE:--> Class :" +entry.getValue().getClassName() + " , Method : " + entry.getValue().getMethod());

        }*/
             throws ServletException, IOException {
    
        PrintWriter out = response.getWriter();
         /* for (Map.Entry<String,Mapping> entry : mappinUrls.entrySet()) {
            
            out.println("KEY--> "+entry.getKey() + " ,VALUE:--> Class :" +entry.getValue().getClassName() + " , Method : " + entry.getValue().getMethod());

        }*/
        String url = request.getRequestURI();
        url = url.split("/")[url.split("/").length-1];
        
        try {  
          if (mappinUrls.containsKey(url)) {
                Mapping mapping = mappinUrls.get(url);
                Class<?> classe = Class.forName(mapping.getClassName());              
                Object instance = classe.getDeclaredConstructor().newInstance();            
             //sprint8          
                Method[] all_method = classe.getMethods();
                Method meth = null;
                for(int j=0 ; j < all_method.length ; j++){
                    Method meth_hafa = all_method[j];
                    if(meth_hafa.getName().equals(mapping.getMethod())){
                        meth = meth_hafa;
                        break;
                    }
                    
                }
               
                Parameter[] tout_parametre = meth.getParameters();
                Enumeration<String> allrequestParameter = request.getParameterNames();
                List<String> allrequestP = Collections.list(allrequestParameter);
                Object[] tab_objet = new Object[tout_parametre.length];
                for(int k=0 ; k<tout_parametre.length ; k++){
                  
                    for(int m=0;m<allrequestP.size() ; m++){
                        out.println( allrequestP.get(m));
                        out.println(tout_parametre[k].getName());
                        if(tout_parametre[k].getName().equals(allrequestP.get(m))){
                            PropertyEditor editor = PropertyEditorManager.findEditor(tout_parametre[k].getType());
                            
                           
                             editor.setAsText(request.getParameter(allrequestP.get(m)));
                            tab_objet[k] = editor.getValue();
                            
                        }
                    }
                }
              //Sprint7
          
                Field [] fields = classe.getDeclaredFields();

                    for(int i=0 ;i<fields.length;i++){
                         if(request.getParameter(fields[i].getName())!=null){
                             String setter = "set"+fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1);
                             Object obj = request.getParameter(fields[i].getName());
                             Class<?> fieldtype = fields[i].getType();
                             PropertyEditor editor = PropertyEditorManager.findEditor(fieldtype);
                             PropertyEditorManager.registerEditor(Date.class, Dates.class);
                             editor.setAsText(request.getParameter(fields[i].getName()));
                             classe.getMethod(setter,fieldtype).invoke(instance,editor.getValue());
                         }
                    }
                    
                    
                    
                   for(int i=0 ;i<fields.length;i++){
                         if(request.getParameter(fields[i].getName())!=null){
                             String getter = "get"+fields[i].getName().substring(0, 1).toUpperCase()+fields[i].getName().substring(1);
                             Object obj = request.getParameter(fields[i].getName());
                            out.println(classe.getMethod(getter).invoke(instance));
                         }
                   } 
                   
              
              Object obj =   meth.invoke(instance,tab_objet);
                if (obj.getClass() == ModelView.class) {
                   
                    ModelView mv = (ModelView) obj;
                             for (Map.Entry<String,Object> entry : mv.getData().entrySet()) {
                                 request.setAttribute(entry.getKey(),entry.getValue());
        }
                    
                    
                  
                    RequestDispatcher dispat = request.getRequestDispatcher(mv.getUrl());
                   
                    dispat.forward(request,response);
                   
                } else {
                   
                    throw new Exception("erreur");
                }
            }  
        } catch (Exception e) {
          out.print(e.getMessage());
        }  
     
       
         
    }
      
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         RequestDispatcher disp=request.getRequestDispatcher("ajout.jsp");
           disp.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

