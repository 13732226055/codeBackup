import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;

public class FindQuery {
	int count=0,max=0;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FindQuery FQ = new FindQuery();
		String query="acbaca";
		String text ="acaccbabbbabcca";
		long starttime = System.currentTimeMillis();
		int x;
		//x = FQ.LongestQuery(query, text);
		x =FQ.GetLCSLength(query,text);
		//TimeUnit.MILLISECONDS.sleep(100);;
		long exectime = System.currentTimeMillis()-starttime;
		System.out.println("time:"+exectime+" num:"+x);
		
	}
	private int GetLCSLength(String query, String text) {
		// TODO Auto-generated method stub
		int lq = query.length();
		int lt = text.length();
		int max=0;
		char[] q = query.toCharArray();
		char[] t = text.toCharArray();
		int count[][] = new int[lq][lt];
		for(int i=0;i<lq;i++){
			for(int j=0;j<lt;j++){
				if(q[i]==t[j]){
					count[i][j]= (i>0&&j>0)? count[i-1][j-1]+1:1;
					max = (count[i][j]<max)? max:count[i][j];
				}
			}
		}
		return max;
	}
	public int LongestQuery(String query,String text){
		int i=0;
		String minQuery = query.substring(0, 1);
		for(;i<query.length();i++){
			count=0;
			findQuery(text,query, i, i+1);
			minQuery = query.substring(i, i+1);
		}
		return max;
	}
	public void findQuery(String text,String query,int start,int end){
		if(end>query.length()) return;
		String subQuery = query.substring(start, end);
		if(text.contains(subQuery)) {
			count++;
			//System.out.println("count:"+count+" sub:"+subQuery+" start:"+start+" end:"+end);
			findQuery(text, query, start, end+1);
		}
		if(count>max) max=count;
	}

}
