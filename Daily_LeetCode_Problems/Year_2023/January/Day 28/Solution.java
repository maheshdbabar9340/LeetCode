class SummaryRanges {
    Map<Integer, Integer> q;
    public SummaryRanges() {
        q = new TreeMap<Integer, Integer>();
    }
    
    public void addNum(int val) {
		q.put(val, val);
	}

	public int[][] getIntervals() {
		List<int[]> ans = new ArrayList<int[]>();
		int start = -1, end = -1;

		for (int i : q.keySet()) {
			if (start == -1) {
				start = i;
				end = i;
			} else {
				if (i - end != 1) {
					ans.add(new int[] { start, end });
					start = i;
					end = i;
				} else {
					end = i;
				}
			}
		}

		ans.add(new int[] { start, end });

		int[][] a = new int[ans.size()][2];
		int idx = 0;
		for (int[] i : ans) {
			a[idx++] = i;
		}

		return a;
	}
}
