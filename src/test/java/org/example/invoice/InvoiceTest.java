package org.example.invoice;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;


class InvoiceTest {

    @Test
    void verifyEqualsAndHashCode() {
        EqualsVerifier.forClass(Invoice.class).verify();
    }

}