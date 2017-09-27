package com.invoice.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.dao.InvoiceDAO;
import com.invoice.model.InvoiceBean;
import com.invoice.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	
	private InvoiceDAO invoiceDAO;
	
	public InvoiceDAO getInvoiceDAO() {
		return invoiceDAO;
	}

	public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
		this.invoiceDAO = invoiceDAO;
	}
	
	@Transactional
	public List<InvoiceBean> listInvoice() {
		// TODO Auto-generated method stub
		return getInvoiceDAO().listInvoice();
	}

}
