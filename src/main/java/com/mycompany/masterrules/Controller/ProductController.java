/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.masterrules.Controller;

import com.mycompany.masterrules.Model.CafeteriaManager;
import com.mycompany.masterrules.Model.Product;
import com.mycompany.masterrules.Model.ProductQueries;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author alexs
 */
public class ProductController {
    private CafeteriaManager modelo;
    //faltaria view

    public ProductController(CafeteriaManager modelo) {
        this.modelo = modelo;
    }
    
    public void registerProduct(){
        try{
        //------------------todo esto se encuentra en vista---------------------------
        Scanner scanStr=new Scanner(System.in);
        Scanner scanInt=new Scanner(System.in);
        Scanner scanLong=new Scanner(System.in);
        
        System.out.println("Dame el ID(Código de barras u otro) del producto:");
        long id=scanLong.nextLong();//el id no debe estar aqui porque o generará la propia base de datos
        
        System.out.println("Dame el nombre del producto:");
        String name=scanStr.nextLine();
        
        System.out.println("Dame el tipo del producto:");
        String type=scanStr.nextLine();//problemente esta termine con un conjunto de opciones cerrado de tipo
        
        System.out.println("Dame el precio del producto:");
        BigDecimal price= new BigDecimal(scanStr.nextLine());
        
        System.out.println("Dame el precio preferencial del producto:");
        BigDecimal VIPprice= new BigDecimal(scanStr.nextLine());
        
        System.out.println("¿Se guarda en el inventario? 1)Si 2)No");
        int opcion=scanInt.nextInt();
        
        int quantity=0;//en la vista probablemente aun pongamos por default cero porque nos dara error si no tiene nada
        
        boolean inInventory=false;
        switch(opcion){
            case 1:
                System.out.println("Dame la cantidad que se tiene en el inventario:");
                quantity=scanInt.nextInt();
                inInventory=true;
                
                break;
            case 2:
                inInventory=false;
                break;
            default:
                throw new Exception("ERROR: Opción no válida");//habria que eliminar esta excepcion y el try-catch
        }
        //------------------todo esto se encuentra en vista---------------------------
        
        
        Product newProduct=new Product(id,name,type,price,VIPprice);
        
        modelo.createProduct(newProduct, inInventory, quantity);
        
        //actualizar vista aqui?
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void unregisterProduct(){
        try{
        //------------------todo esto se encuentra en vista---------------------------
        Scanner scanStr=new Scanner(System.in);
        System.out.println("Dame el nombre del producto:");
        String name=scanStr.nextLine();
        //------------------todo esto se encuentra en vista---------------------------
        
        modelo.deleteProduct(name);
        
        //actualizar vista aqui?
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void editProduct(){
        try{
        //------------------todo esto se encuentra en vista---------------------------
        
        //no tengo idea si se puede editar si este es inventariable o no, tampoco se si se puede editar su stock hay que preguntar al equipo, aunque debe de ser facil solo creo que me falta el metodo en Storage y pues si no ponen nada pues el stock se deja igual(si tiene)
        
        //como se modificaria? uno de los problemas que tengo es que pasa si solo se quiere modificar un aspecto del atributo? se verian forzados a escribir todo? 
        //RESPUESTA: Vicky me dijo que quiere que cuando den click a algun product de la tabla les de sus datos en las barras de texto, entonces 

        
        Scanner scanStr=new Scanner(System.in);
        Scanner scanInt=new Scanner(System.in);
        Scanner scanLong=new Scanner(System.in);
        
        System.out.println("Dame el ID(Código de barras u otro) del producto:");
        long id=scanLong.nextLong();//el id no debe estar aqui porque o generará la propia base de datos
        
        System.out.println("Dame el nombre del producto:");
        String name=scanStr.nextLine();
        
        System.out.println("Dame el tipo del producto:");
        String type=scanStr.nextLine();//problemente esta termine con un conjunto de opciones cerrado de tipo
        
        System.out.println("Dame el precio del producto:");
        BigDecimal price= new BigDecimal(scanStr.nextLine());
        
        System.out.println("Dame el precio preferencial del producto:");
        BigDecimal VIPprice= new BigDecimal(scanStr.nextLine());
        
        System.out.println("¿Se guarda en el inventario? 1)Si 2)No");
        int opcion=scanInt.nextInt();
        
        int quantity=0;//en la vista probablemente aun pongamos por default cero porque nos dara error si no tiene nada
        
        boolean inInventory=false;
        switch(opcion){
            case 1:
                System.out.println("Dame la cantidad que se tiene en el inventario:");
                quantity=scanInt.nextInt();
                inInventory=true;
                
                break;
            case 2:
                inInventory=false;
                break;
            default:
                throw new Exception("ERROR: Opción no válida");//habria que eliminar esta excepcion y el try-catch
        }
        
        Product product=new Product(id,name,type,price,VIPprice);
        
        modelo.editProduct(product, inInventory, quantity);
        
        //------------------todo esto se encuentra en vista---------------------------
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
}
