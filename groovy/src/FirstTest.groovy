import org.codehaus.groovy.control.CompilationFailedException

/**
 * Created by yuhao.zx on 15-12-3.
 */
class FirstTest {
    static void main(args) {
//        def value = "hello world"
//        println value.class
//        repeat("nifasdfaslfss a");
//        throw new CompilationFailedException();
        def range = 0..4
        println range.class
        assert range instanceof List

        def coll = ["Groovy", "Java", "Ruby"]
        assert  coll instanceof Collection
        assert coll instanceof ArrayList

        def acoll = ["Groovy", "Java", "Ruby"]

        acoll.each{
            println it
        }

        def hash = [name:"Andy", "VPN-#":45]
        hash.each{ key, value ->
            println "${key} : ${value}"
        }

    }

    def static repeat(val){
        def  i
        for(i = 0 ;i < 100 ;i++){
            println val
        }
    }
}
