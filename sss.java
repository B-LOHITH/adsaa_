
class Dijkstra {
    public static void main(String args[]) {
        int graph[][] = {
            {0, 50,45,10, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 0, 10,15, Integer.MAX_VALUE, Integer.MAX_VALUE,},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0,Integer.MAX_VALUE, 30, Integer.MAX_VALUE},
            {20, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 15, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, 20, 35,Integer.MAX_VALUE,0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,3, 0}
        };

        int vertices = graph.length; // Number of vertices
        int source = 0; // Source vertex

        int[] dist = new int[vertices]; // Distance array
        boolean[] visited = new boolean[vertices]; // Visited array

        // Initialize distances from the source
        for (int i = 0; i < vertices; i++) {
            dist[i] = graph[source][i];
        }
        visited[source] = true; // Mark the source as visited

        // Loop to process all vertices
        for (int j = 1; j < vertices; j++) {
            int u = -1; // Vertex with minimum distance
            int min = Integer.MAX_VALUE;

            // Find the unvisited vertex with the smallest distance
            for (int k = 0; k < vertices; k++) {
                if (!visited[k] && dist[k] < min) {
                    min = dist[k];
                    u = k;
                }
            }

            // Break the loop if no valid vertex is found
            if (u == -1) {
                break; // All reachable vertices have been visited
            }

            visited[u] = true; // Mark the chosen vertex as visited

            // Update distances of neighbors of the chosen vertex
            for (int i = 0; i < vertices; i++) {
                if (!visited[i] && graph[u][i] != Integer.MAX_VALUE && dist[u] + graph[u][i] < dist[i]) {
                    dist[i] = dist[u] + graph[u][i];
                }
            }
        }

        // Print the shortest distances
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + " is at a distance of " + dist[i]);
        }
    }
}
