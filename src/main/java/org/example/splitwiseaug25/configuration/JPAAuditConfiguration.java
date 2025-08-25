package org.example.splitwiseaug25.configuration;

import jakarta.persistence.EntityListeners;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// FOR AUTO_UPDATE OF TABLE WE ARE USING THIS CLASS

@Configuration
@EntityListeners(AuditingEntityListener.class)
public class JPAAuditConfiguration {
}
