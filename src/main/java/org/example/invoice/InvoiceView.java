package org.example.invoice;

import java.util.List;
import java.util.function.Consumer;

public class InvoiceView {

    public static void main(String[] args) {
        var invoiceView = new InvoiceView();
        invoiceView.printInvoices();
    }

    //refactoring to make method more testable & make printInvoices() do less things (i.e. refactor)
    public void printInvoices() {
        InvoiceDao invoiceDao = new InvoiceH2Dao();
        invoiceDao.save(new Invoice("Pelles gott", 99.0));
        invoiceDao.save(new Invoice("ICA Mini", 50.0));
        invoiceDao.save(new Invoice("Enegårdens kött", 101.0));

        InvoiceFilter filter = new InvoiceFilter(invoiceDao);

        printInvoices(filter.filter(), this::printInvoice);
    }

    private void printInvoices(List<Invoice> invoices, Consumer<Invoice> printConsumer) {
        invoices.forEach(printConsumer);
    }
    //Consumer allows us to replace sout with another method during testing

    private void printInvoice(Invoice invoice) {
        System.out.println("Customer: " + invoice.getCustomer());
        System.out.println("Amount: " + invoice.getValue());
    }
}
