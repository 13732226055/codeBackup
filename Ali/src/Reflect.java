import java.lang.reflect.Field;


class User{
	private String name = "name";
	private int age = 12;
	private User user;
	private boolean flag = true;
	private void function(){
		int test;
	}
}
public class Reflect {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException{
		User user = new User();
		Field fields[] = user.getClass().getDeclaredFields();
		for(Field f : fields){
			f.setAccessible(true);
			System.out.println(f.getType()+" "+f.getName()+" "+f.get(user));
			//String name = f.getName();
			
		}
	}
}
