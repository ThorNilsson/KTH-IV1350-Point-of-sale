package org.thor.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.thor.model.Sale;

public class ExternalInventorySystemTest {
    private ExternalInventorySystem externalInventorySystem;

    @Before
    public void setUp() throws Exception {
        externalInventorySystem = new ExternalInventorySystem();
     
    }

    @After
    public void tearDown() throws Exception {
        externalInventorySystem = null;
    }

    @Test
    public void registerSale() {
         externalInventorySystem.registerSale(new Sale() );
    }
}