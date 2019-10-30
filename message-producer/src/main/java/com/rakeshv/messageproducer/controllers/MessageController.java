package com.rakeshv.messageproducer.controllers;

import com.rakeshv.messageproducer.model.Order;
import com.rakeshv.messageproducer.service.OrderMessageSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * MessageController
 */
@Controller
public class MessageController {
    private final OrderMessageSender orderMessageSender;

    @Autowired
    public MessageController(OrderMessageSender sender) {
        this.orderMessageSender = sender;
    }

    @GetMapping("/send")
    public String sendMessage(Order order, RedirectAttributes redirectAttributes) {
        orderMessageSender.sendOrder(order);
        redirectAttributes.addFlashAttribute("message", "Order message sent successfully");
        return "redirect:/";
    }
    
}