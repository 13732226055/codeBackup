
public class TestHashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h=11;
		String key="11aaaa";
		System.out.println(Integer.toBinaryString(key.hashCode()));
		System.out.println(Integer.toBinaryString((h = key.hashCode())>>>16));
		System.out.println(Integer.toBinaryString((h = key.hashCode()) ^ (h >>> 16)));
		System.err.println(Integer.toBinaryString("11a".hashCode()));
		
	}

}
