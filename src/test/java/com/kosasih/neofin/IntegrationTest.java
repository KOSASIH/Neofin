package com.kosasih.neofin;

import com.kosasih.neofin.NeofinApp;
import com.kosasih.neofin.config.AsyncSyncConfiguration;
import com.kosasih.neofin.config.EmbeddedElasticsearch;
import com.kosasih.neofin.config.EmbeddedKafka;
import com.kosasih.neofin.config.EmbeddedSQL;
import com.kosasih.neofin.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { NeofinApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
