import java.io.IOException;

public class ExceptionTest {
	public void dosth()throws IOException{
		System.out.println();
	}
	public static void main(String[] args){
		ExceptionTest ett = new ExceptionTest();
		try {
			ett.dosth();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
