package springbook.user.sqlservice;

import java.util.HashMap;
import java.util.Map;

public class HashMapSqlRegistry implements SqlRegistry {
    private Map<String, String> sqlMap = new HashMap<>();

    @Override
    public void registerSql(String key, String sql) {
        this.sqlMap.put(key, sql);
    }

    @Override
    public String findSql(String key) throws SqlNotFoundException {
        if (!sqlMap.containsKey(key)) {
            throw new SqlNotFoundException(key + "에 대한 SQL을 찾을 수 없습니다");
        }
        return sqlMap.get(key);
    }
}
