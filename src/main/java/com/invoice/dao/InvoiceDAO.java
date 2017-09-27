package com.invoice.dao;

import java.util.List;

import com.invoice.model.InvoiceBean;

public interface InvoiceDAO {
	public List<InvoiceBean> listInvoice();
}
