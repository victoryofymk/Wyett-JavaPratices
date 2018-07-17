package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TopKAlgorithm {
	public HashMap<String, Integer> hmap = new HashMap<String, Integer>();

	public void hashcode() {
	};

	public void traverseValue(String[] args) {
		for (String str : args) {
			if (!hmap.containsKey(str)) {
				hmap.put(str, 1);
			} else {
				hmap.put(str, hmap.get(str) + 1);
			}
		}
	}

	public String[] getTop() {
		Map<String, Integer> hashMap = new HashMap<String, Integer>(hmap);
		String[] strs = new String[hmap.size()];
		for (int i = 0; i < hmap.size(); i++) {
			Iterator<Entry<String, Integer>> itor = hashMap.entrySet().iterator();
			while (itor.hasNext()) {
				Entry<String, Integer> entry = itor.next();
				if (strs[i] == null || strs[i].isEmpty()) {
					strs[i] = entry.getKey();
				} else {
					if (hashMap.get(strs[i]) < entry.getValue()) {
						strs[i] = entry.getKey();
					}
				}
			}
			hashMap.remove(strs[i]);
		}
		return strs;

	}

	public static void main(String[] args) {
		TopKAlgorithm topk = new TopKAlgorithm();
		String[] strs = new String[] { "NBA", "abc", "bca", "cba", "cba", "bac" };
		topk.traverseValue(strs);
		String[] strings = topk.getTop();
		for (String str : strings) {
			System.out.println(str + ":" + topk.hmap.get(str));

		}
	}
}
