class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int totalSwaps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelValues = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            totalSwaps += countSwapsToSort(levelValues);
        }

        return totalSwaps;
    }

    private int countSwapsToSort(List<Integer> values) {
        int n = values.size();
        int[] arr = values.stream().mapToInt(i -> i).toArray();
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == sortedArr[i]) {
                continue;
            }

            int cycleSize = 0;
            int current = i;

            while (!visited[current]) {
                visited[current] = true;
                int next = indexMap.get(sortedArr[current]);
                current = next;
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }
}
