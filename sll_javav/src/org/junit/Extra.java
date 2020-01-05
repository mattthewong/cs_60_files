package org.junit;

public class Extra {
	
	public int getmusiclengthtime(){
		List musicList = new List();
		musicList.add("A");
		musicList.add("B");
		musicList.add("C");
		musicList.add("D#");
		musicList.add("E");
		musicList.add("F");
		musicList.add("C");
		List musicList1 = new List();
		musicList1.add("A");
		musicList1.add("B");
		musicList1.add("Gb");
		musicList1.add("E");
		musicList1.add("A");
		musicList1.add("F");
		musicList1.add("A");
		List musicList2 = new List();
		musicList2.add("D");
		musicList2.add("A");
		musicList2.add("C");
		musicList2.add("A");
		musicList2.add("E");
		musicList2.add("A");
		musicList2.add("B");
		int combinedtime = musicList.length() + musicList1.length() + musicList2.length();
		return combinedtime;
		}
}
