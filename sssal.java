import java.util.*;

public class sssal {
    // Define the Edge class to represent a connection between two vertices with a weight
    static class Edge {
        int target, weight; // Target vertex and weight of the edge

        Edge(int target, int weight) {
            this.target = target; // Target vertex the edge points to
            this.weight = weight; // Cost associated with the edge
        }
    }

    // Helper method to find the vertex with the minimum distance that hasn't been visited
    static int min_dist(int[] dist, boolean[] visited) {
        int minimum = Integer.MAX_VALUE; // Initialize to maximum possible value
        int ind = -1; // Store index of the vertex with the minimum distance
        for (int k = 0; k < dist.length; k++) {
            // Check for unvisited vertex with a smaller distance
            if (!visited[k] && dist[k] <= minimum) {
                minimum = dist[k]; // Update minimum distance
                ind = k; // Update index of the vertex
            }
        }
        return ind; // Return the index of the vertex with the minimum distance
    }

    // Implementation of Dijkstra's algorithm using adjacency list
    static void greedy_dijkstra(List<List<Edge>> graph, int src) {
        int V = graph.size(); // Number of vertices
        int[] dist = new int[V]; // Array to store distances from the source
        boolean[] visited = new boolean[V]; // Array to track visited vertices

        // Initialize distances to infinity and visited array to false
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        dist[src] = 0; // Distance from source to itself is 0

        // Loop through all vertices to calculate shortest paths
        for (int k = 0; k < V; k++) {
            // Find the vertex with the smallest distance
            int u = min_dist(dist, visited);
            if (u == -1) break; // Break if no vertex is reachable
            visited[u] = true; // Mark the vertex as visited

            // Iterate through all neighbors of the vertex
            for (Edge edge : graph.get(u)) {
                int v = edge.target; // Neighbor vertex
                int weight = edge.weight; // Weight of the edge
                // Relax the edge: update distance if a shorter path is found
                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight; // Update distance
                }
            }
        }

        // Print the shortest distances from the source
        System.out.println("Vertex\t\tdist from source vertex");
        for (int i = 0; i < V; i++) {
            char str = (char) (65 + i); // Convert vertex index to letter (A, B, C, etc.)
            System.out.println(str + "\t\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>(); // Initialize graph as adjacency list

        // Create an empty list for each vertex
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph (connections between vertices)
        graph.get(0).add(new Edge(1, 1)); // A -> B (weight 1)
        graph.get(0).add(new Edge(2, 2)); // A -> C (weight 2)

        graph.get(1).add(new Edge(0, 1)); // B -> A (weight 1)
        graph.get(1).add(new Edge(3, 5)); // B -> D (weight 5)
        graph.get(1).add(new Edge(4, 1)); // B -> E (weight 1)

        graph.get(2).add(new Edge(0, 2)); // C -> A (weight 2)
        graph.get(2).add(new Edge(3, 2)); // C -> D (weight 2)
        graph.get(2).add(new Edge(4, 3)); // C -> E (weight 3)

        graph.get(3).add(new Edge(1, 5)); // D -> B (weight 5)
        graph.get(3).add(new Edge(2, 2)); // D -> C (weight 2)
        graph.get(3).add(new Edge(4, 2)); // D -> E (weight 2)
        graph.get(3).add(new Edge(5, 2)); // D -> F (weight 2)

        graph.get(4).add(new Edge(1, 1)); // E -> B (weight 1)
        graph.get(4).add(new Edge(2, 3)); // E -> C (weight 3)
        graph.get(4).add(new Edge(3, 2)); // E -> D (weight 2)
        graph.get(4).add(new Edge(5, 1)); // E -> F (weight 1)

        graph.get(5).add(new Edge(3, 2)); // F -> D (weight 2)
        graph.get(5).add(new Edge(4, 1)); // F -> E (weight 1)

        // Run Dijkstra's algorithm from the source vertex A (index 0)
        greedy_dijkstra(graph, 0);
    }
}
