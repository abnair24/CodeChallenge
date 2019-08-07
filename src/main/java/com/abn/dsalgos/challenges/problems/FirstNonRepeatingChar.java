package com.abn.dsalgos.challenges.problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		String str = "teeter";
		Map<Character,Integer> lhm = new LinkedHashMap<Character,Integer>();
		
		for(char c: str.toCharArray())
		{
			Integer i = lhm.get(c);
			
			if(i==null) {
				lhm.put(c, 1);
			}
			
			else {
				lhm.put(c, ++i);
				
			}
		}
		
		
		for(Entry<Character, Integer>ent:lhm.entrySet())
		{
			if(ent.getValue()==1) {
				System.out.println(ent.getKey());
				break;
			}
		}

	}

}
