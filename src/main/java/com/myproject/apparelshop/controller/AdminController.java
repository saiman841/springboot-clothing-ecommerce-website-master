package com.myproject.apparelshop.controller;

import com.myproject.apparelshop.model.Category;
import com.myproject.apparelshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

// In this class, the links are mapped, if required, along with mapping, objects are also sent as an attribute.

@Controller
public class AdminController {

    //Category Section

    @Autowired
    CategoryService categoryService; // this is where the business logic is written

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory()); //using service business logic to retrieve all the categories from db.
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category()); // sending category object under the name "category" in order to save the object that will be filled in the form.
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postAddCategory(@ModelAttribute("category") Category category) { // binding the new category attribute to the service which performs the addCategory task of saving the new category
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    // @ModelAttribute - Annotation that binds a method parameter or method return value to a named model attribute, exposed to a web view. Supported for controller classes

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()) { // if category exists, add to model that will be sent to html.
            model.addAttribute("category", category.get()); // To retrieve from optional object, we use .get() method.
            return "categoriesAdd"; //redirecting to add page along with the category model
        } else {
            return "404";
        }
    }

    //Product Section
//    @GetMapping("/admin/categories/products")
//    public String deleteCategory(Model model) {
//        model.addAttribute()
//        return "redirect:/admin/products";
//    }



}

