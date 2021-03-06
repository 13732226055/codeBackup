import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.w3c.dom.ls.LSInput;

public class HeapSortCal {
	public void maxHeap(int[] list,int parent,int point){
		
		int lchild = parent<<1; //左孩子为父节点×2
		int rchild =(parent<<1)+1;
		int largest = parent;
		//找出一颗子树中最大的节点
		largest = (lchild<=point && list[lchild]>list[largest])? ((rchild<=point && list[rchild]>list[lchild])? rchild:lchild):parent;
//		if(lchild<=point && list[lchild]>list[largest]){
//			largest=lchild;
//		}
//		if(rchild<=point && list[rchild]>list[largest]){
//			largest = rchild;
//		}
		if(largest!=parent){
			int tmp = list[parent];
			list[parent] = list[largest];
			list[largest]=tmp;
			maxHeap(list, largest, point);
		}
	}
	public void build_maxHeap(int[] list,int point){
		for(int i =point/2;i>0;i--){
			maxHeap(list, i, point);
		}
	}
	public void heapSort(int list[],int point){
		while(point>=1){
			
			int tmp=list[point];
			list[point]=list[1];
			list[1]=tmp;
			
			maxHeap(list, 1, --point);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int list[]=new int[10];
		list[1]=1;
		list[2]=5;
		list[3]=4;
		list[4]=2;
		list[5]=7;
		list[6]=0;
		list[7]=8;
		for(int i=1;i<=7;i++)
			System.out.print(list[i]);
		System.out.println("");
		HeapSortCal hs=new HeapSortCal();
		hs.build_maxHeap(list, 7);
		countWays.breath(list);
		hs.heapSort(list, 7);
		for(int i=1;i<=7;i++)
			System.out.print(list[i]);
	}

}
