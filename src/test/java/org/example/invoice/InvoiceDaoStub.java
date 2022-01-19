package org.example.invoice;

import java.util.List;

public class InvoiceDaoStub implements InvoiceDao {
    @Override
    public List<Invoice> all() {
        return List.of(
                new Invoice("Martin", 99.0),
                new Invoice("Elias", 100.00)
        );
    }

    @Override
    public void save(Invoice inv) {

    }

    @Override
    public void close() {

    }
}


