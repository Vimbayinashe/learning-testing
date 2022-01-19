package org.example.invoice;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class InvoiceFilterTest {

    @Test
    void keepInvoicesWithValuesLessThan100() {
        InvoiceDao invoiceDao = new InvoiceDaoStub();
        InvoiceFilter filter = new InvoiceFilter(invoiceDao);

        var result = filter.filter();

        assertThat(result).hasSize(1)
                .contains(new Invoice("Martin", 99.0))
                .doesNotContain(new Invoice("Elias", 100.00));

    }

}
