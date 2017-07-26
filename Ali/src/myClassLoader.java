import java.net.URL;
class Test{}
public class myClassLoader {
	public static void main(String[] args) {
//	    URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();  
//	    for (int i = 0; i < urls.length; i++) {  
//	        System.out.println(( urls[i]).toExternalForm());  
//	    } 
//	    System.out.println(System.getProperty("sun.boot.class.path"));
//	    
	    ClassLoader cl = Test.class.getClassLoader();

        System.out.println("ClassLoader is:"+cl.getParent().toString());
        
        cl = int.class.getClassLoader();

        System.out.println("ClassLoader is:"+cl.toString());
	}
}
