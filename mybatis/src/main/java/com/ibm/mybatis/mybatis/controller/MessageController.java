package com.ibm.mybatis.mybatis.controller;

import com.ibm.mybatis.mybatis.entity.Message;
import com.ibm.mybatis.mybatis.repository.MessageRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private  final MessageRepository messageRepository;


    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @GetMapping
    public ModelAndView list() {
        Iterable<Message> messages = this.messageRepository.findAll();
        return new ModelAndView("messages/list", "messages", messages);
    }



    // 进入创建消息页面
    @GetMapping(params="form")
    public ModelAndView createForm(@ModelAttribute Message message) {
        return new ModelAndView("messages/form", "message", message);
    }



    @PostMapping
    public ModelAndView create(@Valid Message message, BindingResult result, RedirectAttributes redirectAttributes){
        //内容验证有问题
        if(result.hasErrors()){
            return new ModelAndView("messages/form","formErrors",result.getAllErrors());
        }
        message = this.messageRepository.save(message);
        redirectAttributes.addFlashAttribute("globalMessage","Successfully add a message");
        return new ModelAndView("redirect:/messages/{message.id}","message.id",message.getId());
       // Iterable<Message> messages = this.messageRepository.findAll();
      //  return  new ModelAndView("messages/list","messages",messages);
      //  return new ModelAndView("redirect:/messages");
    }


    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") long id){
        Message message = this.messageRepository.findMessage(id);//少了这句
       return new ModelAndView("messages/view","message",message);
    }

    @GetMapping("modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") long id){
        Message message = this.messageRepository.findMessage(id);//少了这句
        return new ModelAndView("messages/form","message",message);
    }



    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        this.messageRepository.deleteMessage(id);
        Iterable<Message> messages = this.messageRepository.findAll();
        return  new ModelAndView("messages/list","messages",messages);

    }


}
