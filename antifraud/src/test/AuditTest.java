import com.bank.antifraud.entity.Audit;
import com.bank.antifraud.repository.AuditRepository;
import com.bank.antifraud.service.AuditServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigInteger;
import java.util.Date;

@DataJpaTest
@Configuration
@ComponentScan("com.bank.antifraud")
@EnableAutoConfiguration
public class AuditTest {

    @Autowired
    private AuditServiceImpl auditService;

    @Autowired
    private AuditRepository auditRepository;

    @Test
    public void saveAudit() {
        Audit audit = Audit.builder()
                .createdAt(new Date())
                .createdBy("aboba1")
                .modifiedAt(new Date())
                .modifiedBy("aboba2")
                .entityJson("aboba3")
                .entityType("aboba4")
                .operationType("aboba5")
                .newEntityJson("aboba6")
                .build();

        auditRepository.save(audit);
        Assertions.assertEquals(audit.getId(), BigInteger.ONE);
    }

    @Test
    public void getAuditTest() {
        Audit audit = auditService.getById(BigInteger.valueOf(1));

        Assertions.assertNotNull(audit);
    }


}
