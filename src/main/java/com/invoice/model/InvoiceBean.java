package com.invoice.model;

public class InvoiceBean {
	Invoice invoice;
	CustomerDetail customerDetail;
	public Invoice getInvoice() {
		return invoice;
	}
	public InvoiceBean(Invoice invoice, CustomerDetail customerDetail) {
		super();
		this.invoice = invoice;
		this.customerDetail = customerDetail;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}
	

}
