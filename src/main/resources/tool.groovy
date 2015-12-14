import com.woom.Users
import com.woom.tools.GroovyTest
import groovyjarjarantlr.ANTLRHashString
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

class FooImpl implements GroovyTest{

    private String message = "Bingo"

    public String getMessage() {
        def st = ['classpath*:/test/groovy.xml'] as String[]
        ApplicationContext ctx = new ClassPathXmlApplicationContext(st);
        Users service = (Users) ctx.getBean("user");
        println service.getCode();
        service.setCode(""+new Date().getTime())
        println service.getCode();
        // change the implementation to surround the message in quotes
        return "'" + this.message + "'"
    }

    public void setMessage(String message) {
        this.message = message
    }


}