import com.bank.antifraud.entity.Audit;
import com.bank.antifraud.repository.AuditRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class AuditTest {

    @Mock
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
        Assertions.assertNotEquals(audit.getId(), BigInteger.ZERO);
    }

    @Test
    public void getAuditTest() {
        Audit audit = auditRepository.findById(BigInteger.valueOf(1)).orElse(null);

        Assertions.assertNotNull(audit);
    }


}
