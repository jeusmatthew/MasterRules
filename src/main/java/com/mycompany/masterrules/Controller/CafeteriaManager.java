/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.masterrules.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mycompany.masterrules.Model.CafeteriaMenu;
import com.mycompany.masterrules.Model.CafeteriaStorage;
import com.mycompany.masterrules.Model.Combo;
import com.mycompany.masterrules.Model.Product;

/**
 *
 * @author alexs
 */
public class CafeteriaManager {

    private CafeteriaMenu menu;
    private CafeteriaStorage storage;

    public CafeteriaManager(CafeteriaMenu menu, CafeteriaStorage storage) {
        this.menu = menu;
        this.storage = storage;
    }

    public void createProduct() {
        Scanner scanStr = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        Scanner scanLong = new Scanner(System.in);

        System.out.println("Dame el nombre del producto:");
        String name = scanStr.nextLine();

        System.out.println("Dame el tipo del producto:");
        String type = scanStr.nextLine();//problemente esta termine con un conjunto de opciones cerrado de tipo

        System.out.println("Dame el precio del producto:");
        BigDecimal price = new BigDecimal(scanStr.nextLine());

        System.out.println("Dame el precio preferencial del producto:");
        BigDecimal VIPprice = new BigDecimal(scanStr.nextLine());

        System.out.println("¿Se guarda en el inventario? 1)Si 2)No");
        int opcion = scanInt.nextInt();

        Product newProduct;
        switch (opcion) {
            case 1:
                System.out.println("Dame el ID(Código de barras) del producto:");
                long id = scanLong.nextLong();

                newProduct = new Product(id, name, type, price, VIPprice);

                System.out.println("Dame la cantidad que se tiene en el inventario:");
                int quantity = scanInt.nextInt();

                storage.addProduct(newProduct.getID(), quantity);
                menu.addProduct(newProduct);
                break;
            case 2:
                newProduct = new Product(name, type, price, VIPprice);
                menu.addProduct(newProduct);
                break;
            default:
                System.out.println("ERROR: Opción no válida");
                break;
        }
    }

    public void deleteProduct(Product product) {
        menu.removeProduct(product.getProductName());
        storage.removeProduct(product.getID());
    }

    public void editProduct(Product product) {
        //falta esto, creo que necesitamos en menu y storage un método de actualizar (upgradeProduct)
    }

    public void createCombo() {

        Scanner scanStr = new Scanner(System.in);
        Scanner scanBigDec = new Scanner(System.in);

        System.out.println("Dame el nombre del combo:");
        String comboName = scanStr.nextLine();

        List<Product> comboProducts = new ArrayList<>();
        String products;

        do {
            System.out.println("Dame el nombre del producto a agregar al combo:");
            String productName = scanStr.nextLine();

            Product product = menu.searchProductByName(productName); //falta implementar este método
            if (product != null) {
                comboProducts.add(product);
            } else {
                System.out.println("ERROR: Producto no encontrado en el menú.");
            }

            System.out.println("¿Deseas agregar otro producto al combo? 1)Si 2)No:");
            products = scanStr.nextLine();

        } while (products.equalsIgnoreCase("1"));

        System.out.println("Dame el precio del combo:");
        BigDecimal price = new BigDecimal(scanBigDec.nextLine());

        System.out.println("Dame el precio preferencial del combo:");
        BigDecimal VIPprice = new BigDecimal(scanBigDec.nextLine());

        Combo newCombo = new Combo();
        newCombo.setComboName(comboName);
        newCombo.setProducts(comboProducts);
        newCombo.setPrice(price);
        newCombo.setVIPPrice(VIPprice);

        menu.addCombo(newCombo);

        System.out.println("Combo creado y agregado al menú exitosamente.");
    }

    public void deleteCombo(Combo combo) {
        Scanner scanStr = new Scanner(System.in);

        System.out.println("Dame el nombre del combo a eliminar:");
        String comboName = scanStr.nextLine();

        Combo comboToDelete = menu.searchComboByName(comboName); // implementar el metodo buscar combo por nombre
        if (comboToDelete != null) {
            menu.removeCombo(comboName);
            System.out.println("Combo eliminado exitosamente.");
        } else {
            System.out.println("ERROR: Combo no encontrado.");
        }
    }

    public void editCombo(Combo combo) {
        Scanner scanStr = new Scanner(System.in);
        Scanner scanBigDec = new Scanner(System.in);

        System.out.println("Dame el nombre del combo a editar:");
        String comboName = scanStr.nextLine();

        Combo comboToEdit = menu.searchComboByName(comboName); // implementar el metodo buscar combo por nombre

        if (comboToEdit != null) {

            System.out.println("Dame el nuevo nombre del combo (deja en blanco para no cambiar):");
            String newName = scanStr.nextLine();
            if (!newName.isEmpty()) {
                comboToEdit.setComboName(newName);
            }
            System.out.println("¿Deseas agregar nuevos productos al combo? 1)Si 2)No:");
            String addMoreProducts = scanStr.nextLine();
            if (addMoreProducts.equalsIgnoreCase("1")) {
                String moreProducts;
                List<Product> comboProducts = comboToEdit.getProducts();

                do {
                    System.out.println("Dame el nombre del producto a agregar al combo:");
                    String productName = scanStr.nextLine();

                    Product product = menu.searchProductByName(productName); // implementar el metodo buscar producto por nombre
                    if (product != null) {
                        comboProducts.add(product);
                    } else {
                        System.out.println("ERROR: Producto no encontrado en el menú.");
                    }

                    System.out.println("¿Deseas agregar otro producto al combo? (si/no):");
                    moreProducts = scanStr.nextLine();
                } while (moreProducts.equalsIgnoreCase("si"));

                comboToEdit.setProducts(comboProducts);
            }

            System.out.println("Dame el nuevo precio del combo (deja en blanco para no cambiar):");
            String newPriceStr = scanStr.nextLine();
            if (!newPriceStr.isEmpty()) {
                BigDecimal newPrice = new BigDecimal(newPriceStr);
                comboToEdit.setPrice(newPrice);
            }

            System.out.println("Dame el nuevo precio preferencial del combo (deja en blanco para no cambiar):");
            String newVIPPriceStr = scanStr.nextLine();
            if (!newVIPPriceStr.isEmpty()) {
                BigDecimal newVIPPrice = new BigDecimal(newVIPPriceStr);
                comboToEdit.setVIPPrice(newVIPPrice);
            }

            System.out.println("Combo editado exitosamente.");
        } else {
            System.out.println("ERROR: Combo no encontrado.");
        }

    }

    public void editMenu() {//creo que ya no vamos a utilizar esta, a menos que se quiera
        //falta
    }
}
