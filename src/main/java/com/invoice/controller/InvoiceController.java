package com.invoice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.invoice.model.InvoiceBean;
import com.invoice.service.InvoiceService;

@Controller
public class InvoiceController {

	private InvoiceService invoiceService;

	public InvoiceService getInvoiceService() {
		return invoiceService;
	}

	@Autowired(required=true)
	@Qualifier(value="invoiceService")
	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView listInvoices() {
		System.out.println("inside invoceList");
		ModelAndView model = new ModelAndView();
		List<InvoiceBean> invoiceBeanList = getInvoiceService().listInvoice();
		model.addObject("invoiceList", invoiceBeanList);
		model.addObject("totalSize", invoiceBeanList);
		model.setViewName("invoice");
		return model;
	}
//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public ModelAndView defaultmethot(ModelAndView model) {
//		String message = "HelloSpring";
//	    return model = new ModelAndView("hello", "message", message);
//	}
	
	
}
