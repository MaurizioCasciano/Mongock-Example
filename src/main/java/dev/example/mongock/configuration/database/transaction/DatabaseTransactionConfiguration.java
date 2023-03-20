package dev.example.mongock.configuration.database.transaction;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DatabaseTransactionConfiguration {
    /**
     * Transaction Manager.
     * Needed to allow execution of changeSets in transaction scope.
     */
    @Bean
    public MongoTransactionManager transactionManager(MongoTemplate mongoTemplate) {
        TransactionOptions transactionalOptions = TransactionOptions.builder()
                .readConcern(ReadConcern.MAJORITY)
                .readPreference(ReadPreference.primary())
                .writeConcern(WriteConcern.MAJORITY.withJournal(true))
                .build();
        return new MongoTransactionManager(mongoTemplate.getMongoDatabaseFactory(), transactionalOptions);
    }
}
