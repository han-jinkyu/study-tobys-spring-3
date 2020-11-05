package springbook.user.sqlservice.jaxb;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name ="sqlmapType", propOrder = { "sql" })
@XmlRootElement(name = "sqlmap", namespace = "http://www.example.org/sqlmap/")
public class Sqlmap {
    @XmlElement(required = true, name = "http://www.epril.com/sqlmap/")
    protected List<SqlType> sql;

    public List<SqlType> getSql() {
        if (sql == null) sql = new ArrayList<>();
        return sql;
    }
}
