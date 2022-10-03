package br.com.fiap.epictaskapi.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.repository.TaskRepository;
import br.com.fiap.epictaskapi.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskWebController {

    @Autowired
    TaskService service;
    
     @GetMapping
     public ModelAndView index(){
        // TODO criar paginação
        return
            new ModelAndView("/task/index")
            .addObject("tasks", service.listAll());
     }

     @GetMapping("new")
     public String form(){
        return "/task/form";
     }

     @PostMapping("new")
     public String create(Task task){
        service.save(task);
        return "/task/index";
     }

}
