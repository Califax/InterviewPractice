package HackerRank;

import java.util.*;

public class CityConnections {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        Map<Integer, Node> nodes;
        for(int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int m = in.nextInt(); // num cities
            int x = in.nextInt();
            int y = in.nextInt();
            nodes = new HashMap<>();
            for (int i = 0; i <= n; i++) {
                nodes.put(i+1, new Node(i+1));
            }
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                nodes.get(city_1).edges.add(nodes.get(city_2));
                nodes.get(city_2).edges.add(nodes.get(city_1));
            }
            System.out.println(CityConnections.costToConnect(n, m, x, y, nodes));
        }
    }

    static int costToConnect(int numCities, int numRoads, int libraryCost, int roadCost, Map<Integer, Node> nodes) {
        int cost = 0;
        if (libraryCost <= roadCost) {
            return numCities * libraryCost;
        }

        Set<Integer> visitedList = new HashSet<>();

        for (Node node : nodes.values()) {
            if (visitedList.contains(node.num)) {
                continue;
            }
            if (node.edges.isEmpty()) {
                cost += libraryCost;
                visitedList.add(node.num);
            } else {
                cost += (CityConnections.numConnectedNodes(node, visitedList) - 1) * roadCost + libraryCost;
            }
        }
        return cost;

        // num components : for each component: size(component) - 1 * roadcost + libraryCost
    }

    static int numConnectedNodes(Node node, Set<Integer> visitedList) {

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        int numNodes = 0;

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            if (!visitedList.contains(curr.num)) {
                numNodes++;
                visitedList.add(curr.num);
            }

            for (Node neighbor : curr.edges) {
                if (!visitedList.contains(neighbor.num)) {
                    stack.push(neighbor);
                }
            }
        }
        return numNodes;

    }

    private static class Node {
        int num;
        List<Node> edges;
        boolean containsLibrary;

        public Node(int num) {
            this.num = num;
        }
    }

}

