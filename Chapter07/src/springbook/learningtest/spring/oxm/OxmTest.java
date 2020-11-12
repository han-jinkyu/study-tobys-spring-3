package springbook.learningtest.spring.oxm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.user.sqlservice.jaxb.SqlType;
import springbook.user.sqlservice.jaxb.Sqlmap;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration   // '클래스 이름' + '-context.xml' 파일을 사용하는 애플리케이션 컨텍스트 생성
public class OxmTest {
    @Autowired
    Unmarshaller unmarshaller;

    @Test
    public void unmarshallSqlMap() throws XmlMappingException, IOException {
        Source xmlSource = new StreamSource(
                getClass().getResourceAsStream("sqlmap.xml"));

        Sqlmap sqlmap = (Sqlmap) this.unmarshaller.unmarshal(xmlSource);

        List<SqlType> sqlList = sqlmap.getSql();
        assertThat(sqlList.size(), is(3));
        assertThat(sqlList.get(0).getKey(), is("add"));
        assertThat(sqlList.get(1).getKey(), is("get"));
        assertThat(sqlList.get(2).getKey(), is("delete"));
    }
}
