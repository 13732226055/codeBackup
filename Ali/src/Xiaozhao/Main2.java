package Xiaozhao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.CORBA.PRIVATE_MEMBER;

/** 
* @author ZYJ 
* @version 创建时间：2017年8月25日 下午7:41:42 
* @Details 
*/
public class Main2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner("1001;1;ZJ;2;SH;7.5\r\n" + 
        		"1002;2;SH;1;ZJ;7.5");
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            							//线路ID编码;出分拨中心; 出分拨中心所在省;到达分拨中心;到达分拨中心所在省；车型；
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
    	List<String> result = new ArrayList<String>();
    	Map<String, List<String>> provinces = 

    	
    	return result;
    }
    private static class Province{
    	private List<Center> centers;
    	private String Pro;
    	
    }
    private static class Center{
    	private String cen;
    	private List<UnilateralLine> lines;
    }
public static class UnilateralLine {
	private String id;
	private String sCen;//出发分拨
	private String sPro;//出发省
	private String eCen;//到达分拨
	private String ePro;//到达省
	//9.6m/17.5m
	private String tType;//车型
	public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
	            this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getSCen() {return sCen;}
	public void setSCen(String ePro) {this.ePro = ePro;}
	public String getSPro() {return sPro;}
	public void setSPro(String sPro) {this.sPro = sPro;}
	public String getECen() {return eCen;}
	public void setECen(String eCen) {this.eCen = eCen;}
	public String getEPro() {return ePro;}
	public void setEPro(String ePro) {this.ePro = ePro;}
	public String getTType() {return tType;}
	public void setTType(String tType) {this.tType = tType;}
	}
}