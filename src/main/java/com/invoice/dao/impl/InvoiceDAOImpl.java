package com.invoice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.invoice.dao.InvoiceDAO;
import com.invoice.model.CustomerDetail;
import com.invoice.model.Invoice;
import com.invoice.model.InvoiceBean;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public List<InvoiceBean> listInvoice() {
		Session session = this.sessionFactory.getCurrentSession();
		List<InvoiceBean> invoiceBeanList = new ArrayList<InvoiceBean>();
		List<Invoice> invoiceList = session.createQuery("from Invoice").list();
		for(Invoice invoice : invoiceList){
			CustomerDetail customerDetail = (CustomerDetail) session.createQuery("from CustomerDetail where id=:id").setString("id", invoice.getCusId()).uniqueResult();
			InvoiceBean invoiceBean = new InvoiceBean(invoice, customerDetail);
			invoiceBeanList.add(invoiceBean);
		}
		return invoiceBeanList;
	}

}
