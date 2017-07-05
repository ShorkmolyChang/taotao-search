package com.taotao.search.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Compare {

	
	public static void printMap(){
		for(Entry<Integer, DoubleLinkNode> entry:map.entrySet()){
			DoubleLinkNode node=entry.getValue();
			DoubleLinkNode node1=node;
			while(node1.lessNode!=null){
				node1=node1.lessNode;
				System.out.print(node1.num+" ");
			}
			System.out.print("["+node.num+"]");
			DoubleLinkNode node2=node;
			while(node2.moreNode!=null){
				node2=node2.moreNode;
				System.out.print(node2.num+" ");
			}
			System.out.println();
		}
	}
	public static void main(String... args){
		
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		int n1=in.nextInt();
		int n2=in.nextInt();
		int[][] records=new int[num][2];
		for(int i=0;i<num;i++){
			int more=in.nextInt();
			int less=in.nextInt();
			records[i][0]=more;
			records[i][1]=less;
		}
		System.out.println(cmp(n1,n2,records,num));
	}
	
	static Map<Integer, DoubleLinkNode> map=new HashMap<Integer, DoubleLinkNode>();
	 public static int cmp(int g1, int g2, int[][] records, int n){
		 for(int i=0;i<records.length;i++){
				int more=records[i][0];
				int less=records[i][1];
				if(map.get(more)==null){
					DoubleLinkNode node=new DoubleLinkNode(less);
					DoubleLinkNode first=new DoubleLinkNode(more);
					first.lessNode=node;
					map.put(more, first);
				}else{
					DoubleLinkNode node=map.get(more);
					while(node.lessNode!=null)
						node=node.lessNode;
					node.lessNode=new DoubleLinkNode(less);
				}
				if(map.get(less)==null){
					DoubleLinkNode node=new DoubleLinkNode(more);
					DoubleLinkNode first=new DoubleLinkNode(less);
					first.moreNode=node;
					map.put(less, first);
				}else{
					DoubleLinkNode node=map.get(less);
					while(node.moreNode!=null)
						node=node.moreNode;
					node.moreNode=new DoubleLinkNode(more);
				}
			}
		 return CompareWeight(g1, g2);
	 }

	
	
	
	public static int CompareWeight(int n1 ,int n2){
		
		boolean more=traverse(1, n1, n2);
		if(more)
			return 1;
		boolean less=traverse(0, n1, n2);
		if(less)
			return -1;
		return 0;
	}
	
	public static boolean traverse(int type,int n1,int n2){
		if(n1==n2)
			return true;
		DoubleLinkNode node=map.get(n1);
		while(node!=null){
			if(type==0)
				node=node.lessNode;
			else
				node=node.moreNode;
			if(node==null)
				return false;
			
			System.out.println(node.num);
			
			boolean flag=traverse(type, node.num, n2);
			if(flag)
				return true;
		}
		return false;
	}

}


class DoubleLinkNode{
	DoubleLinkNode moreNode;
	DoubleLinkNode lessNode;
	int num;
	
	public DoubleLinkNode(int num,DoubleLinkNode moreNode,DoubleLinkNode lessNode){
		this.num=num;
		this.moreNode=moreNode;
		this.lessNode=lessNode;
	}
	
	public DoubleLinkNode(int num){
		this.num=num;
		this.moreNode=null;
		this.lessNode=null;
	}

	public DoubleLinkNode getMoreNode() {
		return moreNode;
	}

	public void setMoreNode(DoubleLinkNode moreNode) {
		this.moreNode = moreNode;
	}

	public DoubleLinkNode getLessNode() {
		return lessNode;
	}

	public void setLessNode(DoubleLinkNode lessNode) {
		this.lessNode = lessNode;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
