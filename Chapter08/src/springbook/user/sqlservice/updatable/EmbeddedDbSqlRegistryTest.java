package springbook.user.sqlservice.updatable;

import org.junit.After;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import springbook.user.sqlservice.AbstractUpdatableSqlRegistryTest;
import springbook.user.sqlservice.SqlNotFoundException;
import springbook.user.sqlservice.SqlUpdateFailureException;
import springbook.user.sqlservice.UpdatableSqlRegistry;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.fail;

public class EmbeddedDbSqlRegistryTest extends AbstractUpdatableSqlRegistryTest {
    EmbeddedDatabase db;
    EmbeddedDbSqlRegistry sqlRegistry;

    @Override
    protected UpdatableSqlRegistry createUpdatableSqlRegistry() {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:springbook/user/sqlservice/updatable/sqlRegistrySchema.sql")
                .build();

        sqlRegistry = new EmbeddedDbSqlRegistry();
        sqlRegistry.setDataSource(db);

        return sqlRegistry;
    }

    @Test
    public void transactionalUpdate() throws SqlNotFoundException {
        checkFindResult("SQL1", "SQL2", "SQL3");

        Map<String, String> sqlmap = new HashMap<>();
        sqlmap.put("KEY1", "Modified1");
        sqlmap.put("KEY9999!@#$", "Modified9999");

        try {
            sqlRegistry.updateSql(sqlmap);
            fail();
        } catch (SqlUpdateFailureException e) {}

        checkFindResult("SQL1", "SQL2", "SQL3");
    }

    @After
    public void tearDown() throws Exception {
        db.shutdown();
    }
}
